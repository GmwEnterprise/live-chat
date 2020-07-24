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
     * 通过用户名查询用户
     *
     * @param username 用户ID
     * @return 若存在则返回用户信息；否则返回<code>null</code>
     */
    UserDTO findUserByUsername(String username);

    /**
     * 保存用户信息
     *
     * @param userDTO 用户信息
     */
    void save(UserDTO userDTO);
}
