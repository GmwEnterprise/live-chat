package com.github.mrag.livechat.common;

public interface ExceptionWrapper {

    /*
     * 处理没必要的 check exception
     */

    default void exp(Wrapper wrapper) {
        try {
            wrapper.accept();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    default <R> R exp(WrapperWithReturnValue<R> wrapper) {
        try {
            return wrapper.accept();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
