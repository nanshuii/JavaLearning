package com.ledon.controller;

import com.ledon.exception.SystemException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {

    @RequestMapping("/testException")
    public String testException() throws SystemException {
        try {
            int a = 1 / 0;
        } catch (Exception e) {
            // 控制台打印
            e.printStackTrace();
            // 抛出异常
            throw new SystemException("查询出错。。。。");
        }
        return "success";
    }
}
