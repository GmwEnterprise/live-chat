package com.github.mrag.livechat.usermsg.service;

import com.github.mrag.livechat.common.BusinessType;
import com.github.mrag.livechat.common.RegExp;
import com.github.mrag.livechat.common.Tools;
import com.github.mrag.livechat.common.utils.SequenceUtils;
import com.github.mrag.livechat.usermsg.api.UserService;
import com.github.mrag.livechat.usermsg.dao.UserMapper;
import com.github.mrag.livechat.usermsg.dto.UserDTO;
import com.github.mrag.livechat.usermsg.entity.User;
import org.apache.dubbo.config.annotation.DubboService;

import javax.annotation.Resource;
import java.util.regex.Pattern;

/**
 * @author Gmw
 */
@DubboService
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public UserDTO findUserById(Long uid) {
        User entity = userMapper.selectByPrimaryKey(uid);
        if (entity == null) {
            return null;
        }
        return Tools.copyProperties(entity, UserDTO.class);
    }

    @Override
    public UserDTO findUserByChatNo(String chatNo) {
        User entity = userMapper.selectByChatNo(chatNo);
        if (entity == null) {
            return null;
        }
        return Tools.copyProperties(entity, UserDTO.class);
    }

    @Override
    public UserDTO save(UserDTO dto) {
        User user = Tools.copyProperties(dto, User.class);
        if (user.getId() == null) {
            // insert
            user.setId(SequenceUtils.nextId(BusinessType.USER_BUSINESS));
            userMapper.insertSelective(user);
        } else {
            userMapper.updateByPrimaryKeySelective(user);
        }
        return findUserById(user.getId());
    }

    @Override
    public boolean checkPhoneExists(String phone) {
        if (!Pattern.matches(RegExp.REGEXP_PHONE, phone)) {
            throw new IllegalArgumentException(String.format("%s[%s]", RegExp.REGEXP_PHONE_MSG, phone));
        }
        return userMapper.countByPhoneNumber(phone) > 0;
    }
}
