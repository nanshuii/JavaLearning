package com.dao;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public class BaseDao {
    private static DataSource dataSource;

    /**
     * 静态代码块初始化Datasource
     */
    static {
        Properties properties = new Properties();
        InputStream resourceAsStream = BaseDao.class.getClassLoader().getResourceAsStream("druid.properties");
        try {
            properties.load(resourceAsStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            dataSource = DruidDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取DataSource
     * @return DataSource
     */
    public static DataSource getDataSource() {
        return dataSource;
    }

    /**
     * 获取连接
     * @return Connection
     */
    public static Connection getConnection() {
        Connection connection = null;
        try {
            connection = dataSource.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    /**
     * 执行数据库的insert，update，delete操作
     * @param sql sql 带问号的语句
     * @param params 问号对应的参数
     * @return 执行是否成功；大于0则成功
     */
    public static int executeIUD(String sql, Object[] params) {
        int count = 0;
        Connection connection = BaseDao.getConnection();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(sql);
            for (int i = 0; i < params.length; i++) {
                preparedStatement.setObject(i+1, params[i]);
            }
            count = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            BaseDao.closeAll(null, preparedStatement, connection);
        }
        return count;
    }

    /**
     * 执行数据读取
     * @param sql sql
     * @param params params
     * @return ResultSet
     */
    public static ResultSet getResults(String sql, Object[] params) {
        ResultSet resultSet = null;
        Connection connection = BaseDao.getConnection();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(sql);
            for (int i = 0; i < params.length; i++) {
                preparedStatement.setObject(i+1, params[i]);
            }
            resultSet = preparedStatement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
//            BaseDao.closeAll(null, preparedStatement, connection);
        }
        return resultSet;
    }

    /**
     * 关闭数据库用到的资源
     * @param resultSet resultSet
     * @param preparedStatement preparedStatement
     * @param connection connection
     */
    public static void closeAll(ResultSet resultSet, PreparedStatement preparedStatement, Connection connection) {
        try {
            if (resultSet != null) {
                resultSet.close();
            }
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
