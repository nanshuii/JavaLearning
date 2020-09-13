package com.ledon.controller;

import com.ledon.domain.ParamsTest;
import com.ledon.domain.ParamsTestUser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 请求参数绑定
 */
@Controller
@RequestMapping("/params")
public class ParamsController {

    @RequestMapping("/test")
    public String testParams(String username) {
        System.out.println("test params");
        System.out.println(username);
        return "success";
    }

    @RequestMapping("/testServlet")
    public String testParamsServlet(HttpServletRequest request, HttpServletResponse response) {
        System.out.println(request);
        System.out.println(response);
        return "success";
    }

    /**
     * 请求参数绑定
     * @param paramsTest
     * @return
     */
    @RequestMapping(value = "/testBean", method = RequestMethod.POST)
    public String testParamsBean(ParamsTest paramsTest) {
        System.out.println(paramsTest);
        return "success";
    }

    /**
     * 自定义类型转换器
     * @param user
     * @return
     */
    @RequestMapping(value = "/testUserBean", method = RequestMethod.POST)
    public String testUserBean(ParamsTestUser user) {
        System.out.println(user);
        return "success";
    }
}
