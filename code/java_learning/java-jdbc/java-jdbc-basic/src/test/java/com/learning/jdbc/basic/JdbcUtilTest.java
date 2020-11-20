package com.learning.jdbc.basic;

import org.junit.Test;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class JdbcUtilTest {

    @Test
    public void testQueryByStatement() throws SQLException, ClassNotFoundException {
        String sql = "select * from sys_user";
        List<Map<String, Object>> list = JdbcUtil.queryByStatement(sql);
        if (!list.isEmpty()) {
            for (Map map : list) {
                System.out.println(JSON.toJSONString(map));
            }
        }
    }

    @Test
    public void testQueryByPreparedStatement() {
        String sql = "select * from sys_user where user_id in (?)";
        List<Object> params = Lists.newArrayList();
        params.add(1);
        params.add(2);
        List<Map<String, Object>> list = JdbcUtil.queryByPreparedStatement(sql, params);
        if (!list.isEmpty()) {
            for (Map map : list) {
                System.out.println(JSON.toJSONString(map));
            }
        }
    }
}
