package com.test.demo;

/*
* 构造方法
* 构造方法和类名相同，没有返回值
* 通过new实例化对象时候，就是调用了构造方法
 */

public class Test003 {
    private String name;
    private int age;

    public Test003() {
        System.out.println("test003 create");
    }

    public Test003(String name, int age) {
        System.out.println("test003 create wit name age");
        this.name = name;
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }
}
