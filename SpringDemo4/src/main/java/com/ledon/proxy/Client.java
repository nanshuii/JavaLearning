package com.ledon.proxy;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 模拟消费者
 */
public class Client {
    public static void main(String[] args) {
        /**
         * 动态代理
         * 字节码随用随创建，随用随加载
         * 在不修改源码的基础上对方法增强
         *
         * 基于接口的动态代理
         *  Proxy
         *  创建：Proxy类中的newProxyInstance方法
         *  要求：被代理类最少实现一个接口
         *  方法参数：
         *      ClassLoader 类加载器
         *          用于加载代理对象字节码；和被代理对象使用相同的类加载器
         *      Class[] 字节码数组
         *          用于让代理对象和被代理对象有相同方法
         *      InvocationHandler 用于提供增强的代码
         *          如何代理；一般都是该接口的实现类，通常是匿名内部类
         *
         * 基于子类的动态代理
         *  Enhancer
         *  创建：Enhancer中的create方法
         *  要求：被代理类不能是最终类，要有子类
         *  方法参数：
         *      Class：字节码
         *          用于指定被代理对象的字节码
         *      Callback：用于提供增强的代码
         *          如何代理；一般都是该接口的实现类，通常是匿名内部类；
         *          一般使用该接口的子接口实现类 MethodInterceptor
         *
         */
        final Producer producer = new Producer();
        IProducer producerProxy = (IProducer) Proxy.newProxyInstance(producer.getClass().getClassLoader(),
                producer.getClass().getInterfaces(),
                new InvocationHandler() {
                    /**
                     * 执行被代理对象的任何接口方法都会经过该方法
                     * @param proxy 代理对象的引用
                     * @param method 当前执行的方法
                     * @param args 当前执行方法所需的参数
                     * @return 和被代理对象有相同的返回值
                     * @throws Throwable
                     */
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        // 提供增强的代码
                        Object returnValue = null;
                        // 获取方法执行的参数
                        Float money = (Float)args[0];
                        // 判断当前方法是不是销售方法sale
                        if ("saleProduct".equals(method.getName())){
                            returnValue = method.invoke(producer, money * 0.8f);
                        }
                        return returnValue;
                    }
                });
        producerProxy.saleProduct(10000f);

        Producer cglibProducer = (Producer)Enhancer.create(producer.getClass(),
                new MethodInterceptor() {
                    /**
                     * 执行被代理对象的任何方法都会经过该方法
                     * @param o 代理对象的引用
                     * @param method 当前执行的方法
                     * @param objects 当前执行方法所需的参数
                     * @param methodProxy 当前执行方法的代理对象
                     * @return 和被代理对象有相同的返回值
                     * @throws Throwable
                     */
                    @Override
                    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                        Object returnValue = null;
                        Float money = (Float)objects[0];
                        if ("saleProduct".equals(method.getName())) {
                            returnValue = method.invoke(producer, money * 0.8f);
                    }
                        return returnValue;
                }
    });
    cglibProducer.saleProduct(10000f);
    }
}
