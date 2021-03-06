package com.github.mrag.livechat.usermsg.service;

import com.github.mrag.livechat.common.ApiException;
import com.github.mrag.livechat.common.BusinessType;
import com.github.mrag.livechat.common.Encryption;
import com.github.mrag.livechat.common.constant.RegExp;
import com.github.mrag.livechat.common.constant.enums.AccountStatus;
import com.github.mrag.livechat.common.constant.enums.Gender;
import com.github.mrag.livechat.common.token.TokenPayload;
import com.github.mrag.livechat.common.token.TokenUtil;
import com.github.mrag.livechat.common.utils.SequenceUtils;
import com.github.mrag.livechat.common.utils.Tools;
import com.github.mrag.livechat.usermsg.api.UserService;
import com.github.mrag.livechat.usermsg.dao.UserMapper;
import com.github.mrag.livechat.usermsg.entity.User;
import com.github.mrag.livechat.usermsg.vo.UserDetail;
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
    public void modify(UserDetail detail) {
        User user = Tools.copyProperties(detail, User.class,
                (userVo, userEntity) -> userEntity.setId(Long.parseLong(userVo.getId())));
        userMapper.updateByPrimaryKeySelective(user);
    }

    @Override
    public String signInUser(String key, String password) {
        /*
         * key 微信号/手机号/邮箱
         * TODO: 低效率的执行方式，`where...or...`
         */
        User user = userMapper.selectByLoginKey(key);
        String realHash = user.getUserPassword();
        String salt = user.getSalt();

        // 核对密码
        if (checkPassword(realHash, salt, password)) {
            // 密码正确，登陆成功，返回用户信息以及token
            try {
                return TokenUtil.generateToken(new TokenPayload(user.getId(), realHash));
            } catch (Exception e) {
                log.error(e.getMessage(), e);
                throw ApiException.unknown();
            }
        }
        // 密码错误
        throw ApiException.incorrectPassword();
    }

    /**
     * 核对密码
     *
     * @param userHash      真实密码加密哈希
     * @param salt          密码盐
     * @param inputPassword 用户输入的密码
     * @return 是否正确
     */
    public boolean checkPassword(String userHash, String salt, String inputPassword) {
        byte[] afterComputed = matrixMultiplication(inputPassword.getBytes(), salt.getBytes());
        String computedBinary = Encryption.binary(afterComputed, Character.MAX_RADIX);
        String encryptedHash = DigestUtils.md5Hex(computedBinary);
        return encryptedHash.equals(userHash);
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
        String encryptedHash, salt;

        // 获取随机盐
        try {
            SecureRandom rand = SecureRandom.getInstance("SHA1PRNG");
            byte[] saltBytes = new byte[16];
            rand.nextBytes(saltBytes);
            salt = Hex.encodeHexString(saltBytes).substring(0, 8);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }

        // 混淆密码
        byte[] afterComputed = matrixMultiplication(originalPassword.getBytes(), salt.getBytes());
        String computedBinary = Encryption.binary(afterComputed, Character.MAX_RADIX);

        // 哈希加密
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

    @Override
    public boolean checkPhoneExists(String phone) {
        if (!Pattern.matches(RegExp.REGEXP_PHONE, phone)) {
            throw new IllegalArgumentException(String.format("%s[%s]", RegExp.REGEXP_PHONE_MSG, phone));
        }
        return userMapper.countByPhoneNumber(phone) > 0;
    }

    @Override
    public String findUserHashById(long userId) {
        return userMapper.selectUserPasswordByUserId(userId);
    }

    @Override
    public String registry(UserDetail detail) {
        User user = Tools.copyProperties(detail, User.class);
        user.setId(SequenceUtils.nextId(BusinessType.USER_BUSINESS));
        // 手机号码暂作用户名
        user.setUsername(user.getPhoneNumber());
        // 密码加盐加密
        String[] hashAndSalt = generatePasswordHashWithSalt(user.getUserPassword()).split("::");
        user.setUserPassword(hashAndSalt[0]);
        user.setSalt(hashAndSalt[1]);
        user.setGender(Gender.MEN);
        user.setAccountStatus(AccountStatus.USING);

        userMapper.insertSelective(user);
        try {
            // 注册成功，返回用户信息以及token
            return TokenUtil.generateToken(new TokenPayload(user.getId(), hashAndSalt[0]));
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw ApiException.unknown();
        }
    }
}
