package com.github.mrag.livechat.modules.user.service.impl;

import com.github.mrag.livechat.modules.user.dao.LivechatUserMapper;
import com.github.mrag.livechat.modules.user.dto.LivechatUserRegistration;
import com.github.mrag.livechat.modules.user.entity.LivechatUser;
import com.github.mrag.livechat.modules.user.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserServiceImpl implements UserService {
    private static final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);

    @Resource
    private LivechatUserMapper userMapper;

    @Override
    public String signUp(LivechatUserRegistration user) {
        if (user.getUsername() == null) {
            user.setUsername(user.getPhoneNumber());
        }
        LivechatUser record = new LivechatUser();
        // 生成主键的代码复制过来
        userMapper.insertSelective(record);
    }

    @Override
    public String signIn(String verificationText) {
        return null;
    }

    @Override
    public LivechatUser findByUserId(Long userId) {
        return null;
    }
}
