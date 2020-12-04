package com.learning.jdbc.dbpool.druid;

import javax.sql.DataSource;

import com.alibaba.druid.pool.DruidDataSource;

/**
 *  druid data source util
 * @author morning
 * @date 2020/11/22 22:23
 * @since 0.0.1
 */
public final class DruidDataSourceUtil {

    public static DataSource createDataSource() {
        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setDriverClassName("com.mysql.jdbc.Driver");
        druidDataSource.setUrl("jdbc:mysql://49.233.165.151:3306/iot?useSSL=false&characterEncoding=utf8");
        druidDataSource.setUsername("root");
        druidDataSource.setPassword("Smartpaas@2019");
        druidDataSource.setMinIdle(5);
        druidDataSource.setMaxActive(40);
        druidDataSource.setInitialSize(5);
        return druidDataSource;
    }
}
