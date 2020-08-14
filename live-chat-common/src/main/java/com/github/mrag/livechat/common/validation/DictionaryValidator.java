package com.github.mrag.livechat.common.validation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @author Gmw
 */
public class DictionaryValidator implements ConstraintValidator<Dictionary, Object> {
    private static final Logger log = LoggerFactory.getLogger(DictionaryValidator.class);

    /*
     * 只有类路径中有springmvc相关的包，validator相关的bean才会被加载
     */

    private final DataConstraintValidator dataConstraintValidator;

    public DictionaryValidator(DataConstraintValidator dataConstraintValidator) {
        this.dataConstraintValidator = dataConstraintValidator;
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        return dataConstraintValidator.isDictionaryValid(value, context);
    }
}
