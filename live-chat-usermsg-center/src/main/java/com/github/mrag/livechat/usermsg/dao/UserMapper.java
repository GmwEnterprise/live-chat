package com.github.mrag.livechat.usermsg.dao;

import com.github.mrag.livechat.usermsg.entity.User;

public interface UserMapper {
    int deleteByPrimaryKey(Long id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    User selectByWechatNo(String chatNo);

    long countByPhoneNumber(String phone);

    User selectByLoginKey(String key);

    String selectUserPasswordByUserId(long userId);
}