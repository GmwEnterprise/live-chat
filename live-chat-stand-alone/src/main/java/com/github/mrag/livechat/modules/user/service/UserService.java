package com.github.mrag.livechat.modules.user.service;

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
    String signUp(LivechatUser user);

    /**
     * 登陆
     *
     * @param user 用户登陆信息
     * @return
     */
    String signIn(LivechatUser user);
}
