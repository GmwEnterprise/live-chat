package com.github.mrag.livechat.common.cache.api;

import com.github.mrag.livechat.common.SystemDict;
import com.github.mrag.livechat.common.cache.vo.City;

import java.util.List;

public interface DictService {

    List<SystemDict> findByKey(String key);

    SystemDict findByKeyValue(String key, Integer valueNo);

    boolean kvExists(String key, Integer valueNo);

    void save(SystemDict dictItem);

    void remove(Integer kvId);

    List<City> allCities();
}
