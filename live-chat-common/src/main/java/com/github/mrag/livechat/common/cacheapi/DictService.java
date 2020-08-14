package com.github.mrag.livechat.common.cacheapi;

import com.github.mrag.livechat.common.SystemDict;

import java.util.List;

public interface DictService {

    List<SystemDict> findByKey(String key);

    SystemDict findByKeyValue(String key, Integer valueNo);

    boolean kvExists(String key, Integer valueNo);

    void save(SystemDict dictItem);

    void remove(Integer kvId);
}
