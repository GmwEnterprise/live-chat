package com.github.mrag.livechat.rest.validator;

import com.github.mrag.livechat.common.cache.api.DictService;
import com.github.mrag.livechat.common.validation.DataConstraintValidator;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.stereotype.Component;

/**
 * @author Gmw
 */
@Component
public class DataConstraintValidatorImpl implements DataConstraintValidator {
    @DubboReference
    private DictService dictService;

    @Override
    public boolean isDictionaryValid(String key, Integer value) {
        return dictService.kvExists(key, value);
    }
}
