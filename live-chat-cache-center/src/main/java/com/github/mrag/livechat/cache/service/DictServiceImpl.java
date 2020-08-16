package com.github.mrag.livechat.cache.service;

import com.github.mrag.livechat.cache.dao.SystemDictMapper;
import com.github.mrag.livechat.common.SystemDict;
import com.github.mrag.livechat.common.cache.api.DictService;
import org.apache.dubbo.config.annotation.DubboService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Resource;
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
        if (dictItem.getKvId() == null || !kvExists(dictItem.getKey(), dictItem.getValueNo())) {
            // insert
            synchronized (this) {
                // 同步防止主键重复
                if (dictItem.getKvId() == null) {
                    Integer maxKvId = dictMapper.findMaxKvId();
                    dictItem.setKvId(maxKvId != null ? maxKvId + 1 : 1);
                }
                dictMapper.insertSelective(dictItem);
            }
        } else {
            // update
            dictMapper.updateByPrimaryKeySelective(dictItem);
        }
    }

    @Override
    public void remove(Integer kvId) {
        dictMapper.deleteByPrimaryKey(kvId);
    }
}
