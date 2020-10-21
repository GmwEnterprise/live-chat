package com.github.mrag.livechat.modules.user.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

/**
 * 用户注册信息
 */
@ApiModel("用户注册信息")
public class LivechatUserRegistration {
    @ApiModelProperty(value = "用户名称，支持中文，支持空字符串，最大长度为16")
    @Size(max = 16, min = 1, message = "用户名长度应为1-16个字符")
    private String username;

    @ApiModelProperty(value = "手机号")
    @NotBlank(message = "手机号不能为空")
    private String phone;

    @ApiModelProperty(value = "邮箱")
    @Email(message = "邮箱地址不合法")
    private String email;

    @ApiModelProperty(value = "用户输入的密码")
    @Size(max = 40, min = 4, message = "密码长度应为6-40个字符")
    @NotBlank
    private String password;

    public String getUsername() {
        return username;
    }

    public LivechatUserRegistration setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPhone() {
        return phone;
    }

    public LivechatUserRegistration setPhone(String phone) {
        this.phone = phone;
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
