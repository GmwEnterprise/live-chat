package com.github.mrag.livechat.modules.user.service;

import com.github.mrag.livechat.modules.user.dto.LivechatUserRegistration;
import com.github.mrag.livechat.modules.user.entity.LivechatUser;

/**
 * 用户相关服务
 */
public interface UserService {
    /**
     * 注册一个账户
     *
     * @param user 注册信息
     * @return token
     */
    String signUp(LivechatUserRegistration user);

    /**
     * 登陆
     *
     * @param verificationText 验证信息
     * @return token
     */
    String signIn(String verificationText);

    /**
     * 获取用户资料
     *
     * @param userId 主键
     * @return 用户资料
     */
    LivechatUser findByUserId(Long userId);
}
