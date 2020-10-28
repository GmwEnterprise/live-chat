package com.github.mrag.livechat.common;

/**
 * 处理没必要的 check exception
 */
public interface UndoCheckedException {

    default void exp(Consumer consumer) {
        try {
            consumer.accept();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    default <R> R exp(Supplier<R> wrapper) {
        try {
            return wrapper.get();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
