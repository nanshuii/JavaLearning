package com.test.demo;


/*
* 这是一个Test005的子类
*
* 如果成员变量重名，创建子类对象时候，有两种访问方式：
* 直接通过子类对象进行访问
* 如果子类对象中有这个变量，那么使用子类对象的这个变量；如果没有那就往上寻找这个变量；
* 间接通过成员方法访问成员变量
* 方法如果是子类定义，使用子类的成员变量；如果子类没定义，向上寻找使用定位改方法的类的成员变量；
*
* 局部变量，子类成员变量，父类成员变量 调用
* 局部变量 直接写
* 子类成员变量 this.
* 父类成员变量 super.
*
* override重写
*
*
*
*
* */
public class Test006  extends Test005{

    public int numZ = 2;

    public int num = 200;

    public void methodZ() {
        System.out.println("test006 method run " + num);
        int num = 201;
        System.out.println(num);
        System.out.println(this.num);
        System.out.println(super.num);
    }

    @Override
    public void method() {
//        super.method();
        System.out.println("test006 method run");
    }
}
