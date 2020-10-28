package com.github.mrag.livechat.enums.typehandler;

import com.github.mrag.livechat.enums.ReceiverType;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.apache.ibatis.type.MappedTypes;
import org.apache.ibatis.type.TypeHandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@MappedTypes(ReceiverType.class)
@MappedJdbcTypes(JdbcType.TINYINT)
public class ReceiverTypeHandler implements TypeHandler<ReceiverType> {
    @Override
    public void setParameter(PreparedStatement ps, int i, ReceiverType parameter, JdbcType jdbcType) throws SQLException {
        ps.setInt(i, parameter.getKey());
    }

    @Override
    public ReceiverType getResult(ResultSet rs, String columnName) throws SQLException {
        return ReceiverType.find(rs.getInt(columnName));
    }

    @Override
    public ReceiverType getResult(ResultSet rs, int columnIndex) throws SQLException {
        return ReceiverType.find(rs.getInt(columnIndex));
    }

    @Override
    public ReceiverType getResult(CallableStatement cs, int columnIndex) throws SQLException {
        return ReceiverType.find(cs.getInt(columnIndex));
    }
}
