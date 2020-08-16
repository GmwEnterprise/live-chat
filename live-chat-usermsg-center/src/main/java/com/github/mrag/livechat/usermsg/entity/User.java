package com.github.mrag.livechat.usermsg.entity;

import com.github.mrag.livechat.common.constant.enums.AccountStatus;
import com.github.mrag.livechat.common.constant.enums.BloodGroup;
import com.github.mrag.livechat.common.constant.enums.Gender;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author Gmw
 */
public class User implements Serializable {
    private Long id;

    private String chatNo;

    private String username;

    private Gender gender;

    private LocalDateTime birthday;

    private String signature;

    private String company;

    private String personalDescription;

    private String userPassword;

    private String salt;

    private String phoneNumber;

    private String email;

    private BloodGroup bloodGroup;

    private Integer occupation;

    private Integer location;

    private Integer hometown;

    private AccountStatus accountStatus;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getChatNo() {
        return chatNo;
    }

    public void setChatNo(String chatNo) {
        this.chatNo = chatNo;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
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

    public BloodGroup getBloodGroup() {
        return bloodGroup;
    }

    public void setBloodGroup(BloodGroup bloodGroup) {
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

    public AccountStatus getAccountStatus() {
        return accountStatus;
    }

    public void setAccountStatus(AccountStatus accountStatus) {
        this.accountStatus = accountStatus;
    }
}