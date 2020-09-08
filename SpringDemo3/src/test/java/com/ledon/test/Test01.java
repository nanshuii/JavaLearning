package com.ledon.test;

import com.ledon.config.SpringConfiguration;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.swing.*;

public class Test01 {

    @Test
    public void test01(){
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfiguration.class);
    }
}
