package com.github.mrag.livechat.usermsg.api;

import com.github.mrag.livechat.usermsg.dto.ChatUsermsgDTO;

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
    ChatUsermsgDTO findUserById(Long uid);

    /**
     * 通过微信号查询用户
     *
     * @param chatNo 微信号
     * @return 若存在则返回用户信息；否则返回<code>null</code>
     */
    ChatUsermsgDTO findUserByChatNo(String chatNo);

    /**
     * 保存用户信息
     *
     * @param chatUsermsgDTO 用户信息
     */
    void save(ChatUsermsgDTO chatUsermsgDTO);
}
