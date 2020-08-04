package cn.http;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;

@WebServlet(urlPatterns = "/demo2")
public class ServletDemo2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 获取请求参数，文件名称
        String filename = req.getParameter("filename");
        // 使用字节输入流加载文件进内存
        ServletContext servletContext = this.getServletContext();
        String realPath = servletContext.getRealPath("/img/" + filename);
        System.out.println("realPath = " + realPath);
        FileInputStream fileInputStream = new FileInputStream(realPath);
        // 设置response响应头
        String mimeType = servletContext.getMimeType(filename);
        resp.setHeader("content-type", mimeType);
        resp.setHeader("content-disposition", "attachment;filename=" + filename);
        // 将输入流数据写出到输出流中
        ServletOutputStream outputStream = resp.getOutputStream();
        byte[] buff = new byte[1024 * 8];
        int len = 0;
        while ((len = fileInputStream.read(buff)) != -1) {
            outputStream.write(buff, 0, len);
        }
        // 释放输入流资源
        fileInputStream.close();
    }
}
