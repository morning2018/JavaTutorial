package com.learning.jdbc.dbpool.dbcp;

import org.junit.Test;

import java.sql.Connection;
import java.sql.ResultSet;

public class DbcpTest {

    @Test
    public void testQuery() throws Exception {
        Connection connection =  DbcpDataSourcesUtil.createDataSource().getConnection();
        String sql = "select  * from sys_user";
        ResultSet resultSet = connection.createStatement().executeQuery(sql);
        while (resultSet.next()) {
            System.out.println(resultSet.getString("user_name"));
        }
    }
}
