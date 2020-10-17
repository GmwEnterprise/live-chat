package com.github.mrag.livechat.rest.converters;

import com.github.mrag.livechat.common.ApiException;
import com.github.mrag.livechat.common.constant.enums.BloodGroup;
import org.springframework.core.convert.converter.Converter;

public class BloodGroupConverter implements Converter<String, BloodGroup> {

    @Override
    public BloodGroup convert(String source) {
        try {
            return BloodGroup.findByValue(Integer.parseInt(source));
        } catch (ClassCastException e) {
            throw ApiException.unexpectedParameters("当前格式[string]; 需要格式[int].");
        }
    }
}