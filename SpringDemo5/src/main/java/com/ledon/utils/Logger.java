package com.ledon.utils;

import org.aspectj.lang.ProceedingJoinPoint;

/**
 * 记录日志的工具类
 */
public class Logger {

    /**
     * 打印日志；在切入点方法执行之前执行（业务层方法）
     */
    public void printLog(){
        System.out.println("Logger printLog start...");
    }

    /**
     * 前置通知
     */
    public void beforePrintLog() {
        System.out.println("前置通知 Logger beforePrintLog start...");
    }

    /**
     * 后置通知
     */
    public void afterReturnPrintLog(){
        System.out.println("后置通知 Logger afterReturnPrintLog start...");
    }

    /**
     * 异常通知
     */
    public void afterThrowPrintLog(){
        System.out.println("异常通知 Logger afterThrowPrintLog start...");
    }

    /**
     * 最终通知
     */
    public void afterPrintLog(){
        System.out.println("最终通知 Logger afterPrintLog start...");
    }

    /**
     * 环绕通知
     */
    public Object aroundPrintLog(ProceedingJoinPoint pjp){
        Object returnValue = null;
        try {
            System.out.println("前置通知 start...");
            Object[] args = pjp.getArgs(); // 方法执行所需的参数
            returnValue = pjp.proceed(args); // 调用业务层方法
            System.out.println("后置通知 start...");
        } catch (Throwable throwable) {
            System.out.println("异常通知 start...");
            throwable.printStackTrace();
        } finally {
            System.out.println("最终通知 start...");
        }
        return returnValue;
    }
}
