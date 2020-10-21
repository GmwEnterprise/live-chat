package com.github.mrag.livechat.modules.user.dao;

import com.github.mrag.livechat.modules.user.entity.LivechatUserRelation;
import org.apache.ibatis.annotations.Param;

public interface LivechatUserRelationMapper {
    int deleteByPrimaryKey(@Param("myId") Long myId, @Param("othersId") Long othersId);

    int insert(LivechatUserRelation record);

    int insertSelective(LivechatUserRelation record);

    LivechatUserRelation selectByPrimaryKey(@Param("myId") Long myId, @Param("othersId") Long othersId);

    int updateByPrimaryKeySelective(LivechatUserRelation record);

    int updateByPrimaryKey(LivechatUserRelation record);
}