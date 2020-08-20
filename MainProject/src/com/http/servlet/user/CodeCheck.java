package com.http.servlet.user;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/codeCheck")
public class CodeCheck extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 设置字符集
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        // 获取参数code
        String code = req.getParameter("code");
        System.out.println("code = " + code);
        // 查询验证码，输出
        PrintWriter printWriter = resp.getWriter();
        if (code.equals("1234")) {
            printWriter.write("true");
        } else {
            printWriter.write("false");
        }
        printWriter.close();
    }
}
