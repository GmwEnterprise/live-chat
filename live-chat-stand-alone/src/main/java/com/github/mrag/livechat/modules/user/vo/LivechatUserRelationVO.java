package com.github.mrag.livechat.modules.user.vo;

import com.github.mrag.livechat.enums.UserRelationState;
import io.swagger.annotations.ApiModelProperty;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class LivechatUserRelationVO {
    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("userId", userId)
                .append("username", username)
                .append("backupName", backupName)
                .append("avatarId", avatarId)
                .append("relationState", relationState)
                .toString();
    }

    @ApiModelProperty(value = "好友用户主键")
    private Long userId;

    @ApiModelProperty(value = "好友的用户名称")
    private String username;

    @ApiModelProperty(value = "备注名")
    private String backupName;

    @ApiModelProperty(value = "好友头像对应的图片名称")
    private String avatarId;

    @ApiModelProperty(value = "我对其设置的关系类型，好友[1]拉黑[2]屏蔽消息[3]关心[4]")
    private UserRelationState relationState;

    public Long getUserId() {
        return userId;
    }

    public LivechatUserRelationVO setUserId(Long userId) {
        this.userId = userId;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public LivechatUserRelationVO setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getBackupName() {
        return backupName;
    }

    public LivechatUserRelationVO setBackupName(String backupName) {
        this.backupName = backupName;
        return this;
    }

    public String getAvatarId() {
        return avatarId;
    }

    public LivechatUserRelationVO setAvatarId(String avatarId) {
        this.avatarId = avatarId;
        return this;
    }

    public UserRelationState getRelationState() {
        return relationState;
    }

    public LivechatUserRelationVO setRelationState(UserRelationState relationState) {
        this.relationState = relationState;
        return this;
    }
}
