package com.ledon.util;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * 连接数据库的工具类，并且实现和线程的绑定
 */
public class ConnectionUtils {

    private ThreadLocal<Connection> threadLocal = new ThreadLocal<Connection>();

    private DataSource dataSource;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    /**
     * 获取当前线程上的连接
     * @return
     */
    public Connection getThreadConnection() {
        // 获取一个连接
        Connection connection = threadLocal.get();
        try {
            if (connection == null) {
                connection = dataSource.getConnection();
                threadLocal.set(connection);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    /**
     * 去掉连接池
     */
    public void removeConnection() {
        threadLocal.remove();
    }




}
