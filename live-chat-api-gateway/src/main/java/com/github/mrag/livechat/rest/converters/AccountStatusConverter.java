package com.github.mrag.livechat.rest.converters;

import com.github.mrag.livechat.common.BusinessException;
import com.github.mrag.livechat.common.constant.enums.AccountStatus;
import org.springframework.core.convert.converter.Converter;

public class AccountStatusConverter implements Converter<String, AccountStatus> {
    @Override
    public AccountStatus convert(String source) {
        try {
            return AccountStatus.findByValue(Integer.parseInt(source));
        } catch (ClassCastException e) {
            throw BusinessException.unexpectedParameters("当前格式[string]; 需要格式[int].");
        }
    }
}