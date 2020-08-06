package com.github.mrag.livechat.usermsg.dto;

import javax.validation.constraints.*;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 用户基本信息DTO
 *
 * @author Gmw
 */
public class ChatUsermsgDTO implements Serializable {

    private Long id;

    @NotBlank(message = "ID不能为空")
    @Pattern(message = "", regexp = "")
    private String chatNo;

    @Pattern(regexp = "^[\\u4E00-\\u9FA5A-Za-z0-9_]+$", message = "用户名仅支持中文、数字、字母以及下划线")
    @Size(min = 2, max = 16, message = "用户名长度在2-16个字符之间")
    private String username;

    private Byte gender;

    @Past(message = "出生日期必须是过去的时间")
    private LocalDateTime birthday;

    private String signature;

    private String company;

    private String personalDescription;

    // 密码需要经过自定义验证
    private String userPassword;

    private String salt;

    @Pattern(regexp = "^(13[0-9]|14[5|7]|15[0|1|2|3|5|6|7|8|9]|18[0|1|2|3|5|6|7|8|9])\\d{8}$",
            message = "手机号码不符合规范")
    private String phoneNumber;

    @Email(message = "Email地址不符合规范")
    private String email;

    private Integer bloodGroup;

    private Integer occupation;

    private Integer location;

    private Integer hometown;

    private Byte accountStatus;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public ChatUsermsgDTO setId(Long id) {
        this.id = id;
        return this;
    }

    public String getChatNo() {
        return chatNo;
    }

    public ChatUsermsgDTO setChatNo(String chatNo) {
        this.chatNo = chatNo;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public ChatUsermsgDTO setUsername(String username) {
        this.username = username;
        return this;
    }

    public Byte getGender() {
        return gender;
    }

    public ChatUsermsgDTO setGender(Byte gender) {
        this.gender = gender;
        return this;
    }

    public LocalDateTime getBirthday() {
        return birthday;
    }

    public ChatUsermsgDTO setBirthday(LocalDateTime birthday) {
        this.birthday = birthday;
        return this;
    }

    public String getSignature() {
        return signature;
    }

    public ChatUsermsgDTO setSignature(String signature) {
        this.signature = signature;
        return this;
    }

    public String getCompany() {
        return company;
    }

    public ChatUsermsgDTO setCompany(String company) {
        this.company = company;
        return this;
    }

    public String getPersonalDescription() {
        return personalDescription;
    }

    public ChatUsermsgDTO setPersonalDescription(String personalDescription) {
        this.personalDescription = personalDescription;
        return this;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public ChatUsermsgDTO setUserPassword(String userPassword) {
        this.userPassword = userPassword;
        return this;
    }

    public String getSalt() {
        return salt;
    }

    public ChatUsermsgDTO setSalt(String salt) {
        this.salt = salt;
        return this;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public ChatUsermsgDTO setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public ChatUsermsgDTO setEmail(String email) {
        this.email = email;
        return this;
    }

    public Integer getBloodGroup() {
        return bloodGroup;
    }

    public ChatUsermsgDTO setBloodGroup(Integer bloodGroup) {
        this.bloodGroup = bloodGroup;
        return this;
    }

    public Integer getOccupation() {
        return occupation;
    }

    public ChatUsermsgDTO setOccupation(Integer occupation) {
        this.occupation = occupation;
        return this;
    }

    public Integer getLocation() {
        return location;
    }

    public ChatUsermsgDTO setLocation(Integer location) {
        this.location = location;
        return this;
    }

    public Integer getHometown() {
        return hometown;
    }

    public ChatUsermsgDTO setHometown(Integer hometown) {
        this.hometown = hometown;
        return this;
    }

    public Byte getAccountStatus() {
        return accountStatus;
    }

    public ChatUsermsgDTO setAccountStatus(Byte accountStatus) {
        this.accountStatus = accountStatus;
        return this;
    }
}
