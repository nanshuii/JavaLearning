package com.test.demo;

/*
局部变量和成员变量之间的区别
局部变量位于栈内存
全局变量位于堆内存
*/
public class test002 {
    String name; // 成员变量，有默认值

    public void function1() {
        int num = 10; // 局部变量，没有默认值，必须赋值
        System.out.println(num);
        System.out.println(name);
    }

    public void function2(int num) {

    }
}
