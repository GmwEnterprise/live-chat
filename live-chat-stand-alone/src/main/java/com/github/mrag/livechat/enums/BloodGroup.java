package com.github.mrag.livechat.enums;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * @author Gmw
 */
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum BloodGroup {
    A(1, "A"),
    B(2, "B"),
    O(3, "O"),
    AB(4, "AB");

    private final int key;
    private final String value;

    BloodGroup(int key, String value) {
        this.key = key;
        this.value = value;
    }

    @JsonValue
    public static BloodGroup find(int key) {
        for (BloodGroup item : values()) {
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
