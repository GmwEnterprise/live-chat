package com.github.mrag.livechat.usermsg.service;

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
@DubboService
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
    public ChatUsermsgDTO save(ChatUsermsgDTO chatUsermsgDTO) {
        ChatUsermsg entity = toEntity(chatUsermsgDTO);
        if (entity.getId() != null) {
            // update
            chatUsermsgMapper.updateByPrimaryKeySelective(entity);
        } else {
            entity.setId(null); // TODO
            chatUsermsgMapper.insertSelective(entity);
        }
        return findUserById(entity.getId());
    }

    @Override
    public boolean checkPhoneExists(String phone) {
        if (phone == null || "".equals(phone.trim())) {
            return false;
        }
        // long count = chatUsermsgMapper.count(dsl -> dsl
        //         .where(ChatUsermsgDynamicSqlSupport.phoneNumber, SqlBuilder.isEqualTo(phone)));
        long count = chatUsermsgMapper.countByPhoneNumber(phone);
        return count > 0;
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
