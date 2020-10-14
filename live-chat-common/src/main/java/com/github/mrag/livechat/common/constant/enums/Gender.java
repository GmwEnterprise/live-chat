package com.github.mrag.livechat.common.constant.enums;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author Gmw
 */
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum Gender implements DictEnumInterface {
    MEN(1, "男"),
    WOMEN(2, "女"),
    SECRET(3, "保密");

    @ApiModelProperty(value = "键")
    private final String key;
    @ApiModelProperty(value = "键描述")
    private final String keyDesc;
    @ApiModelProperty(value = "值")
    private final int valueNo;
    @ApiModelProperty(value = "值描述")
    private final String valueDesc;

    Gender(int valueNo, String valueDesc) {
        this.key = "gender";
        this.keyDesc = "性别";
        this.valueNo = valueNo;
        this.valueDesc = valueDesc;
    }

    @JsonValue
    public static Gender findByValue(int valueNo) {
        for (Gender item : values()) {
            if (item.valueNo == valueNo) {
                return item;
            }
        }
        return null;
    }

    @Override
    public String getKey() {
        return key;
    }

    @Override
    public String getKeyDesc() {
        return keyDesc;
    }

    @Override
    public int getValueNo() {
        return valueNo;
    }

    @Override
    public String getValueDesc() {
        return valueDesc;
    }

    @Override
    public String toString() {
        return "Gender{" +
                "key='" + key + '\'' +
                ", keyDesc='" + keyDesc + '\'' +
                ", valueNo=" + valueNo +
                ", valueDesc='" + valueDesc + '\'' +
                '}';
    }
}
