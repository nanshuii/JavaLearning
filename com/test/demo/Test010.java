package com.test.demo;

public class Test010 implements Test009, Test011{

    @Override
    public void absMethod() {
        System.out.println("method");
    }

    @Override
    public void absMethod2() {
        System.out.println("method2");
    }

    @Override
    public void defaultMethod() {
        System.out.println("override default method");
    }

    @Override
    public void method() {
        System.out.println("method");
    }
}
