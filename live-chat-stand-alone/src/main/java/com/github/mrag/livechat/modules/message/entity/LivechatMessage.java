package com.github.mrag.livechat.modules.message.entity;

import com.github.mrag.livechat.enums.MessageType;
import com.github.mrag.livechat.enums.ReceiverType;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.time.LocalDateTime;

public class LivechatMessage implements Serializable {
    /**
     * 消息主键，外部赋值
     *
     * @mbg.generated
     */
    @ApiModelProperty(value = "消息主键，外部赋值")
    private Long id;

    /**
     * 消息发送者
     *
     * @mbg.generated
     */
    @ApiModelProperty(value = "消息发送者")
    private Long senderId;

    /**
     * 发送时间
     *
     * @mbg.generated
     */
    @ApiModelProperty(value = "发送时间")
    private LocalDateTime sendTime;

    /**
     * 消息接收者
     *
     * @mbg.generated
     */
    @ApiModelProperty(value = "消息接收者")
    private Long receiverId;

    /**
     * 消息接收者类型，用户[1],群[2]
     *
     * @mbg.generated
     */
    @ApiModelProperty(value = "消息接收者类型，用户[1],群[2]")
    private ReceiverType receiverType;

    /**
     * 是否已接收，未接收的消息为离线消息
     *
     * @mbg.generated
     */
    @ApiModelProperty(value = "是否已接收，未接收的消息为离线消息")
    private Boolean received;

    /**
     * 消息接收时间
     *
     * @mbg.generated
     */
    @ApiModelProperty(value = "消息接收时间")
    private LocalDateTime receiveTime;

    /**
     * 消息类型，文本[1],图片[2],文件[3],表情[4]
     *
     * @mbg.generated
     */
    @ApiModelProperty(value = "消息类型，文本[1],图片[2],文件[3],表情[4]")
    private MessageType messageType;

    /**
     * 消息主体，处理方式取决于 message_type
     *
     * @mbg.generated
     */
    @ApiModelProperty(value = "消息主体，处理方式取决于 message_type")
    private String message;

    /**
     * 是否已读
     *
     * @mbg.generated
     */
    @ApiModelProperty(value = "是否已读")
    private Boolean readState;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getSenderId() {
        return senderId;
    }

    public void setSenderId(Long senderId) {
        this.senderId = senderId;
    }

    public LocalDateTime getSendTime() {
        return sendTime;
    }

    public void setSendTime(LocalDateTime sendTime) {
        this.sendTime = sendTime;
    }

    public Long getReceiverId() {
        return receiverId;
    }

    public void setReceiverId(Long receiverId) {
        this.receiverId = receiverId;
    }

    public ReceiverType getReceiverType() {
        return receiverType;
    }

    public void setReceiverType(ReceiverType receiverType) {
        this.receiverType = receiverType;
    }

    public Boolean getReceived() {
        return received;
    }

    public void setReceived(Boolean received) {
        this.received = received;
    }

    public LocalDateTime getReceiveTime() {
        return receiveTime;
    }

    public void setReceiveTime(LocalDateTime receiveTime) {
        this.receiveTime = receiveTime;
    }

    public MessageType getMessageType() {
        return messageType;
    }

    public void setMessageType(MessageType messageType) {
        this.messageType = messageType;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Boolean getReadState() {
        return readState;
    }

    public void setReadState(Boolean readState) {
        this.readState = readState;
    }
}