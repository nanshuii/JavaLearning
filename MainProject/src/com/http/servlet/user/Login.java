package com.http.servlet.user;

import com.dao.service.UserDao;
import com.entity.USER;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet(urlPatterns = "/login")
public class Login extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 设置字符集
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        // 获取参数
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        // 进行登录
        ArrayList<USER> users = UserDao.selectByUsernameAndPassword(username, password);
        // 登录判定
        if (!users.isEmpty()) {
            HttpSession session = req.getSession();
            USER user = users.get(0);
            session.setAttribute("login_user", user);
            session.setAttribute("isLogin", 1);
            resp.sendRedirect("index.jsp");
        } else {
            PrintWriter printWriter = resp.getWriter();
            printWriter.write("<script>");
            printWriter.write("alert('用户登录失败');");
            printWriter.write("");
            printWriter.write("location.href='login.jsp';");
            printWriter.write("</script>");
            printWriter.close();
        }
    }
}
