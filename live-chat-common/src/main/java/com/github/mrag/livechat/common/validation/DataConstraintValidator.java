package com.github.mrag.livechat.common.validation;

import javax.validation.ConstraintValidatorContext;

/**
 * @author Gmw
 */
public interface DataConstraintValidator {

    boolean isDictionaryValid(String key, Integer value);
}
