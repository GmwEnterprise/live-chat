package com.github.mrag.livechat.client.service;

import com.github.mrag.livechat.usermsg.api.UserService;
import com.github.mrag.livechat.usermsg.dto.ChatUsermsgDTO;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Override
    public ChatUsermsgDTO findUserById(Long uid) {
        return null;
    }

    @Override
    public ChatUsermsgDTO findUserByChatNo(String chatNo) {
        return null;
    }

    @Override
    public void save(ChatUsermsgDTO chatUsermsgDTO) {
    }

    @Override
    public boolean checkPhoneExists(String phone) {
        // TODO
        return false;
    }
}
