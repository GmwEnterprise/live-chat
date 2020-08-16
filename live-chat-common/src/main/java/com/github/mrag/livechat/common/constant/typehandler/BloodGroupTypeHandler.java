package com.github.mrag.livechat.common.constant.typehandler;

import com.github.mrag.livechat.common.constant.enums.BloodGroup;
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
@MappedTypes(BloodGroup.class)
@MappedJdbcTypes(JdbcType.INTEGER)
public class BloodGroupTypeHandler implements TypeHandler<BloodGroup> {
    @Override
    public void setParameter(PreparedStatement ps, int i, BloodGroup parameter, JdbcType jdbcType) throws SQLException {
        ps.setInt(i, parameter.getValueNo());
    }

    @Override
    public BloodGroup getResult(ResultSet rs, String columnName) throws SQLException {
        return BloodGroup.findByValue(rs.getInt(columnName));
    }

    @Override
    public BloodGroup getResult(ResultSet rs, int columnIndex) throws SQLException {
        return BloodGroup.findByValue(rs.getInt(columnIndex));
    }

    @Override
    public BloodGroup getResult(CallableStatement cs, int columnIndex) throws SQLException {
        return BloodGroup.findByValue(cs.getInt(columnIndex));
    }
}
