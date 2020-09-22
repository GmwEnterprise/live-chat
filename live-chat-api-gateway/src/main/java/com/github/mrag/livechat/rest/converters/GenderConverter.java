package com.github.mrag.livechat.rest.converters;

import com.github.mrag.livechat.common.BusinessException;
import com.github.mrag.livechat.common.constant.enums.Gender;
import org.springframework.core.convert.converter.Converter;

public class GenderConverter implements Converter<String, Gender> {
    @Override
    public Gender convert(String in) {
        try {
            return Gender.findByValue(Integer.parseInt(in));
        } catch (ClassCastException e) {
            throw BusinessException.unexpectedParameters("当前格式[string]; 需要格式[int].");
        }
    }
}
