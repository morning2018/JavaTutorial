package com.learning.jdbc.basic;

import com.alibaba.fastjson.JSON;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Test;

public class ResultSetTest {

    @Test
    public void testResultSet() {
        String sql = "select * from sys_user";
        try ( Connection connection = JdbcUtil.getConnection();
            Statement statement = connection.createStatement();) {
            ResultSet resultSet = statement.executeQuery(sql);
            System.out.println("MetaData:" + JSON.toJSONString(resultSet.getMetaData()));
            System.out.println("getRow:" + resultSet.getRow());
            System.out.println("getType:" + resultSet.getType());
            System.out.println("getConcurrency:" + resultSet.getConcurrency());
            //System.out.println("getCursorName:" + resultSet.getCursorName());
            System.out.println("getFetchSize:" + resultSet.getFetchSize());
            System.out.println("getFetchDirection:" + resultSet.getFetchDirection());
            System.out.println("getWarnings:" + JSON.toJSONString(resultSet.getWarnings()));
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
