package com.test.demo;


/*
* 内部类
* 成员内部类
* 局部内部类（包含匿名内部类）
*
* 内部类可以访问内部的变量和方法
* 外部访问内部类需要实例化内部类对象
*
* 使用方式
* 间接使用
* 在外部类的方法中，实例化内部类对象，调用内部类方法
* 直接使用
* 外部类.内部类 名称 = new 外部类().new 内部类()
* Test012.Test0121 test1 = new Test012().new Test0121();
*
* 当内部类成员变量和外部类成员变量名字相同时候
* 内部类方法内部变量 num
* 内部类成员变量 this.num
* 外部类成员变量 外部类的名字.this.num
*
* 局部内部类想要访问所在方法的局部变量，需要final标识（如果不变，可以省略）
*
* 匿名类
* 只需要使用一次，免除接口实现类
* 接口 接口名称 = new 接口() { 里面覆盖重写接口的抽象方法 }
*
* */
public class Test012 {

    public class Test0121 {
        int num;
        public void methodInsert() {
            final int num = 1;
            System.out.println("Test012 insert class");
            // 内部类可以访问内部参数
            // 访问变量
            System.out.println(num);
            System.out.println(this.num);
            System.out.println("name = " + name);
            System.out.println(Test012.this.num);

            class  Test0122 {
                int number = 10;
                public void methodPart() {
                    System.out.println("局部类");
                    System.out.println(num);
                }
            }

            Test0122 test = new Test0122();
            test.methodPart();
        }
    }

    private  String name;

    private int num;

    public void methodOut() {
        System.out.println("Test012 outside class");
    }

    public void methodInsertUsed() {
        new Test0121().methodInsert();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }
}
