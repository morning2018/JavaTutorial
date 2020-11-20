package com.learning.jdbc.basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.common.base.Preconditions;
import lombok.extern.slf4j.Slf4j;

/**
 *  DataSourceUtil
 * @author morning
 * @date 2020/11/20 16:01
 * @since 0.0.1
 */
@Slf4j
public final class JdbcUtil {
    private static final String URL = "jdbc:mysql://49.233.165.151:3306/iot?useSSL=false&characterEncoding=utf8";

    private static final String USERNAME = "root";

    private static final String PASSWORD = "Smartpaas@2019";

    public static Connection getConnection() {
        return getConnection(URL, USERNAME, PASSWORD);
    }

    private static Connection getConnection(String url, String username, String password) {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(url, username, password);
        }
        catch (ClassNotFoundException e) {
            Preconditions.checkState(Boolean.FALSE, "com.mysql.jdbc.Driver not found");
        }
        catch (SQLException e) {
            Preconditions.checkState(Boolean.FALSE, "get connection error," + e.getSQLState());
        }

        return connection;
    }
    public static void release(Connection connection, Statement statement, ResultSet resultSet) {
        if (resultSet != null) {
            try {
                resultSet.close();
            }
            catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (statement != null) {
            try {
                statement.close();
            }
            catch (SQLException e) {
               e.printStackTrace();
            }
        }
        if (connection != null) {
            try {
                connection.close();
            }
            catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static List<Map<String, Object>> queryByStatement(String sql) {
        List<Map<String, Object>> listMap = null;
        ResultSet resultSet = null;
        try (Connection connection = getConnection();
            Statement statement = connection.createStatement();) {
            resultSet = statement.executeQuery(sql);
            listMap = covertResult(resultSet);
        }
        catch (SQLException e) {
            Preconditions.checkState(Boolean.FALSE, "query sql error :" + e.getSQLState());
        }
        finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
                }
                catch (SQLException e) {
                    Preconditions.checkState(Boolean.FALSE, "close result error:" + e.getSQLState());
                }
            }
        }
        return listMap;
    }

    public static List<Map<String, Object>> queryByPreparedStatement(String sql, List<Object> params) {
        List<Map<String, Object>> listMap = null;
        ResultSet resultSet = null;
        try (Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            setParams(preparedStatement, params);
            resultSet = preparedStatement.executeQuery();
            listMap = covertResult(resultSet);
        }
        catch (SQLException e) {
            Preconditions.checkState(Boolean.FALSE, "query sql error : " + e.getSQLState());
        }
        return listMap;
    }

    private static void setParams(PreparedStatement preparedStatement, List<Object> params) throws SQLException {
        if (params == null || params.isEmpty()) {
            return;
        }
        for (int i = 0; i < params.size(); i++) {
            Object param = params.get(i);
            int index = i + 1;
            if (param instanceof String) {
                preparedStatement.setString(index,  String.valueOf(param));
            }
            else if (param instanceof Integer) {
                preparedStatement.setInt(index, (Integer) param);
            }
            else if (param instanceof Long) {
                preparedStatement.setLong(index, (Long) param);
            }
            else if (param instanceof Date || param instanceof java.sql.Date) {
                preparedStatement.setDate(index, (java.sql.Date) param);
            }
            else {
                preparedStatement.setObject(index, param);
            }
        }
    }
    private static List<Map<String, Object>> covertResult(ResultSet resultSet) throws SQLException {
        List<Map<String, Object>> listMap = new ArrayList<>();
        Map<String, Object> map = null;
        ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
        int count = resultSetMetaData.getColumnCount();
        while (resultSet.next()) {
            map = new HashMap<>(resultSet.getRow());
            for (int i = 1; i <= count; i++) {
                String label = resultSetMetaData.getColumnLabel(i);
                int type = resultSetMetaData.getColumnType(i);
                Object object = columnValue(type, resultSet, label);
                map.put(label, object);
            }
            listMap.add(map);
        }
        return listMap;
    }
    private static Object columnValue(int type, ResultSet resultSet, String label) throws SQLException {
        switch (type) {
            case Types.BIGINT:
                return resultSet.getLong(label);
            case Types.LONGNVARCHAR:
            case Types.CHAR:
            case Types.NVARCHAR:
            case Types.VARCHAR:
                return resultSet.getString(label);
            case Types.DATE:
            case Types.TIME:
            case Types.TIMESTAMP:
                return resultSet.getDate(label);
            case Types.INTEGER:
            case Types.SMALLINT:
            case Types.TINYINT:
                return resultSet.getInt(label);
            default:
                return resultSet.getObject(label);
        }
    }
}
