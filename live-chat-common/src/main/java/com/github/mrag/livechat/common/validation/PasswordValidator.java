package com.github.mrag.livechat.common.validation;

import com.github.mrag.livechat.common.Encryption;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * 自定义校验密码
 *
 * @author Gmw
 */
public class PasswordValidator implements ConstraintValidator<Password, String> {
    private static final Logger log = LoggerFactory.getLogger(PasswordValidator.class);

    @Override
    public boolean isValid(String passwordBase64Code, ConstraintValidatorContext context) {
        if (StringUtils.isEmpty(passwordBase64Code)) {
            // 未填写password字段时则不校验
            return true;
        }
        String password = Encryption.aesDecrypt(passwordBase64Code, Encryption.AES_KEY);
        // 暂作简单校验
        return password.length() >= 4;
    }
}
