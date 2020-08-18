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

@WebServlet(urlPatterns = "/manage/admin_doUserUpdateHandle")
public class DoUserUpdateHandle extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 设置字符集
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        // 获取参数
        String username = req.getParameter("username");
        String status = req.getParameter("userStatus");
        String name = req.getParameter("name");
        String pwd = req.getParameter("password");
        String sex = req.getParameter("sex");
        String year = req.getParameter("birthday");
        String email = req.getParameter("email");
        String mobile = req.getParameter("mobile");
        String address = req.getParameter("address");
        int status_int = 1;
        if (status != null) {
            status_int = Integer.parseInt(status);
        }
        // 用户实体类
        USER user = new USER(username, name, pwd, sex, year, email, null, mobile, address, status_int);
        // 更新数据库
        int count = UserDao.updateUser(user);
        if (count > 0) {
            // 更新成功
            resp.sendRedirect("admin_doUserSelect?cp=" + req.getParameter("currentPage"));
        } else {
            // 更新失败
            PrintWriter printWriter = resp.getWriter();
            printWriter.write("<script>");
            printWriter.write("alert('用户更新失败');");
            printWriter.write("location.href='admin_doUserUpdate?id="+username+"'");
            printWriter.write("</script>");
        }



    }
}
