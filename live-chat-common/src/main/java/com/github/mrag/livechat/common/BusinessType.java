package com.github.mrag.livechat.common;

/**
 * 业务类型
 */
public enum BusinessType {
    /**
     * 用户业务
     */
    USER_BUSINESS(1L),
    /**
     * 消息业务
     */
    MESSAGE_BUSINESS(2L);

    BusinessType(long value) {
        if (value < 0L || value > SnowflakeIdWorker.maxBusinessId) {
            throw new IllegalArgumentException(String.format(
                    "business Id can't be greater than %d or less than 0", SnowflakeIdWorker.maxBusinessId));
        }
        this.value = value;
    }

    private final long value;

    public long getValue() {
        return value;
    }
}
