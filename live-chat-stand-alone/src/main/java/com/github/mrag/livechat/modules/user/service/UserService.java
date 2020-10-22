package com.github.mrag.livechat.modules.user.service;

import com.github.mrag.livechat.modules.user.dto.LivechatUserRegistration;
import com.github.mrag.livechat.modules.user.entity.LivechatUser;
import com.github.mrag.livechat.modules.user.vo.LivechatUserRelationVO;

import java.util.List;

/**
 * 用户相关服务
 */
public interface UserService {
    /**
     * 注册一个账户，注册成功后返回一个令牌
     *
     * @param user 注册信息
     * @return token
     */
    String signUp(LivechatUserRegistration user);

    /**
     * 登陆，成功登陆返回一个令牌
     *
     * @param phone    手机号
     * @param password 密码
     * @return token
     */
    String signIn(String phone, String password);

    /**
     * 获取用户资料
     *
     * @param userId 主键
     * @return 用户资料
     */
    LivechatUser findByUserId(Long userId);

    /**
     * 获取用户关系列表
     *
     * @param userId 主键
     * @return 关系列表
     */
    List<LivechatUserRelationVO> findFriendsByUserId(Long userId);
}
