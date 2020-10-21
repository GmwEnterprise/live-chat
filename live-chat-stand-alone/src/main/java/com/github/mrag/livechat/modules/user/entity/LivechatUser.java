package com.github.mrag.livechat.modules.user.entity;

import com.github.mrag.livechat.enums.AccountStatus;
import com.github.mrag.livechat.enums.BloodGroup;
import com.github.mrag.livechat.enums.Gender;
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
    private Gender gender;

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
    private BloodGroup bloodGroup;

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
    private AccountStatus accountStatus;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public LivechatUser setId(Long id) {
        this.id = id;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public LivechatUser setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getAvatarId() {
        return avatarId;
    }

    public LivechatUser setAvatarId(String avatarId) {
        this.avatarId = avatarId;
        return this;
    }

    public Gender getGender() {
        return gender;
    }

    public LivechatUser setGender(Gender gender) {
        this.gender = gender;
        return this;
    }

    public LocalDateTime getBirthday() {
        return birthday;
    }

    public LivechatUser setBirthday(LocalDateTime birthday) {
        this.birthday = birthday;
        return this;
    }

    public String getSignature() {
        return signature;
    }

    public LivechatUser setSignature(String signature) {
        this.signature = signature;
        return this;
    }

    public String getCompany() {
        return company;
    }

    public LivechatUser setCompany(String company) {
        this.company = company;
        return this;
    }

    public String getPersonalDescription() {
        return personalDescription;
    }

    public LivechatUser setPersonalDescription(String personalDescription) {
        this.personalDescription = personalDescription;
        return this;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public LivechatUser setUserPassword(String userPassword) {
        this.userPassword = userPassword;
        return this;
    }

    public String getSalt() {
        return salt;
    }

    public LivechatUser setSalt(String salt) {
        this.salt = salt;
        return this;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public LivechatUser setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public LivechatUser setEmail(String email) {
        this.email = email;
        return this;
    }

    public BloodGroup getBloodGroup() {
        return bloodGroup;
    }

    public LivechatUser setBloodGroup(BloodGroup bloodGroup) {
        this.bloodGroup = bloodGroup;
        return this;
    }

    public Integer getOccupation() {
        return occupation;
    }

    public LivechatUser setOccupation(Integer occupation) {
        this.occupation = occupation;
        return this;
    }

    public Integer getLocation() {
        return location;
    }

    public LivechatUser setLocation(Integer location) {
        this.location = location;
        return this;
    }

    public Integer getHometown() {
        return hometown;
    }

    public LivechatUser setHometown(Integer hometown) {
        this.hometown = hometown;
        return this;
    }

    public AccountStatus getAccountStatus() {
        return accountStatus;
    }

    public LivechatUser setAccountStatus(AccountStatus accountStatus) {
        this.accountStatus = accountStatus;
        return this;
    }
}