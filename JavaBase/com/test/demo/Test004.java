package com.test.demo;

/*
* static
* 如果一个成员变量使用了static关键字，那么这个变量不再输入对象自己，而是属于所在的类。多个对象共享同一个数据。
* 如果一个成员方法使用了static关键字，那么这个方法成为静态方法，属于类不属于对象。
* 成员方法必须创建对象才能使用。
* 静态方法可以只过通过类名称来调用
*
* 静态代码块 static{ // 静态代码块内容 }
* 静态代码块是第一次使用类时调用，只执行一次
* 静态代码块比构造方法执行更早
* 用来一次性的对静态变量成员进行赋值
*
*
*
* */
public class Test004 {
    private String name;
    private int age;
    public static String room;
    private int id;
    private static int idCounter = 0;

    static {
        System.out.println("静态代码块");

    }

    public Test004() {

    }

    public  Test004(String name, int age) {
        this.name = name;
        this.age = age;
        this.id = ++this.idCounter;
    }

    public void method() {
        System.out.println("成员方法");
        System.out.println(name);
        System.out.println(id);
    }

    public static void staticMethod() {
        System.out.println("静态方法");
//        System.out.println(name);
        System.out.println(room);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
