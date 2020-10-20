package com.github.mrag.livechat.common;

@FunctionalInterface
public interface WrapperWithReturnValue<R> {

    R accept() throws Exception;
}
