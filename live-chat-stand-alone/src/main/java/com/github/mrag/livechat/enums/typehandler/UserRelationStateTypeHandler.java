package com.github.mrag.livechat.enums.typehandler;

import com.github.mrag.livechat.enums.UserRelationState;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.apache.ibatis.type.MappedTypes;
import org.apache.ibatis.type.TypeHandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@MappedTypes(UserRelationState.class)
@MappedJdbcTypes(JdbcType.TINYINT)
public class UserRelationStateTypeHandler implements TypeHandler<UserRelationState> {
    @Override
    public void setParameter(PreparedStatement ps, int i, UserRelationState parameter, JdbcType jdbcType) throws SQLException {
        ps.setInt(i, parameter.getKey());
    }

    @Override
    public UserRelationState getResult(ResultSet rs, String columnName) throws SQLException {
        return UserRelationState.find(rs.getInt(columnName));
    }

    @Override
    public UserRelationState getResult(ResultSet rs, int columnIndex) throws SQLException {
        return UserRelationState.find(rs.getInt(columnIndex));
    }

    @Override
    public UserRelationState getResult(CallableStatement cs, int columnIndex) throws SQLException {
        return UserRelationState.find(cs.getInt(columnIndex));
    }
}
