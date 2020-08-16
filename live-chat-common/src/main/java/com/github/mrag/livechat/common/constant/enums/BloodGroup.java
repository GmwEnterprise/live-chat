package com.github.mrag.livechat.common.constant.enums;

/**
 * @author Gmw
 */
public enum BloodGroup implements DictEnumInterface {
    A(1, "A"), B(2, "B"),
    O(3, "O"), AB(4, "AB");

    private final String key;
    private final String keyDesc;
    private final int valueNo;
    private final String valueDesc;

    BloodGroup(int valueNo, String valueDesc) {
        this.key = "bloodGroup";
        this.keyDesc = "血型";
        this.valueNo = valueNo;
        this.valueDesc = valueDesc;
    }

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
}
