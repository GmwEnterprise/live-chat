package com.github.mrag.livechat.common;

import java.io.Serializable;

public class SystemDict implements Serializable {
    // 主键
    private Integer kvId;
    // 键
    private String key;
    // 键描述
    private String keyDesc;
    // 值编号
    private Integer valueNo;
    // 值描述
    private String valueDesc;
    // 向上依赖主键id
    private Integer dependencyOnId;

    private static final long serialVersionUID = 1L;

    public Integer getKvId() {
        return kvId;
    }

    public void setKvId(Integer kvId) {
        this.kvId = kvId;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getKeyDesc() {
        return keyDesc;
    }

    public void setKeyDesc(String keyDesc) {
        this.keyDesc = keyDesc;
    }

    public Integer getValueNo() {
        return valueNo;
    }

    public void setValueNo(Integer valueNo) {
        this.valueNo = valueNo;
    }

    public String getValueDesc() {
        return valueDesc;
    }

    public void setValueDesc(String valueDesc) {
        this.valueDesc = valueDesc;
    }

    public Integer getDependencyOnId() {
        return dependencyOnId;
    }

    public void setDependencyOnId(Integer dependencyOnId) {
        this.dependencyOnId = dependencyOnId;
    }
}