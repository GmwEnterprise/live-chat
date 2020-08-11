package com.github.mrag.livechat.usermsg.service;

import com.github.mrag.livechat.common.BusinessType;
import com.github.mrag.livechat.common.RegExp;
import com.github.mrag.livechat.common.Tools;
import com.github.mrag.livechat.common.utils.SequenceUtils;
import com.github.mrag.livechat.usermsg.api.UserService;
import com.github.mrag.livechat.usermsg.dao.UserMapper;
import com.github.mrag.livechat.usermsg.dto.UserDTO;
import com.github.mrag.livechat.usermsg.entity.User;
import org.apache.commons.codec.binary.Hex;
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
     *
     * @param originalPassword 原始密码
     * @return 加密哈希::盐
     */
    private String generatePasswordHashWithSalt(String originalPassword) {
        String encryptedHash = "", salt;

        // 计算盐
        try {
            SecureRandom rand = SecureRandom.getInstance("SHA1PRNG");
            byte[] saltBytes = new byte[16];
            rand.nextBytes(saltBytes);
            salt = Hex.encodeHexString(saltBytes);
        } catch (NoSuchAlgorithmException e) {
            log.warn("SecureRandom cannot got the algorithm[SHA1PRNG]");
            salt = String.valueOf(SequenceUtils.nextId(BusinessType.ENCRYPTION_BUSINESS))
                    .substring(0, 16);
        }

        // 混淆密码 todo
        
        // http://commons.apache.org/proper/commons-codec/userguide.html

        // 哈希加密 todo

        return encryptedHash + "::" + salt;
    }

    @Override
    public boolean checkPhoneExists(String phone) {
        if (!Pattern.matches(RegExp.REGEXP_PHONE, phone)) {
            throw new IllegalArgumentException(String.format("%s[%s]", RegExp.REGEXP_PHONE_MSG, phone));
        }
        return userMapper.countByPhoneNumber(phone) > 0;
    }
}
