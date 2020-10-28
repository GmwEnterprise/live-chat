package com.github.mrag.livechat.enums;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonValue;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum ReceiverType {
    USER(1, "用户"),
    GROUP(2, "群");

    private final int    key;
    private final String value;

    ReceiverType(int key, String value) {
        this.key   = key;
        this.value = value;
    }

    @JsonValue
    public static ReceiverType find(int key) {
        for (ReceiverType item : values()) {
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
