package com.github.mrag.livechat.usermsg.entity;

import javax.annotation.Generated;
import java.io.Serializable;
import java.time.LocalDateTime;

public class ChatUsermsg implements Serializable {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Long id;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private String chatNo;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private String username;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Byte gender;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private LocalDateTime birthday;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private String signature;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private String company;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private String personalDescription;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private String userPassword;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private String salt;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private String phoneNumber;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private String email;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Integer bloodGroup;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Integer occupation;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Integer location;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Integer hometown;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Byte accountStatus;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private static final long serialVersionUID = 1L;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Long getId() {
        return id;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setId(Long id) {
        this.id = id;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public String getChatNo() {
        return chatNo;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setChatNo(String chatNo) {
        this.chatNo = chatNo;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public String getUsername() {
        return username;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setUsername(String username) {
        this.username = username;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Byte getGender() {
        return gender;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setGender(Byte gender) {
        this.gender = gender;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public LocalDateTime getBirthday() {
        return birthday;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setBirthday(LocalDateTime birthday) {
        this.birthday = birthday;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public String getSignature() {
        return signature;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setSignature(String signature) {
        this.signature = signature;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public String getCompany() {
        return company;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setCompany(String company) {
        this.company = company;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public String getPersonalDescription() {
        return personalDescription;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setPersonalDescription(String personalDescription) {
        this.personalDescription = personalDescription;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public String getUserPassword() {
        return userPassword;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public String getSalt() {
        return salt;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setSalt(String salt) {
        this.salt = salt;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public String getPhoneNumber() {
        return phoneNumber;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public String getEmail() {
        return email;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setEmail(String email) {
        this.email = email;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Integer getBloodGroup() {
        return bloodGroup;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setBloodGroup(Integer bloodGroup) {
        this.bloodGroup = bloodGroup;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Integer getOccupation() {
        return occupation;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setOccupation(Integer occupation) {
        this.occupation = occupation;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Integer getLocation() {
        return location;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setLocation(Integer location) {
        this.location = location;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Integer getHometown() {
        return hometown;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setHometown(Integer hometown) {
        this.hometown = hometown;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Byte getAccountStatus() {
        return accountStatus;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setAccountStatus(Byte accountStatus) {
        this.accountStatus = accountStatus;
    }
}