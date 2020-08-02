package com.test.demo;

/*
* 接口
* 定义：public interface 接口名称{ //...... }
* 不同版本java下接口内容：
* java7
* 常量 抽象方法
* java8
* 默认方法 静态变量
* java9
* 私有方法
*
* 接口的使用
* 由实现类来实现该接口 public class 实现类名称 implements 接口名称 { //...... }
* 需要覆盖重写接口中的抽象方法
*
* 抽象方法的前面两个关键字 public abstract 可以省略
*
* 默认方法
* public default 返回值类型 方法名称() { //......}
* 接口中的默认方法可以解决接口的升级问题
*
* 静态方法
* public static 返回值名称 方法名称() { // ...... }
* 不可以通过实现类的对象来调用静态方法，直接接口类调用
*
* 私有方法
* 普通私有方法用来解决多个默认方法之间重复代码的问题 private 返回值类型 方法名称(){ //...... }
* 静态私有方法用来解决多个静态方法之间重复代码的问题 private static 返回值类型 方法名称(){ //...... }
*
* 成员变量
* public static final 三个关键字进行修饰，相当于常量，不可修改
* 使用全大写 使用下划线进行分布
*
* */
public interface Test009 {

    // 成员变量
    public static final int NUM = 10;
    int NUM_IN = 11;

    // 抽象方法的前面两个关键字public abstract可以省略
    public abstract void absMethod();

    void absMethod2();

    // 默认方法可以省略public
    public default void defaultMethod() {
        System.out.println("default method");
    }

    // 静态方法可以省略public
    public static void staticMethod() {
        System.out.println("static method");
    }

    // 普通私有方法解决默认方法代码重复问题，mCommon不应该被访问到，应该用私有方法
    // 静态私有方法同理
    public default void md1() {
        System.out.println("default method 1");
        mCommon2();
    }

    public default void md2() {
        System.out.println("default method 2");
        mCommon2();
    }

//    public default void mCommon() {
//        System.out.println("AAA");
//        System.out.println("BBB");
//        System.out.println("BBB");
//    }

    private void mCommon2() {
        System.out.println("AAA");
        System.out.println("BBB");
        System.out.println("BBB");
    }

}
