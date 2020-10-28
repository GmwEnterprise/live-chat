package com.github.mrag.livechat.enums;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonValue;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum MessageType {
    TEXT(1, "文本"),
    IMAGE(2, "图片"),
    FILE(3, "文件"),
    EMOJI(4, "表情");

    private final int    key;
    private final String value;

    MessageType(int key, String value) {
        this.key   = key;
        this.value = value;
    }

    @JsonValue
    public static MessageType find(int key) {
        for (MessageType item : values()) {
            if (item.key == key) {
                return item;
            }
        }
        return null;
    }

    public int getKey() {
        return key;
    }

    public String getValue() {
        return value;
    }
}
