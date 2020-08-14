package com.github.mrag.livechat.cache.dao;

import com.github.mrag.livechat.common.SystemDict;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SystemDictMapper {
    int deleteByPrimaryKey(Integer kvId);

    int insert(SystemDict record);

    int insertSelective(SystemDict record);

    SystemDict selectByPrimaryKey(Integer kvId);

    int updateByPrimaryKeySelective(SystemDict record);

    int updateByPrimaryKey(SystemDict record);

    Integer findMaxKvId();

    List<SystemDict> selectByKey(String key);

    SystemDict selectByKv(@Param("key") String key, @Param("val") Integer valueNo);

    int countByKv(@Param("key") String key, @Param("val") Integer valueNo);
}