package com.github.mrag.livechat.common;

public interface Encryption {

    String base64Encode(byte[] source);

    byte[] base64Decode(String base64String);
}
