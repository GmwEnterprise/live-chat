package com.github.mrag.livechat.usermsg.vo;

import com.github.mrag.livechat.common.constant.enums.AccountStatus;
import com.github.mrag.livechat.common.constant.enums.BloodGroup;
import com.github.mrag.livechat.common.constant.enums.Gender;
import com.github.mrag.livechat.common.validation.Dictionary;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author Gmw
 */
public class UserDetail implements Serializable {
    private static final long serialVersionUID = 1L;

    // dto中的主键修改为字符串，避免JS误差
    // @ApiModelProperty(value = "id", name = "ID")
    private String id;

    // @ApiModelProperty(value = "wechatNo", name = "微信号")
    private String wechatNo;

    // @ApiModelProperty(value = "username", name = "用户名")
    private String username;

    // @ApiModelProperty(value = "avatarId", name = "用户头像文件ID")
    private String avatarId;

    // @ApiModelProperty(value = "gender", name = "性别")
    private Gender gender;

    // @ApiModelProperty(value = "birthday", name = "生日")
    private LocalDateTime birthday;

    // @ApiModelProperty(value = "signature", name = "个性签名")
    private String signature;

    // @ApiModelProperty(value = "company", name = "所在单位")
    private String company;

    // @ApiModelProperty(name = "个人说明")
    private String personalDescription;

    // @ApiModelProperty(name = "密码")
    private String userPassword;

    // @ApiModelProperty(name = "手机号码")
    private String phoneNumber;

    // @ApiModelProperty(name = "邮箱")
    private String email;

    // @ApiModelProperty(name = "血型")
    private BloodGroup bloodGroup;

    // @ApiModelProperty(name = "行业")
    @Dictionary(key = "trade")
    private Integer occupation; // 字典获取

    // @ApiModelProperty(name = "所在地")
    @Dictionary(key = "city")
    private Integer location; // 字典获取

    // @ApiModelProperty(name = "故乡")
    @Dictionary(key = "city")
    private Integer hometown; // 字典获取

    // @ApiModelProperty(name = "账户使用状态")
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
