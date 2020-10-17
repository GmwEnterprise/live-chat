package com.github.mrag.livechat.enums;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * @author Gmw
 */
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum Gender {
    MEN(1, "男"),
    WOMEN(2, "女"),
    SECRET(3, "保密");

    private final int key;
    private final String value;

    Gender(int key, String value) {
        this.key = key;
        this.value = value;
    }

    @JsonValue
    public static Gender find(int key) {
        for (Gender item : values()) {
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
