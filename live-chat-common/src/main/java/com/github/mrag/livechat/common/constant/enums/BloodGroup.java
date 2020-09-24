package com.github.mrag.livechat.common.constant.enums;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author Gmw
 */
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum BloodGroup implements DictEnumInterface {
    A(1, "A"), B(2, "B"),
    O(3, "O"), AB(4, "AB");

    @ApiModelProperty(value = "键")
    private final String key;
    @ApiModelProperty(value = "键描述")
    private final String keyDesc;
    @ApiModelProperty(value = "值")
    private final int valueNo;
    @ApiModelProperty(value = "值描述")
    private final String valueDesc;

    BloodGroup(int valueNo, String valueDesc) {
        this.key = "bloodGroup";
        this.keyDesc = "血型";
        this.valueNo = valueNo;
        this.valueDesc = valueDesc;
    }

    @JsonValue
    public static BloodGroup findByValue(int valueNo) {
        for (BloodGroup item : values()) {
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
        return "BloodGroup{" +
                "key='" + key + '\'' +
                ", keyDesc='" + keyDesc + '\'' +
                ", valueNo=" + valueNo +
                ", valueDesc='" + valueDesc + '\'' +
                '}';
    }
}
