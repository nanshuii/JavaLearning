package com.test.demo;

public interface Test011 {

    void method();

    void absMethod();

    default void defaultMethod() {
        System.out.println("test011 default method");
    }
}
