package com.github.mrag.livechat.common;

import java.io.Serializable;

public class SystemDict implements Serializable {
    private Integer kvId;

    private String key;

    private String keyDesc;

    private Integer valueNo;

    private String valueDesc;

    private Integer valueMoreDetail;

    private Integer dependencyOnId;

    private Byte canModify;

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

    public Integer getValueMoreDetail() {
        return valueMoreDetail;
    }

    public void setValueMoreDetail(Integer valueMoreDetail) {
        this.valueMoreDetail = valueMoreDetail;
    }

    public Integer getDependencyOnId() {
        return dependencyOnId;
    }

    public void setDependencyOnId(Integer dependencyOnId) {
        this.dependencyOnId = dependencyOnId;
    }

    public Byte getCanModify() {
        return canModify;
    }

    public void setCanModify(Byte canModify) {
        this.canModify = canModify;
    }
}