package com.github.mrag.livechat.rest.converters;

import com.github.mrag.livechat.common.BusinessException;
import org.springframework.core.convert.converter.Converter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class LocalDateTimeConverter implements Converter<String, LocalDateTime> {
    DateTimeFormatter f = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    @Override
    public LocalDateTime convert(String source) {
        try {
            return LocalDateTime.parse(source, f);
        } catch (DateTimeParseException e) {
            throw BusinessException.unexpectedParameters("时间格式转换失败! 收到的格式["
                    + source + "], 请使用标准字符串时间格式[yyyy-MM-dd HH:mm:ss]");
        }
    }
}
