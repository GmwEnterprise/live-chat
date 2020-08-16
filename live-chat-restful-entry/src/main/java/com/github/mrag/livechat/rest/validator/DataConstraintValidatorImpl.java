package com.github.mrag.livechat.rest.validator;

import com.github.mrag.livechat.common.validation.DataConstraintValidator;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidatorContext;

/**
 * @author Gmw
 */
@Component
public class DataConstraintValidatorImpl implements DataConstraintValidator {

    @Override
    public boolean isDictionaryValid(Object value, ConstraintValidatorContext context) {
        // TODO
        return false;
    }
}
