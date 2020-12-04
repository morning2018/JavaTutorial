package com.learning.jdbc.dbpool.c3p0;

import java.beans.PropertyVetoException;
import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class C3p0DataSourceUtil {

    public static DataSource createDataSource() {
        ComboPooledDataSource ds = new ComboPooledDataSource();
        try {
            ds.setDriverClass("com.mysql.jdbc.Driver");
            ds.setJdbcUrl("jdbc:mysql://49.233.165.151:3306/iot?useSSL=false&characterEncoding=utf8");
            ds.setUser("root");
            ds.setPassword("Smartpaas@2019");

            //最初连接数
            ds.setInitialPoolSize(10);
            //最小连接数
            ds.setMinPoolSize(5);
            //最大连接数
            ds.setMaxPoolSize(20);
        }
        catch (PropertyVetoException e) {
            log.error("create ds error", e);
        }
        return  ds;
    }
}
