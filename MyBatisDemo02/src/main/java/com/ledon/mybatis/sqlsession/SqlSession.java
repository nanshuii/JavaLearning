package com.ledon.mybatis.sqlsession;

/**
 * 自定义mybatis中和数据库交互的核心类，可以创建dao代理
 */
public interface SqlSession {

    /**
     * 根据class参数创建一个代理对象
     * @param daoInterfaceClass dao接口字节码
     * @param <T>
     * @return
     */
    <T> T getMapper(Class<T> daoInterfaceClass);

    /**
     * 释放资源
     */
    void close();
}
