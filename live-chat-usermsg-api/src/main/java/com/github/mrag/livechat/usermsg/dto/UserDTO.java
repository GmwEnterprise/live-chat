package com.github.mrag.livechat.usermsg.dto;

/**
 * 用户基本信息DTO
 *
 * @author Gmw
 */
public class UserDTO {
    private Long id;
    private String username;
    private String password;

    public Long getId() {
        return id;
    }

    public UserDTO setId(Long id) {
        this.id = id;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public UserDTO setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UserDTO setPassword(String password) {
        this.password = password;
        return this;
    }
}
