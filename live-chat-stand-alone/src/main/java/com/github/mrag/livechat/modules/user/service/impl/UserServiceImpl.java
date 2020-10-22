package com.github.mrag.livechat.modules.user.service.impl;

import com.github.mrag.livechat.common.Constants;
import com.github.mrag.livechat.common.LivechatException;
import com.github.mrag.livechat.common.SequenceUtil;
import com.github.mrag.livechat.modules.user.dao.LivechatUserMapper;
import com.github.mrag.livechat.modules.user.dto.LivechatUserRegistration;
import com.github.mrag.livechat.modules.user.entity.LivechatUser;
import com.github.mrag.livechat.modules.user.service.UserService;
import com.github.mrag.livechat.modules.user.vo.LivechatUserRelationVO;
import com.github.mrag.livechat.web.config.PermissionUtil;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private static final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);

    @Resource
    private LivechatUserMapper userMapper;

    @Override
    public String signUp(LivechatUserRegistration user) {
        // 1. 储存新用户数据
        if (user.getUsername() == null) {
            user.setUsername(user.getPhone());
        }
        LivechatUser record = new LivechatUser()
                // 生成主键
                .setId(SequenceUtil.nextLong())
                .setUsername(user.getUsername())
                .setPhoneNumber(user.getPhone())
                .setEmail(user.getEmail())
                .setUserPassword(user.getPassword())
                .setSalt(Constants.EMPTY_STRING); // TODO 密码加盐加密
        userMapper.insertSelective(record);
        // 2. 创建用户数据后生成令牌token返回客户端
        return PermissionUtil.createTokenWithUserId(record.getId());
    }

    @Override
    public String signIn(String phone, String password) {
        // 获取密码
        LivechatUser userMsg = userMapper.selectPasswordAndSaltByPhoneNumber(phone);
        // 比较用户输入的密码
        if (StringUtils.isNotBlank(userMsg.getSalt())) {
            // 需要加密
            // TODO 密码加盐加密比较
            throw new LivechatException(LivechatException.CODE_PERMISSION, "用户输入密码错误");
        } else {
            // 明文密码
            if (password.equals(userMsg.getUserPassword())) {
                return PermissionUtil.createTokenWithUserId(userMsg.getId());
            }
            throw new LivechatException(LivechatException.CODE_PERMISSION, "密码错误");
        }
    }

    @Override
    public LivechatUser findByUserId(Long userId) {
        return userMapper.selectByPrimaryKey(userId);
    }

    @Override
    public List<LivechatUserRelationVO> findFriendsByUserId(Long userId) {
        // TODO
        return null;
    }
}
