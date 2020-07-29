package com.github.mrag.livechat.common;

/**
 * 基于官方，按照自己的需求进行定制的雪花算法.<br>
 * 64位主键，其中从左至右：<br>
 * <b>首位置0 - 41位时间戳 - 5位业务号 - 5位机器标识 - 12位计数序列号</b>
 *
 * @author Gmw
 */
public class SnowflakeIdWorker {
    /**
     * 起始时间戳 2020-7-29 17:21:34
     */
    private final long twepoch = 1596014494595L;
    /**
     * 业务号长度 0 ~ 31
     */
    private final long businessIdBits = 5L;
    /**
     * 机器标识长度 0 ~ 31
     */
    private final long workerIdBits = 5L;
    /**
     * 计数序列号长度 0 ~ 4095
     */
    private final long seqBits = 12L;
    /**
     * 最大机器标识为 31
     */
    private final long maxWorkerId = ~(-1 << workerIdBits);
    /**
     * 最大业务号为 31
     */
    private final long maxBusinessId = ~(-1 << businessIdBits);
    /**
     * 机器标识向左移 12 位
     */
    private final long workerIdShift = seqBits;
    /**
     * 业务号向左移 12+5 位
     */
    private final long businessIdShift = seqBits + workerIdBits;
    /**
     * 时间戳向左移 12+5+5 位
     */
    private final long timestampShift = seqBits + workerIdBits + businessIdBits;
}
