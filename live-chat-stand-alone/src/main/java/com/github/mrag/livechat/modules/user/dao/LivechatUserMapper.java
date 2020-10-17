package com.github.mrag.livechat.modules.user.dao;

import com.github.mrag.livechat.modules.user.entity.LivechatUser;

public interface LivechatUserMapper {
    int deleteByPrimaryKey(Long id);

    int insert(LivechatUser record);

    int insertSelective(LivechatUser record);

    LivechatUser selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(LivechatUser record);

    int updateByPrimaryKey(LivechatUser record);
}