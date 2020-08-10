package com.github.mrag.livechat.common.utils;

import com.github.mrag.livechat.common.BusinessType;
import com.github.mrag.livechat.common.SnowflakeIdWorker;

public final class SequenceUtils {
    // TODO 基于zookeeper的分布式机器ID分配
    private static final SnowflakeIdWorker counter = new SnowflakeIdWorker(1L);

    public static long nextId(BusinessType businessType) {
        return counter.nextId(businessType);
    }
}
