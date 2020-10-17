package com.github.mrag.livechat.modules.cache.dao;

import com.github.mrag.livechat.modules.cache.entity.LivechatDict;

public interface LivechatDictMapper {
    int deleteByPrimaryKey(Integer kvId);

    int insert(LivechatDict record);

    int insertSelective(LivechatDict record);

    LivechatDict selectByPrimaryKey(Integer kvId);

    int updateByPrimaryKeySelective(LivechatDict record);

    int updateByPrimaryKey(LivechatDict record);
}