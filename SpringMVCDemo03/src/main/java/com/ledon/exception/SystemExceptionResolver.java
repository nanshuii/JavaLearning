package com.ledon.exception;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SystemExceptionResolver implements HandlerExceptionResolver {

    /**
     * 处理异常业务逻辑
     */
    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) {
        // SystemException对象
        SystemException exception = null;
        if (e instanceof SystemException) {
            exception = (SystemException)e;
        } else {
            exception = new SystemException("系统正在维护...");
        }
        // modelAndView
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("errorMsg", exception.getMessage());
        modelAndView.setViewName("error");

        return modelAndView;
    }

}
