package com.http.servlet.user;

import com.dao.service.UserDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/usernameCheck")
public class UsernameCheck extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 设置字符集
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        // 获取参数
        String username = req.getParameter("name");
        // 查找是否有重复用户名
        int count = UserDao.selectByUsername(username);
        // 输出结果
        PrintWriter printWriter = resp.getWriter();
        if (count > 0) {
            printWriter.write("false");
        } else {
            printWriter.write("true");
        }
        printWriter.close();
    }
}
