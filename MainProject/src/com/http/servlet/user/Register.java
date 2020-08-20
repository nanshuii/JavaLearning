package com.http.servlet.user;

import com.dao.service.UserDao;
import com.entity.USER;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/register")
public class Register extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 设置字符集
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        // 获取参数
        String username = req.getParameter("username");
        String name = req.getParameter("name");
        String pwd = req.getParameter("password");
        String sex = req.getParameter("sex");
        String year = req.getParameter("birthday");
        String email = req.getParameter("email");
        String mobile = req.getParameter("mobile");
        String address = req.getParameter("address");

        // 用户实体类
        USER user = new USER(username, name, pwd, sex, year, email, null, mobile, address, 1);

        // 加入数据库
        int count = UserDao.insert(user);

        // 成功或失败重定向
        if (count > 0) {
            resp.sendRedirect("login.jsp");
        } else {
            PrintWriter printWriter = resp.getWriter();
            printWriter.write("<script>");
            printWriter.write("alert('用户注册失败');");
            printWriter.write("");
            printWriter.write("location.href='reg.jsp';");
            printWriter.write("</script>");
        }
    }
}
