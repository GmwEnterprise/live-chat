package com.github.mrag.livechat.usermsg.service;

import com.github.mrag.livechat.common.Constants;
import com.github.mrag.livechat.usermsg.api.UserService;
import com.github.mrag.livechat.usermsg.dao.ChatUsermsgDynamicSqlSupport;
import com.github.mrag.livechat.usermsg.dao.ChatUsermsgMapper;
import com.github.mrag.livechat.usermsg.dto.ChatUsermsgDTO;
import com.github.mrag.livechat.usermsg.entity.ChatUsermsg;
import org.apache.dubbo.config.annotation.DubboService;
import org.mybatis.dynamic.sql.SqlBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;

import javax.annotation.Resource;

/**
 * @author Gmw
 */
@DubboService(group = Constants.DUBBO_SERV_GROUP, version = Constants.DUBBO_SERV_VERSION)
public class UserServiceImpl implements UserService {
    private static final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);

    @Resource
    private ChatUsermsgMapper chatUsermsgMapper;

    @Override
    public ChatUsermsgDTO findUserById(Long uid) {
        return chatUsermsgMapper.selectByPrimaryKey(uid).map(this::toDto).orElse(null);
    }

    @Override
    public ChatUsermsgDTO findUserByChatNo(String chatNo) {
        return chatUsermsgMapper.selectOne(dsl -> dsl
                .where(ChatUsermsgDynamicSqlSupport.chatNo, SqlBuilder.isEqualTo(chatNo)))
                .map(this::toDto).orElse(null);
    }

    @Override
    public void save(ChatUsermsgDTO chatUsermsgDTO) {
        ChatUsermsg entity = toEntity(chatUsermsgDTO);
        if (entity.getId() != null) {
            // update
            chatUsermsgMapper.updateByPrimaryKeySelective(entity);
        } else {
            entity.setId(null);
            chatUsermsgMapper.insertSelective(entity);
        }
    }

    private ChatUsermsgDTO toDto(ChatUsermsg entity) {
        ChatUsermsgDTO dto = new ChatUsermsgDTO();
        BeanUtils.copyProperties(entity, dto);
        return dto;
    }

    private ChatUsermsg toEntity(ChatUsermsgDTO dto) {
        ChatUsermsg entity = new ChatUsermsg();
        BeanUtils.copyProperties(dto, entity);
        return entity;
    }
}
