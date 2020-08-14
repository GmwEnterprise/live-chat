package com.github.mrag.livechat.common.utils;

import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.util.StringUtils;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Constructor;
import java.nio.charset.StandardCharsets;

/**
 * @author Gmw
 */
public final class Tools {
    private static final Logger log = LoggerFactory.getLogger(Tools.class);

    public static <S, T> T copyProperties(S source, Class<T> targetType) {
        try {
            Constructor<T> targetTypeConstructor = targetType.getConstructor();
            T target = targetTypeConstructor.newInstance();
            BeanUtils.copyProperties(source, target);
            return target;
        } catch (Throwable e) {
            throw new RuntimeException(String.format("拷贝属性失败, sourceType=%s, targetType=%s",
                    source.getClass(), targetType), e);
        }
    }

    public static void printInputStream(InputStream inputStream) throws IOException {
        String body = IOUtils.toString(inputStream, StandardCharsets.UTF_8);
        if (StringUtils.isEmpty(body)) {
            log.info("request body is empty.");
        } else {
            log.info("\nRequest body:\n---\n{}\n---\n", body);
        }
    }
}
