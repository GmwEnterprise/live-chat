package com.github.mrag.livechat.usermsg.api;

import com.github.mrag.livechat.usermsg.dto.UserDTO;

/**
 * 用户服务提供
 *
 * @author Gmw
 */
public interface UserService {
    /**
     * 通过用户ID查询用户
     *
     * @param uid 用户ID
     * @return 若存在则返回用户信息；否则返回<code>null</code>
     */
    UserDTO findUserById(Long uid);

    /**
     * 通过微信号查询用户
     *
     * @param chatNo 微信号
     * @return 若存在则返回用户信息；否则返回<code>null</code>
     */
    UserDTO findUserByChatNo(String chatNo);

    /**
     * 保存用户信息
     *
     * @param dto 用户信息
     * @return 更新后的信息
     */
    UserDTO save(UserDTO dto);

    /**
     * 登陆
     *
     * @param phone    手机号码
     * @param password 密码
     * @return 登陆成功则返回用户信息；失败则抛异常
     */
    UserDTO login(String phone, String password);

    /**
     * 检查数据库中是否有这个手机号的账户存在，返回布尔值
     *
     * @param phone 手机号
     * @return 是否存在
     */
    boolean checkPhoneExists(String phone);
}
