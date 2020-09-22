package com.github.mrag.livechat.usermsg.vo;

import com.github.mrag.livechat.common.constant.enums.AccountStatus;
import com.github.mrag.livechat.common.constant.enums.BloodGroup;
import com.github.mrag.livechat.common.constant.enums.Gender;
import com.github.mrag.livechat.common.validation.Dictionary;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author Gmw
 */
public class UserDetail implements Serializable {
    private static final long serialVersionUID = 1L;

    // dto中的主键修改为字符串，避免JS误差
    @ApiModelProperty(value = "id", name = "ID", dataType = "String")
    private String id;

    @ApiModelProperty(value = "wechatNo", name = "微信号", dataType = "String")
    private String wechatNo;

    @ApiModelProperty(value = "username", name = "用户名", dataType = "String")
    private String username;

    // TODO 添加注解  https://blog.csdn.net/cwr452829537/article/details/105066481
    private String avatarId;
    private Gender gender;
    private LocalDateTime birthday;
    private String signature;
    private String company;
    private String personalDescription;
    private String userPassword;
    private String phoneNumber;
    private String email;
    private BloodGroup bloodGroup;
    @Dictionary(key = "trade")
    private Integer occupation; // 字典获取
    @Dictionary(key = "city")
    private Integer location; // 字典获取
    @Dictionary(key = "city")
    private Integer hometown; // 字典获取
    private AccountStatus accountStatus; // 采用默认值

    public String getId() {
        return id;
    }

    public UserDetail setId(String id) {
        this.id = id;
        return this;
    }

    public String getWechatNo() {
        return wechatNo;
    }

    public UserDetail setWechatNo(String wechatNo) {
        this.wechatNo = wechatNo;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public UserDetail setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getAvatarId() {
        return avatarId;
    }

    public UserDetail setAvatarId(String avatarId) {
        this.avatarId = avatarId;
        return this;
    }

    public Gender getGender() {
        return gender;
    }

    public UserDetail setGender(Gender gender) {
        this.gender = gender;
        return this;
    }

    public LocalDateTime getBirthday() {
        return birthday;
    }

    public UserDetail setBirthday(LocalDateTime birthday) {
        this.birthday = birthday;
        return this;
    }

    public String getSignature() {
        return signature;
    }

    public UserDetail setSignature(String signature) {
        this.signature = signature;
        return this;
    }

    public String getCompany() {
        return company;
    }

    public UserDetail setCompany(String company) {
        this.company = company;
        return this;
    }

    public String getPersonalDescription() {
        return personalDescription;
    }

    public UserDetail setPersonalDescription(String personalDescription) {
        this.personalDescription = personalDescription;
        return this;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public UserDetail setUserPassword(String userPassword) {
        this.userPassword = userPassword;
        return this;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public UserDetail setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public UserDetail setEmail(String email) {
        this.email = email;
        return this;
    }

    public BloodGroup getBloodGroup() {
        return bloodGroup;
    }

    public UserDetail setBloodGroup(BloodGroup bloodGroup) {
        this.bloodGroup = bloodGroup;
        return this;
    }

    public Integer getOccupation() {
        return occupation;
    }

    public UserDetail setOccupation(Integer occupation) {
        this.occupation = occupation;
        return this;
    }

    public Integer getLocation() {
        return location;
    }

    public UserDetail setLocation(Integer location) {
        this.location = location;
        return this;
    }

    public Integer getHometown() {
        return hometown;
    }

    public UserDetail setHometown(Integer hometown) {
        this.hometown = hometown;
        return this;
    }

    public AccountStatus getAccountStatus() {
        return accountStatus;
    }

    public UserDetail setAccountStatus(AccountStatus accountStatus) {
        this.accountStatus = accountStatus;
        return this;
    }
}
