package com.ledon.mybatis.proxy;

import com.ledon.mybatis.cfg.Mapper;
import com.ledon.mybatis.utils.Executor;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;

public class MapperProxy implements InvocationHandler {

    // key是全限定类名加方法名
    private Map<String, Mapper> mappers;
    private Connection connection;

    public MapperProxy(Map<String, Mapper> mappers, Connection connection) {
        this.mappers = mappers;
        this.connection = connection;
    }

    /**
     * 用于对方法进行增强，调用selectList方法
     * @param proxy
     * @param method
     * @param args
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        // 获取方法名和方法所在类的名称，组合成key
        String methodName = method.getName();
        String className = method.getDeclaringClass().getName();
        String key = className + "." + methodName;
        // 获取mappers中的mapper对象
        Mapper mapper = mappers.get(key);
        if (mapper == null) {
            throw new IllegalArgumentException("传入的参数有误");
        }
        return new Executor().selectList(mapper, connection);
    }
}
