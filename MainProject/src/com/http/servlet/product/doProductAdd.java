package com.http.servlet.product;

import com.dao.service.ProductDao;
import com.entity.PRODUCT;
import com.jspsmart.upload.Files;
import com.jspsmart.upload.Request;
import com.jspsmart.upload.SmartUpload;
import com.jspsmart.upload.SmartUploadException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@WebServlet(urlPatterns = "/manage/admin_doProductAdd")
public class doProductAdd extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 设置字符集
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        // 获取filepath
        String filePath = getServletContext().getRealPath("/" ) + "img/product/";
        // /Users/ledon/Documents/programming/JavaLearning/MainProject/out/artifacts/MainProject_war_exploded/img/product/
        String imagePath = null;
        File file = new File(filePath);
        if (!file.exists()) {
            file.mkdir();
        }
        // smartUpload上传文件
        SmartUpload smartUpload = new SmartUpload();
        smartUpload.initialize(this.getServletConfig(), req, resp);
        try {
            smartUpload.upload();
            Files files = smartUpload.getFiles();
            if (files != null && files.getCount() == 1) {
                com.jspsmart.upload.File updateFile = files.getFile(0);
                String fileExt = updateFile.getFileExt();
                String updateFilePath = filePath + getTimeStamp() + "." + fileExt;
                // /Users/ledon/Documents/programming/JavaLearning/MainProject/out/artifacts/MainProject_war_exploded/img/product/20200824222329451.jpeg
                updateFile.saveAs(updateFilePath);
                imagePath = updateFilePath.substring(filePath.length()); // 20200824222329451.jpeg
            }
        } catch (SmartUploadException e) {
            e.printStackTrace();
        }
        Request request = smartUpload.getRequest();
        String cateId = request.getParameter("cateId");
        String productName = request.getParameter("productName");
        String productPrice = request.getParameter("productPrice");
        String productStock = request.getParameter("productStock");
        String productDesc = request.getParameter("productDesc");
        if (imagePath != null) {
            imagePath = "/img/product/" + imagePath;
        }
        String patientId = null;
        String childId = null;
        String[] cateIds = null;
        if (cateId != null) {
            cateIds = cateId.split("-");
            if (cateIds.length == 2) {
                patientId = cateIds[0];
                childId = cateIds[1];
            }
        }
        PRODUCT product = new PRODUCT(
                0,
                productName,
                productDesc,
                Float.parseFloat(productPrice),
                Integer.parseInt(productStock),
                Integer.parseInt(patientId),
                Integer.parseInt(childId),
                imagePath);

        // 加入数据库
        int count = ProductDao.productInsert(product);
        if (count > 0) {
            resp.sendRedirect("admin_productSelect");
        } else {
            PrintWriter printWriter = resp.getWriter();
            printWriter.write("<script>");
            printWriter.write("alert('商品添加失败');");
            printWriter.write("location.href='admin_productAdd.jsp';");
            printWriter.write("</script>");
        }
    }

    public String getTimeStamp() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmssSSS");
        return simpleDateFormat.format(new Date());
    }
}

