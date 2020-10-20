package com.github.mrag.livechat.modules.user.service.impl;

import com.github.mrag.livechat.modules.user.dto.LivechatUserRegistration;
import com.github.mrag.livechat.modules.user.entity.LivechatUser;
import com.github.mrag.livechat.modules.user.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private static final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);

    @Override
    public String signUp(LivechatUserRegistration user) {
        return null;
    }

    @Override
    public String signIn(String verificationText) {
        return null;
    }

    @Override
    public LivechatUser findLivechatUserByToken(String token) {
        return null;
    }
}
