package com.github.mrag.livechat.enums;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonValue;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum UserRelationState {
    NORMAL_FRIEND(1, "好友"),
    BLACKLIST(2, "拉黑"),
    IGNORE_MESSAGE(3, "屏蔽消息"),
    CARE(4, "关心");

    private final int key;
    private final String value;

    UserRelationState(int key, String value) {
        this.key = key;
        this.value = value;
    }

    @JsonValue
    public static UserRelationState find(int key) {
        for (UserRelationState item : values()) {
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
