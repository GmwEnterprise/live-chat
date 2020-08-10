package com.github.mrag.livechat.common;

import org.springframework.beans.BeanUtils;

import java.lang.reflect.Constructor;

public final class Tools {

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
}
