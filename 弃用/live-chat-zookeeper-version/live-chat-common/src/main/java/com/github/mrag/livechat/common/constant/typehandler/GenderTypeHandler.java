package com.github.mrag.livechat.common.constant.typehandler;

import com.github.mrag.livechat.common.constant.enums.Gender;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.apache.ibatis.type.MappedTypes;
import org.apache.ibatis.type.TypeHandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author Gmw
 */
@MappedTypes(Gender.class)
@MappedJdbcTypes(JdbcType.TINYINT)
public class GenderTypeHandler implements TypeHandler<Gender> {
    @Override
    public void setParameter(PreparedStatement ps, int i, Gender parameter, JdbcType jdbcType) throws SQLException {
        ps.setInt(i, parameter.getValueNo());
    }

    @Override
    public Gender getResult(ResultSet rs, String columnName) throws SQLException {
        return Gender.findByValue(rs.getInt(columnName));
    }

    @Override
    public Gender getResult(ResultSet rs, int columnIndex) throws SQLException {
        return Gender.findByValue(rs.getInt(columnIndex));
    }

    @Override
    public Gender getResult(CallableStatement cs, int columnIndex) throws SQLException {
        return Gender.findByValue(cs.getInt(columnIndex));
    }
}
