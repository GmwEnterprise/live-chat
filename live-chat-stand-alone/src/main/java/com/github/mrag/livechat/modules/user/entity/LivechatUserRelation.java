package com.github.mrag.livechat.modules.user.entity;

import com.github.mrag.livechat.enums.UserRelationState;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.time.LocalDateTime;

public class LivechatUserRelation implements Serializable {
    /**
     * 我方的主键
     *
     * @mbg.generated
     */
    @ApiModelProperty(value = "我方的主键")
    private Long myId;

    /**
     * 对方的主键
     *
     * @mbg.generated
     */
    @ApiModelProperty(value = "对方的主键")
    private Long othersId;

    /**
     * 用户关系类型，好友[1]拉黑[2]屏蔽消息[3]关心[4]
     *
     * @mbg.generated
     */
    @ApiModelProperty(value = "用户关系类型，好友[1]拉黑[2]屏蔽消息[3]关心[4]")
    private UserRelationState relationState;

    /**
     * 用户关系首次创建时间
     *
     * @mbg.generated
     */
    @ApiModelProperty(value = "用户关系首次创建时间")
    private LocalDateTime relationCreateDatetime;

    /**
     * 用户关系最近一次更新时间
     *
     * @mbg.generated
     */
    @ApiModelProperty(value = "用户关系最近一次更新时间")
    private LocalDateTime relationLastUpdateDatetime;

    private static final long serialVersionUID = 1L;

    public Long getMyId() {
        return myId;
    }

    public void setMyId(Long myId) {
        this.myId = myId;
    }

    public Long getOthersId() {
        return othersId;
    }

    public void setOthersId(Long othersId) {
        this.othersId = othersId;
    }

    public UserRelationState getRelationState() {
        return relationState;
    }

    public void setRelationState(UserRelationState relationState) {
        this.relationState = relationState;
    }

    public LocalDateTime getRelationCreateDatetime() {
        return relationCreateDatetime;
    }

    public void setRelationCreateDatetime(LocalDateTime relationCreateDatetime) {
        this.relationCreateDatetime = relationCreateDatetime;
    }

    public LocalDateTime getRelationLastUpdateDatetime() {
        return relationLastUpdateDatetime;
    }

    public void setRelationLastUpdateDatetime(LocalDateTime relationLastUpdateDatetime) {
        this.relationLastUpdateDatetime = relationLastUpdateDatetime;
    }
}