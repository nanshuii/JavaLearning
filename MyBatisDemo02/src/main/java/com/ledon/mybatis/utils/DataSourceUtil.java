package com.ledon.mybatis.utils;

import com.ledon.mybatis.cfg.Configuration;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * 用于创建数据源工具类
 */
public class DataSourceUtil {

    /**
     * 用于获取一个连接
     * @param cgf
     * @return
     */
    public static Connection getConnection(Configuration cfg) {
        try {
            Class.forName(cfg.getDriver());
            return DriverManager.getConnection(cfg.getUrl(), cfg.getUsername(), cfg.getPassword());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
