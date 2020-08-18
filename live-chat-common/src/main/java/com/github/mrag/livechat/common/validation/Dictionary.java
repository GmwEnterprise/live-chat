package com.github.mrag.livechat.common.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author Gmw
 */
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = DictionaryValidator.class)
public @interface Dictionary {
    String message() default "选值有误，请重新选择";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    String key();
}
