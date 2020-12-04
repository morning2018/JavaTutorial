package com.learning.jdbc.dbpool.dbcp;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Properties;
import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSourceFactory;

/**
 *  DbcpDataSourcesUtil
 * @author morning
 * @date 2020/11/22 22:23
 * @since 0.0.1
 */
public class DbcpDataSourcesUtil {

    public static DataSource createDataSource() throws Exception {
        InputStream stream = DbcpDataSourcesUtil.class.getClassLoader().getResourceAsStream("dbcpconfig.properties");
        Properties prop = new Properties();
        prop.load(stream);
        DataSource dataSource = BasicDataSourceFactory.createDataSource(prop);
        return dataSource;
    }

    public static void main(String[] args) throws Exception {

    }
}
