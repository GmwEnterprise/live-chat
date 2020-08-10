package com.github.mrag.livechat.usermsg.dto;

import com.github.mrag.livechat.common.RegExp;

import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author Gmw
 */
public class UserDTO implements Serializable {
    private Long id;

    @Size(min = 6, max = 18, message = "长度应在6-18")
    @Pattern(regexp = RegExp.REGEXP_ID, message = RegExp.REGEXP_ID_MSG)
    private String chatNo;

    @Size(min = 1, max = 20, message = "长度应在1-20")
    @Pattern(regexp = RegExp.REGEXP_USERNAME, message = RegExp.REGEXP_USERNAME_MSG)
    private String username;

    private Byte gender;

    private LocalDateTime birthday;

    private String signature;

    private String company;

    private String personalDescription;

    // @Size(min = 4, max = 32, message = "长度应在4-32")
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

    public Integer getBloodGroup() {
        return bloodGroup;
    }

    public void setBloodGroup(Integer bloodGroup) {
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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", chatNo=").append(chatNo);
        sb.append(", username=").append(username);
        sb.append(", gender=").append(gender);
        sb.append(", birthday=").append(birthday);
        sb.append(", signature=").append(signature);
        sb.append(", company=").append(company);
        sb.append(", personalDescription=").append(personalDescription);
        sb.append(", userPassword=").append(userPassword);
        sb.append(", salt=").append(salt);
        sb.append(", phoneNumber=").append(phoneNumber);
        sb.append(", email=").append(email);
        sb.append(", bloodGroup=").append(bloodGroup);
        sb.append(", occupation=").append(occupation);
        sb.append(", location=").append(location);
        sb.append(", hometown=").append(hometown);
        sb.append(", accountStatus=").append(accountStatus);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}