package com.github.mrag.livechat.usermsg.service;

import com.github.mrag.livechat.common.BusinessType;
import com.github.mrag.livechat.common.Encryption;
import com.github.mrag.livechat.common.RegExp;
import com.github.mrag.livechat.common.Tools;
import com.github.mrag.livechat.common.utils.SequenceUtils;
import com.github.mrag.livechat.usermsg.api.UserService;
import com.github.mrag.livechat.usermsg.dao.UserMapper;
import com.github.mrag.livechat.usermsg.dto.UserDTO;
import com.github.mrag.livechat.usermsg.entity.User;
import org.apache.commons.codec.binary.Hex;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.dubbo.config.annotation.DubboService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Resource;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.regex.Pattern;

/**
 * @author Gmw
 */
@DubboService
public class UserServiceImpl implements UserService {
    private static final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);

    @Resource
    private UserMapper userMapper;

    @Override
    public UserDTO findUserById(Long uid) {
        User entity = userMapper.selectByPrimaryKey(uid);
        if (entity == null) {
            return null;
        }
        return Tools.copyProperties(entity, UserDTO.class);
    }

    @Override
    public UserDTO findUserByChatNo(String chatNo) {
        User entity = userMapper.selectByChatNo(chatNo);
        if (entity == null) {
            return null;
        }
        return Tools.copyProperties(entity, UserDTO.class);
    }

    @Override
    public UserDTO save(UserDTO dto) {
        User user = Tools.copyProperties(dto, User.class);
        if (user.getId() == null) {
            // 注册
            user.setId(SequenceUtils.nextId(BusinessType.USER_BUSINESS));
            // 手机号码暂作用户名
            user.setUsername(user.getPhoneNumber());
            // 密码加盐加密
            String[] hashAndSalt = generatePasswordHashWithSalt(user.getUserPassword()).split("::");
            user.setUserPassword(hashAndSalt[0]);
            user.setSalt(hashAndSalt[1]);
            // 设置默认值 TODO
            userMapper.insertSelective(user);
        } else {
            userMapper.updateByPrimaryKeySelective(user);
        }
        return findUserById(user.getId());
    }

    /**
     * 对原始密码加盐，并返回哈希加密后的密码与盐值
     * <p>
     * http://commons.apache.org/proper/commons-codec/userguide.html
     *
     * @param originalPassword 原始密码
     * @return 加密哈希::盐
     */
    private String generatePasswordHashWithSalt(String originalPassword) {
        String encryptedHash, salt = "";

        // 计算盐
        try {
            SecureRandom rand = SecureRandom.getInstance("SHA1PRNG");
            byte[] saltBytes = new byte[16];
            rand.nextBytes(saltBytes);
            salt = Hex.encodeHexString(saltBytes).substring(0, 8);
        } catch (NoSuchAlgorithmException ignored) {
        }

        // 混淆密码 todo
        byte[] afterComputed = matrixMultiplication(originalPassword.getBytes(), salt.getBytes());
        String computedBinary = Encryption.binary(afterComputed, Character.MAX_RADIX);

        // 哈希加密 todo
        encryptedHash = DigestUtils.md5Hex(computedBinary);
        return encryptedHash + "::" + salt;
    }

    /**
     * 矩阵相乘
     *
     * @param m 横向向量
     * @param n 纵向向量
     * @return result
     */
    private byte[] matrixMultiplication(byte[] m, byte[] n) {
        // byte[][] matrix = new byte[m.length][n.length];
        byte[] result = new byte[m.length * n.length];
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < n.length; j++) {
                byte temp = (byte) (m[i] ^ n[j]);
                // matrix[i][j] = temp;
                result[i * n.length + j] = temp;
            }
        }
        return result;
    }

    // public static void main(String[] args) {
    //     UserServiceImpl t = new UserServiceImpl();
    //     System.out.println(t.generatePasswordHashWithSalt("123456"));
    //     System.out.println(t.generatePasswordHashWithSalt("acxswe"));
    //     System.out.println(t.generatePasswordHashWithSalt("gan1ming2wei3"));
    // }

    @Override
    public boolean checkPhoneExists(String phone) {
        if (!Pattern.matches(RegExp.REGEXP_PHONE, phone)) {
            throw new IllegalArgumentException(String.format("%s[%s]", RegExp.REGEXP_PHONE_MSG, phone));
        }
        return userMapper.countByPhoneNumber(phone) > 0;
    }
}
