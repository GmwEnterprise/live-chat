package com.github.mrag.livechat.modules.user.entity;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.time.LocalDateTime;

public class LivechatUser implements Serializable {
    /**
     * 主键，64位Long型，JSON传输请使用String
     *
     * @mbg.generated
     */
    @ApiModelProperty(value = "主键，64位Long型，JSON传输请使用String")
    private Long id;

    /**
     * 微信号，长度限制为8-26位，仅限字母与数字
     *
     * @mbg.generated
     */
    @ApiModelProperty(value = "微信号，长度限制为8-26位，仅限字母与数字")
    private String wechatNo;

    /**
     * 用户名称，支持中文，支持空字符串，最大长度为16
     *
     * @mbg.generated
     */
    @ApiModelProperty(value = "用户名称，支持中文，支持空字符串，最大长度为16")
    private String username;

    /**
     * 用户头像对应的图片名称，图片地址前缀保存为常量，图片格式统一为png格式，大小处理为200*200
     *
     * @mbg.generated
     */
    @ApiModelProperty(value = "用户头像对应的图片名称，图片地址前缀保存为常量，图片格式统一为png格式，大小处理为200*200")
    private String avatarId;

    /**
     * 性别，枚举数值，男[1]女[2]保密[3]，默认为[3]
     *
     * @mbg.generated
     */
    @ApiModelProperty(value = "性别，枚举数值，男[1]女[2]保密[3]，默认为[3]")
    private Byte gender;

    /**
     * 出生日期，必须为过去的日期，格式[yyyy-MM-dd HH:mm:ss]
     *
     * @mbg.generated
     */
    @ApiModelProperty(value = "出生日期，必须为过去的日期，格式[yyyy-MM-dd HH:mm:ss]")
    private LocalDateTime birthday;

    /**
     * 个性签名，最大长度128
     *
     * @mbg.generated
     */
    @ApiModelProperty(value = "个性签名，最大长度128")
    private String signature;

    /**
     * 公司名称，最大长度64
     *
     * @mbg.generated
     */
    @ApiModelProperty(value = "公司名称，最大长度64")
    private String company;

    /**
     * 个人说明，最大长度255
     *
     * @mbg.generated
     */
    @ApiModelProperty(value = "个人说明，最大长度255")
    private String personalDescription;

    /**
     * 加盐密码
     *
     * @mbg.generated
     */
    @ApiModelProperty(value = "加盐密码")
    private String userPassword;

    /**
     * 密码盐
     *
     * @mbg.generated
     */
    @ApiModelProperty(value = "密码盐")
    private String salt;

    /**
     * 手机号
     *
     * @mbg.generated
     */
    @ApiModelProperty(value = "手机号")
    private String phoneNumber;

    /**
     * 邮箱
     *
     * @mbg.generated
     */
    @ApiModelProperty(value = "邮箱")
    private String email;

    /**
     * 血型，枚举数值，A型血[1]B型血[2]O型血[3]AB型血[4]
     *
     * @mbg.generated
     */
    @ApiModelProperty(value = "血型，枚举数值，A型血[1]B型血[2]O型血[3]AB型血[4]")
    private Byte bloodGroup;

    /**
     * 字典-从事行业
     *
     * @mbg.generated
     */
    @ApiModelProperty(value = "字典-从事行业")
    private Integer occupation;

    /**
     * 字典-现居地
     *
     * @mbg.generated
     */
    @ApiModelProperty(value = "字典-现居地")
    private Integer location;

    /**
     * 字典-故居
     *
     * @mbg.generated
     */
    @ApiModelProperty(value = "字典-故居")
    private Integer hometown;

    /**
     * 账户使用状态，枚举数值，使用中[1]禁用[2]已注销[3]，默认为[1]
     *
     * @mbg.generated
     */
    @ApiModelProperty(value = "账户使用状态，枚举数值，使用中[1]禁用[2]已注销[3]，默认为[1]")
    private Byte accountStatus;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getWechatNo() {
        return wechatNo;
    }

    public void setWechatNo(String wechatNo) {
        this.wechatNo = wechatNo;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAvatarId() {
        return avatarId;
    }

    public void setAvatarId(String avatarId) {
        this.avatarId = avatarId;
    }

    public Byte getGender() {
        return gender;
    }

    public void setGender(Byte gender) {
        this.gender = gender;
    }

    public LocalDateTime getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDateTime birthday) {
        this.birthday = birthday;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getPersonalDescription() {
        return personalDescription;
    }

    public void setPersonalDescription(String personalDescription) {
        this.personalDescription = personalDescription;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Byte getBloodGroup() {
        return bloodGroup;
    }

    public void setBloodGroup(Byte bloodGroup) {
        this.bloodGroup = bloodGroup;
    }

    public Integer getOccupation() {
        return occupation;
    }

    public void setOccupation(Integer occupation) {
        this.occupation = occupation;
    }

    public Integer getLocation() {
        return location;
    }

    public void setLocation(Integer location) {
        this.location = location;
    }

    public Integer getHometown() {
        return hometown;
    }

    public void setHometown(Integer hometown) {
        this.hometown = hometown;
    }

    public Byte getAccountStatus() {
        return accountStatus;
    }

    public void setAccountStatus(Byte accountStatus) {
        this.accountStatus = accountStatus;
    }
}