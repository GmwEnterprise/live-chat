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
     * @return 成功注册后完整信息
     */
    String signUp(LivechatUserRegistration user);

    /**
     * 登陆
     *
     * @param verificationText 验证信息
     * @return
     */
    String signIn(String verificationText);

    /**
     * 解析token获取个人资料
     *
     * @param token 令牌
     * @return 用户信息
     */
    LivechatUser findLivechatUserByToken(String token);
}
