package com.test.demo;

/*
* 抽象类
* 使用abstract关键字
*
* 抽象方法
* 使用abstract关键字，抽象方法只能在抽象类中定义
* 抽象方法没有方法体
*
* 不能直接使用抽象类，比如有一个子类来继承抽象类；抽象类中的方法要全部覆盖重写
*
*
*
* */
public abstract class Test007 {

    public Test007() {
        System.out.println("Test007构造方法");
    }
    public abstract void method();
}
