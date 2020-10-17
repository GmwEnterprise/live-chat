package com.github.mrag.livechat.common.utils;

import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.util.StringUtils;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Constructor;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.function.BiConsumer;

/**
 * @author Gmw
 */
public final class Tools {
    private static final Logger log = LoggerFactory.getLogger(Tools.class);

    public static <S, T> T copyProperties(S source, Class<T> targetType) {
        return copyProperties(source, targetType, null);
    }

    public static <S, T> T copyProperties(S source, Class<T> targetType, BiConsumer<S, T> afterCopy) {
        try {
            Constructor<T> targetTypeConstructor = targetType.getConstructor();
            T target = targetTypeConstructor.newInstance();
            BeanUtils.copyProperties(source, target);
            if (afterCopy != null) {
                afterCopy.accept(source, target);
            }
            return target;
        } catch (Throwable e) {
            throw new RuntimeException(String.format("拷贝属性失败, sourceType=%s, targetType=%s",
                    source.getClass(), targetType), e);
        }
    }

    public static void printInputStream(InputStream inputStream) throws IOException {
        String body = IOUtils.toString(inputStream, StandardCharsets.UTF_8);
        if (StringUtils.isEmpty(body)) {
            log.info("InputStream is empty.");
        } else {
            log.info("\nInputStream:\n---\n{}\n---\n", body);
        }
    }

    @FunctionalInterface
    public interface FileHandler<R> {
        R handleFile(File file);
    }

    public static <R> List<R> handleFiles(File dir, FileHandler<R> handler) {
        return fileTreeRecursive(dir, handler, null);
    }

    private static <R> List<R> fileTreeRecursive(File dir, FileHandler<R> handler, List<R> resultList) {
        if (!dir.isDirectory()) {
            return null;
        }
        File[] items = dir.listFiles();
        if (items != null && items.length > 0) {
            if (resultList == null) {
                resultList = new ArrayList<>();
            }
            for (File item : items) {
                if (item.isFile()) {
                    R handleResult = handler.handleFile(item);
                    resultList.add(handleResult);
                } else if (item.isDirectory()) {
                    fileTreeRecursive(item, handler, resultList);
                }
            }
            return resultList;
        }
        return null;
    }
}
