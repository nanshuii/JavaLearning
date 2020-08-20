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

@WebServlet(urlPatterns = "/manage/admin_login")
public class AdminLogin extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 设置字符集
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        // 获取参数
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        // 获取用户，进行判断
        ArrayList<USER> users = UserDao.selectAdminByUsernameAndPassword(username, password);
        if (!users.isEmpty()) {
            USER user = users.get(0);
            HttpSession session = req.getSession();
            session.setAttribute("login_user", user);
            session.setAttribute("isLogin", 1);
            session.setAttribute("isAdminLogin", 1);
            resp.sendRedirect("admin_index.jsp");
        } else {
            PrintWriter printWriter = resp.getWriter();
            printWriter.write("<script>");
            printWriter.write("alert('用户登录失败');");
            printWriter.write("location.href='admin_login.jsp';");
            printWriter.write("</script>");
            printWriter.close();
        }
    }
}
