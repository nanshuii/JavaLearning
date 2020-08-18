package com.http.servlet.user;

import com.dao.service.UserDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@WebServlet(urlPatterns = "/manage/admin_doUserDelete")
public class DoUserDelete extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 设置字符集
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        // 获取用户id
        String userID = req.getParameter("id");
        // 删除用户
        int count = UserDao.deleteUserById(userID);
        String msg = "用户删除失败";
        if (count > 0) {
            msg = "用户删除成功";
        }
        PrintWriter printWriter = resp.getWriter();
        printWriter.write("<script>");
        printWriter.write("alert('" + msg + "');");
        printWriter.write("location.href='admin_doUserSelect?cp=" + req.getParameter("cp") + "';");
        printWriter.write("</script>");

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 设置字符集
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        // 获取表单
        String ids[] = req.getParameterValues("id[]");
        // 删除用户
        for (int i = 0; i < ids.length; i++) {
            UserDao.deleteUserById(ids[i]);
        }
//        int count = UserDao.deleteUsersByIds(list);
//        String msg = "用户删除失败";
//        if (count > 0) {
//            msg = "用户删除成功";
//        }
        PrintWriter printWriter = resp.getWriter();
        printWriter.write("<script>");
//        printWriter.write("alert('" + msg + "');");
        printWriter.write("location.href='admin_doUserSelect';");
        printWriter.write("</script>");
    }
}
