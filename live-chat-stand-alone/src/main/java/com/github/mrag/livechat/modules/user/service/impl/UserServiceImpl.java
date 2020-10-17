package com.github.mrag.livechat.modules.user.service.impl;

import com.github.mrag.livechat.common.Encryption;
import com.github.mrag.livechat.modules.user.entity.LivechatUser;
import com.github.mrag.livechat.modules.user.service.UserService;
import org.apache.commons.codec.binary.Hex;
import org.apache.commons.codec.digest.DigestUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

@Service
public class UserServiceImpl implements UserService {
    private static final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);

    @Override
    public void modify(LivechatUser user) {

    }

    @Override
    public String signInUser(String key, String password) {
        return null;
    }

    @Override
    public boolean checkPhoneExists(String phone) {
        return false;
    }

    @Override
    public String findUserHashById(long userId) {
        return null;
    }

    @Override
    public String registry(LivechatUser detail) {
        return null;
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
}
