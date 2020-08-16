package com.github.mrag.livechat.common.constant.enums;

/**
 * 字典枚举接口
 *
 * @author Gmw
 */
public interface DictEnumInterface {

    String getKey();

    String getKeyDesc();

    int getValueNo();

    String getValueDesc();

    default String getValueMoreDetail() {
        return null;
    }
}
