package com.github.mrag.livechat.enums;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * @author Gmw
 */
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum AccountStatus {
    USING(1, "使用中..."),
    BANNED(2, "禁用ing"),
    WRITTEN_OFF(3, "已注销");

    private final int    key;
    private final String value;

    AccountStatus(int key, String value) {
        this.key   = key;
        this.value = value;
    }

    @JsonValue
    public static AccountStatus find(int key) {
        for (AccountStatus item : values()) {
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
