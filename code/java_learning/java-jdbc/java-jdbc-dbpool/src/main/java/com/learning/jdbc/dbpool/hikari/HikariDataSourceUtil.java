package com.learning.jdbc.dbpool.hikari;

import javax.sql.DataSource;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class HikariDataSourceUtil {

    public static DataSource createDataSource() {
        HikariConfig conf = new HikariConfig();
        conf.setUsername("root");
        conf.setPassword("Smartpaas@2019");
        conf.setJdbcUrl("jdbc:mysql://49.233.165.151:3306/iot?useSSL=false&characterEncoding=utf8");
        return new HikariDataSource(conf);
    }
}
