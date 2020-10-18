package com.github.mrag.livechat.modules.user.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 用户注册信息
 */
@ApiModel("用户注册信息")
public class LivechatUserRegistration {
    @ApiModelProperty(value = "用户名称，支持中文，支持空字符串，最大长度为16")
    private String username;

    @ApiModelProperty(value = "手机号")
    private String phoneNumber;

    @ApiModelProperty(value = "邮箱")
    private String email;

    @ApiModelProperty(value = "用户输入的密码")
    private String password;

    public String getUsername() {
        return username;
    }

    public LivechatUserRegistration setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public LivechatUserRegistration setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public LivechatUserRegistration setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public LivechatUserRegistration setPassword(String password) {
        this.password = password;
        return this;
    }
}
