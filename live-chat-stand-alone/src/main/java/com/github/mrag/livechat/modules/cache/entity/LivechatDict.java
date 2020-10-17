package com.github.mrag.livechat.modules.cache.entity;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

public class LivechatDict implements Serializable {
    /**
     * 主键
     *
     * @mbg.generated
     */
    @ApiModelProperty(value = "主键")
    private Integer kvId;

    /**
     * 键，最大长度16
     *
     * @mbg.generated
     */
    @ApiModelProperty(value = "键，最大长度16")
    private String key;

    /**
     * 键描述，最大长度64
     *
     * @mbg.generated
     */
    @ApiModelProperty(value = "键描述，最大长度64")
    private String keyDesc;

    /**
     * 键对应的int型值
     *
     * @mbg.generated
     */
    @ApiModelProperty(value = "键对应的int型值")
    private Integer valueNo;

    /**
     * 键值描述，最大长度64
     *
     * @mbg.generated
     */
    @ApiModelProperty(value = "键值描述，最大长度64")
    private String valueDesc;

    /**
     * 额外信息，根据不同场景来使用。对于有些键而言，该字段可以关联`system_dict_more`表
     *
     * @mbg.generated
     */
    @ApiModelProperty(value = "额外信息，根据不同场景来使用。对于有些键而言，该字段可以关联`system_dict_more`表")
    private Integer valueMoreDetail;

    /**
     * 该键值对向上依赖的另一对键值对
     *
     * @mbg.generated
     */
    @ApiModelProperty(value = "该键值对向上依赖的另一对键值对")
    private Integer dependencyOnId;

    /**
     * 是否允许修改该条记录，允许[1]禁止[2]，默认[1]
     *
     * @mbg.generated
     */
    @ApiModelProperty(value = "是否允许修改该条记录，允许[1]禁止[2]，默认[1]")
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