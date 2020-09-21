package com.github.mrag.livechat.usermsg.api;

import com.github.mrag.livechat.usermsg.vo.UserDetail;

/**
 * 用户服务
 *
 * @author Gmw
 */
public interface UserService {

    /**
     * 修改用户信息
     */
    void modify(UserDetail dto);

    /**
     * 用户登陆并返回token
     */
    String signInUser(String phone, String password);

    /**
     * 检查数据库中是否有这个手机号的账户存在，返回布尔值
     */
    boolean checkPhoneExists(String phone);

    /**
     * 通过userId获取密码加密哈希
     */
    String findUserHashById(long userId);


    /**
     * 注册用户并返回token
     */
    String registry(UserDetail detail);
}
