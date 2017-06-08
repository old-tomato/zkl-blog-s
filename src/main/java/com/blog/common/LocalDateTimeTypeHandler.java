/*
 * Copyright © 上海庆谷豆信息科技有限公司.
 */

package com.blog.common;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedTypes;

import java.sql.*;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

/**
 *
 */
@MappedTypes(LocalDateTime.class)
public class LocalDateTimeTypeHandler extends BaseTypeHandler<LocalDateTime> {
    public static final ZoneOffset TIMEZONE_CHINA = ZoneOffset.ofHours(8);

    @Override
    public void setNonNullParameter(PreparedStatement ps, int columnIndex, LocalDateTime parameter, JdbcType jdbcType) throws SQLException {
        Timestamp ts = new Timestamp(Date.from(parameter.toInstant(TIMEZONE_CHINA)).getTime());
        ps.setTimestamp(columnIndex, ts);
    }

    @Override
    public LocalDateTime getNullableResult(ResultSet rs, String columnName) throws SQLException {
        Timestamp ts = rs.getTimestamp(columnName);
        return ts == null ? null : ts.toLocalDateTime();
    }

    @Override
    public LocalDateTime getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        Timestamp ts = rs.getTimestamp(columnIndex);
        return ts == null ? null : ts.toLocalDateTime();
    }

    @Override
    public LocalDateTime getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        Timestamp ts = cs.getTimestamp(columnIndex);
        return ts == null ? null : ts.toLocalDateTime();
    }
}
