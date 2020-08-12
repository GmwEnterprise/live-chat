package com.github.mrag.livechat.usermsg.dao;

import com.github.mrag.livechat.usermsg.entity.User;

public interface UserMapper {
    int deleteByPrimaryKey(Long id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    User selectByChatNo(String chatNo);

    long countByPhoneNumber(String phone);

    User selectByPhoneNumber(String phone);
}