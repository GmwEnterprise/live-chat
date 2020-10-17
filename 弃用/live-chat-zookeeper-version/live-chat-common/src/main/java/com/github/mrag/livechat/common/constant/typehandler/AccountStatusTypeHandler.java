package com.github.mrag.livechat.common.constant.typehandler;

import com.github.mrag.livechat.common.constant.enums.AccountStatus;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.apache.ibatis.type.MappedTypes;
import org.apache.ibatis.type.TypeHandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@MappedTypes(AccountStatus.class)
@MappedJdbcTypes(JdbcType.TINYINT)
public class AccountStatusTypeHandler implements TypeHandler<AccountStatus> {
    @Override
    public void setParameter(PreparedStatement ps, int i, AccountStatus parameter, JdbcType jdbcType) throws SQLException {
        ps.setInt(i, parameter.getValueNo());
    }

    @Override
    public AccountStatus getResult(ResultSet rs, String columnName) throws SQLException {
        return AccountStatus.findByValue(rs.getInt(columnName));
    }

    @Override
    public AccountStatus getResult(ResultSet rs, int columnIndex) throws SQLException {
        return AccountStatus.findByValue(rs.getInt(columnIndex));
    }

    @Override
    public AccountStatus getResult(CallableStatement cs, int columnIndex) throws SQLException {
        return AccountStatus.findByValue(cs.getInt(columnIndex));
    }
}
