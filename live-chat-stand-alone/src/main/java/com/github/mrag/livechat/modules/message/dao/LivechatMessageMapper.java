package com.github.mrag.livechat.modules.message.dao;

import com.github.mrag.livechat.modules.message.entity.LivechatMessage;

public interface LivechatMessageMapper {
    int deleteByPrimaryKey(Long id);

    int insert(LivechatMessage record);

    int insertSelective(LivechatMessage record);

    LivechatMessage selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(LivechatMessage record);

    int updateByPrimaryKey(LivechatMessage record);
}