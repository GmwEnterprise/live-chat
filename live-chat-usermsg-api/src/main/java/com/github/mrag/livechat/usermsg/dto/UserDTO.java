package com.github.mrag.livechat.usermsg.dto;

import com.github.mrag.livechat.common.constant.RegExp;
import com.github.mrag.livechat.common.validation.Dictionary;
import com.github.mrag.livechat.common.validation.Password;

import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author Gmw
 */
public class UserDTO implements Serializable {
    private String token;
    // ###### 以下为 entity.User原有字段

    private Long id;

    @Size(min = 6, max = 18, message = "ID长度应在6-18")
    @Pattern(regexp = RegExp.REGEXP_ID, message = RegExp.REGEXP_ID_MSG)
    private String chatNo;

    @Size(min = 1, max = 20, message = "用户名长度应在1-20")
    @Pattern(regexp = RegExp.REGEXP_USERNAME, message = RegExp.REGEXP_USERNAME_MSG)
    private String username;

    @Dictionary
    private Byte gender;

    private LocalDateTime birthday;

    private String signature;

    private String company;

    private String personalDescription;

    @Password(message = "密码格式有误")
    private String userPassword;

    private String salt;

    @Pattern(regexp = RegExp.REGEXP_PHONE, message = RegExp.REGEXP_PHONE_MSG)
    private String phoneNumber;

    @Email(message = "Email格式错误")
    private String email;

    private Integer bloodGroup;

    private Integer occupation;

    private Integer location;

    private Integer hometown;

    private Byte accountStatus;

    private static final long serialVersionUID = 1L;

    public String getToken() {
        return token;
    }

    public UserDTO setToken(String token) {
        this.token = token;
        return this;
    }

    public Long getId() {
        return id;
    }

    public UserDTO setId(Long id) {
        this.id = id;
        return this;
    }

    public String getChatNo() {
        return chatNo;
    }

    public UserDTO setChatNo(String chatNo) {
        this.chatNo = chatNo;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public UserDTO setUsername(String username) {
        this.username = username;
        return this;
    }

    public Byte getGender() {
        return gender;
    }

    public UserDTO setGender(Byte gender) {
        this.gender = gender;
        return this;
    }

    public LocalDateTime getBirthday() {
        return birthday;
    }

    public UserDTO setBirthday(LocalDateTime birthday) {
        this.birthday = birthday;
        return this;
    }

    public String getSignature() {
        return signature;
    }

    public UserDTO setSignature(String signature) {
        this.signature = signature;
        return this;
    }

    public String getCompany() {
        return company;
    }

    public UserDTO setCompany(String company) {
        this.company = company;
        return this;
    }

    public String getPersonalDescription() {
        return personalDescription;
    }

    public UserDTO setPersonalDescription(String personalDescription) {
        this.personalDescription = personalDescription;
        return this;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public UserDTO setUserPassword(String userPassword) {
        this.userPassword = userPassword;
        return this;
    }

    public String getSalt() {
        return salt;
    }

    public UserDTO setSalt(String salt) {
        this.salt = salt;
        return this;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public UserDTO setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public UserDTO setEmail(String email) {
        this.email = email;
        return this;
    }

    public Integer getBloodGroup() {
        return bloodGroup;
    }

    public UserDTO setBloodGroup(Integer bloodGroup) {
        this.bloodGroup = bloodGroup;
        return this;
    }

    public Integer getOccupation() {
        return occupation;
    }

    public UserDTO setOccupation(Integer occupation) {
        this.occupation = occupation;
        return this;
    }

    public Integer getLocation() {
        return location;
    }

    public UserDTO setLocation(Integer location) {
        this.location = location;
        return this;
    }

    public Integer getHometown() {
        return hometown;
    }

    public UserDTO setHometown(Integer hometown) {
        this.hometown = hometown;
        return this;
    }

    public Byte getAccountStatus() {
        return accountStatus;
    }

    public UserDTO setAccountStatus(Byte accountStatus) {
        this.accountStatus = accountStatus;
        return this;
    }
}