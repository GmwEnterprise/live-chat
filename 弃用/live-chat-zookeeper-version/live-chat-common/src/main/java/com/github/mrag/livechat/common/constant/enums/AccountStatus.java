package com.github.mrag.livechat.common.constant.enums;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author Gmw
 */
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum AccountStatus implements DictEnumInterface {
    USING(1, "使用中..."), BANNED(2, "禁用ing"),
    WRITTEN_OFF(3, "已注销");

    @ApiModelProperty(value = "键")
    private final String key;
    @ApiModelProperty(value = "键描述")
    private final String keyDesc;
    @ApiModelProperty(value = "值")
    private final int valueNo;
    @ApiModelProperty(value = "值描述")
    private final String valueDesc;

    AccountStatus(int valueNo, String valueDesc) {
        this.key = "accountStatus";
        this.keyDesc = "账户使用状态";
        this.valueNo = valueNo;
        this.valueDesc = valueDesc;
    }

    @JsonValue
    public static AccountStatus findByValue(int valueNo) {
        for (AccountStatus item : values()) {
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
        return "AccountStatus{" +
                "key='" + key + '\'' +
                ", keyDesc='" + keyDesc + '\'' +
                ", valueNo=" + valueNo +
                ", valueDesc='" + valueDesc + '\'' +
                '}';
    }
}
