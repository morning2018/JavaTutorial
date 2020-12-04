package com.learning.jdbc.dbpool.hikari;

import com.learning.jdbc.dbpool.druid.DruidDataSourceUtil;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.Test;

public class HikariTest {

    @Test
    public void testQuery() throws SQLException {
        Connection connection = HikariDataSourceUtil.createDataSource().getConnection();
        String sql = "select user_id, user_name,email from sys_user";
        ResultSet result = connection.createStatement().executeQuery(sql);
        while (result.next()) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(result.getString("user_id"))
                .append(":::")
                .append(result.getString("user_name"))
                .append(":::")
                .append(result.getString("email"));
            System.out.println(stringBuilder.toString());
        }
    }
}
