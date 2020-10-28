package com.github.mrag.livechat.enums.typehandler;

import com.github.mrag.livechat.enums.MessageType;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.apache.ibatis.type.MappedTypes;
import org.apache.ibatis.type.TypeHandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@MappedTypes(MessageType.class)
@MappedJdbcTypes(JdbcType.TINYINT)
public class MessageTypeHandler implements TypeHandler<MessageType> {
    @Override
    public void setParameter(PreparedStatement ps, int i, MessageType parameter, JdbcType jdbcType) throws SQLException {
        ps.setInt(i, parameter.getKey());
    }

    @Override
    public MessageType getResult(ResultSet rs, String columnName) throws SQLException {
        return MessageType.find(rs.getInt(columnName));
    }

    @Override
    public MessageType getResult(ResultSet rs, int columnIndex) throws SQLException {
        return MessageType.find(rs.getInt(columnIndex));
    }

    @Override
    public MessageType getResult(CallableStatement cs, int columnIndex) throws SQLException {
        return MessageType.find(cs.getInt(columnIndex));
    }
}
