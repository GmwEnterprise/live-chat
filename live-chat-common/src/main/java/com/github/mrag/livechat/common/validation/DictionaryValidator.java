package com.github.mrag.livechat.common.validation;

import org.hibernate.validator.internal.engine.constraintvalidation.ConstraintValidatorContextImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.lang.annotation.Annotation;

/**
 * @author Gmw
 */
public class DictionaryValidator implements ConstraintValidator<Dictionary, Integer> {
    private static final Logger log = LoggerFactory.getLogger(DictionaryValidator.class);

    /*
     * 只有类路径中有springmvc相关的包，validator相关的bean才会被加载
     */

    private final DataConstraintValidator dataConstraintValidator;

    public DictionaryValidator(DataConstraintValidator dataConstraintValidator) {
        this.dataConstraintValidator = dataConstraintValidator;
    }

    @Override
    public boolean isValid(Integer value, ConstraintValidatorContext context) {
        Annotation anno = ((ConstraintValidatorContextImpl) context).getConstraintDescriptor().getAnnotation();
        return dataConstraintValidator.isDictionaryValid(((Dictionary) anno).key(), value);
    }
}
