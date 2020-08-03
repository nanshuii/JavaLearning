package cn.http;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

@WebServlet(urlPatterns = "/demo1")
public class ServletDemo1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        获取请求方式
        System.out.println(req.getMethod());
//        获取虚拟目录
        System.out.println(req.getContextPath());
//        获取servlet路径
        System.out.println(req.getServletPath());
//        获取get方式的请求参数
        System.out.println(req.getQueryString());
//        获取请求的URI
        System.out.println(req.getRequestURI());
//        获取完整url
        System.out.println(req.getRequestURL());
//        获取协议及版本
        System.out.println(req.getProtocol());
//        获取客户机ip地址
        System.out.println(req.getRemoteAddr());

        // 获取所有请求头名称
        Enumeration<String> headerNames = req.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String name = headerNames.nextElement();
            String value = req.getHeader(name);
            System.out.println(name + "--" + value);
        }
    }
}
