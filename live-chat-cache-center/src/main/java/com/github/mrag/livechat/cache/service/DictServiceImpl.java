package com.github.mrag.livechat.cache.service;

import com.github.mrag.livechat.cache.dao.SystemDictMapper;
import com.github.mrag.livechat.common.SystemDict;
import com.github.mrag.livechat.common.cache.api.DictService;
import com.github.mrag.livechat.common.cache.vo.City;
import org.apache.dubbo.config.annotation.DubboService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Gmw
 */
@DubboService
public class DictServiceImpl implements DictService {
    private static final Logger log = LoggerFactory.getLogger(DictServiceImpl.class);

    @Resource
    private SystemDictMapper dictMapper;

    @Override
    public List<SystemDict> findByKey(String key) {
        return dictMapper.selectByKey(key);
    }

    @Override
    public SystemDict findByKeyValue(String key, Integer valueNo) {
        return dictMapper.selectByKv(key, valueNo);
    }

    @Override
    public boolean kvExists(String key, Integer valueNo) {
        return dictMapper.countByKv(key, valueNo) > 0;
    }

    @Override
    public void save(SystemDict dictItem) {
        if (dictItem.getKvId() == null) {
            if (kvExists(dictItem.getKey(), dictItem.getValueNo())) {
                dictMapper.updateByPrimaryKeySelective(dictItem);
            } else {
                dictMapper.insertSelective(dictItem);
            }
        } else {
            SystemDict item = dictMapper.selectByPrimaryKey(dictItem.getKvId());
            if (item != null) {
                dictMapper.updateByPrimaryKeySelective(dictItem);
            } else {
                dictItem.setKvId(null);
                dictMapper.insertSelective(dictItem);
            }
        }
    }

    @Override
    public void remove(Integer kvId) {
        dictMapper.deleteByPrimaryKey(kvId);
    }

    @Override
    public List<City> allCities() {
        List<City> cities = new ArrayList<>();
        List<SystemDict> dictList = findByKey("city");
        dictList.forEach(item -> {
            if (item.getDependencyOnId() == 0) {
                City city = new City().setCityId(item.getValueNo())
                        .setCityName(item.getValueDesc())
                        .setLevelId(item.getValueMoreDetail());
                city.setSubCities(recursiveCities(dictList, city.getCityId()));
                cities.add(city);
            }
        });
        return cities;
    }

    private List<City> recursiveCities(List<SystemDict> sources, int fid) {
        List<City> cities = new ArrayList<>();
        sources.stream().filter(dict -> dict.getDependencyOnId() == fid).forEach(item -> {
            City city = new City().setCityId(item.getValueNo())
                    .setCityName(item.getValueDesc())
                    .setLevelId(item.getValueMoreDetail());
            city.setSubCities(recursiveCities(sources, city.getCityId()));
            cities.add(city);
        });
        return cities;
    }
}
