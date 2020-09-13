package com.ledon.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 控制器类
 */
@Controller
@RequestMapping("test")
public class HelloController {

    @RequestMapping(path = "/hello")
    public String sayHello() {
        System.out.println("hello springmvc");
        // return 一个字符串 相当于跳转到success.jsp
        return "success";
    }

    @RequestMapping(path = "/hello", method = RequestMethod.POST)
    public String sayHelloPost() {
        System.out.println("hello springmvc");
        // return 一个字符串 相当于跳转到success.jsp
        return "success";
    }

    @RequestMapping(path = "/hello", method = {RequestMethod.POST, RequestMethod.GET})
    public String sayHelloPostMethods() {
        System.out.println("hello springmvc");
        // return 一个字符串 相当于跳转到success.jsp
        return "success";
    }

    @RequestMapping(path = "/helloUsername", params = {"username"})
    public String sayHelloParams() {
        System.out.println("hello springmvc");
        // return 一个字符串 相当于跳转到success.jsp
        return "success";
    }

    @RequestMapping(path = "/helloUsernamesex", params = {"username=pig", "sex!1"})
    public String sayHelloParamsc() {
        System.out.println("hello springmvc");
        // return 一个字符串 相当于跳转到success.jsp
        return "success";
    }
}
