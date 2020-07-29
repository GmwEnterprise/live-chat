package com.github.mrag.livechat.usermsg.dto;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 用户基本信息DTO
 *
 * @author Gmw
 */
public class ChatUsermsgDTO implements Serializable {

    private Long id;

    private String chatNo;

    private String username;

    private Byte gender;

    private LocalDateTime birthday;

    private String signature;

    private String company;

    private String personalDescription;

    private String userPassword;

    private String salt;

    private String phoneNumber;

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
