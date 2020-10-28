package com.github.mrag.livechat.common;

@FunctionalInterface
public interface Supplier<R> {

    R get() throws Exception;
}
