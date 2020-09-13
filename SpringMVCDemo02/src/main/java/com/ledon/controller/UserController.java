package com.ledon.controller;

import com.ledon.domain.User;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/user")
public class UserController {

    @RequestMapping("/testString")
    public String testString(Model model) {
        User user = new User();
        user.setAge(10);
        user.setUsername("嘿嘿嘿");
        user.setPassword("123456");
        // model对象存储
        model.addAttribute("user", user);
        return "success";
    }

    @RequestMapping("/testForward")
    public String testForward() {
        return "forward:/WEB-INF/pages/success.jsp";
    }

    @RequestMapping("/testRedirect")
    public String testRedirect() {
        return "redirect:/404.jsp";
    }

    @RequestMapping("/testVoid")
    public void testVoid(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 请求转发是一次请求，不用编写项目的名称
//        request.getRequestDispatcher("/WEB-INF/pages/success.jsp").forward(request, response);
        // 重定向是两次请求，需要编写项目的名称
//        response.sendRedirect(request.getContextPath() + "/index.jsp");
        // 直接响应
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        response.getWriter().print("hello 直接响应");
        return;
    }

    @RequestMapping("/testModelAndView")
    public ModelAndView testModelAndView() {
        ModelAndView modelAndView = new ModelAndView();
        User user = new User();
        user.setAge(10);
        user.setUsername("嘿嘿嘿");
        user.setPassword("123456");
        // 存入到modelAndView中相当于存入到request中
        modelAndView.addObject("user", user);
        // 跳转页面
        modelAndView.setViewName("success");

        return modelAndView;
    }

    @RequestMapping("/testAjax")
    public @ResponseBody User testAjax(@RequestBody User user) {
        System.out.println(user);
        return user;
    }

    @RequestMapping("/fileUpload1")
    public String fileUpload1(HttpServletRequest request) throws Exception {
        // 绝对路径+目录路径
        String path = request.getSession().getServletContext().getRealPath("/uploads/");
        System.out.println(path);
        File file = new File(path);
        if (!file.exists()) {
            file.mkdirs();
        }
        // 解析request对象，获取上传文件项
        DiskFileItemFactory factory = new DiskFileItemFactory();
        ServletFileUpload upload = new ServletFileUpload(factory);
        List<FileItem> fileItems = upload.parseRequest(request);
        for (FileItem item : fileItems) {
            // 判断item是否是一个上传文件项
            if (item.isFormField()) {
                // 是普通表单
            } else {
                // 是上传文件，保存
                String filename = item.getName();
                String uuid = UUID.randomUUID().toString().replace("-", "");
                filename = uuid + "_" + filename;
                item.write(new File(path, filename));
                // 删除临时文件
                item.delete();
            }
        }
        return "success";
    }

    @RequestMapping("/fileUpload2")
    public String fileUpload2(HttpServletRequest request, MultipartFile fff) throws Exception {
        // 绝对路径+目录路径
        String path = request.getSession().getServletContext().getRealPath("/uploads/");
        System.out.println(path);
        File file = new File(path);
        if (!file.exists()) {
            file.mkdirs();
        }
        // 是上传文件，保存
        String filename = fff.getOriginalFilename();
        String uuid = UUID.randomUUID().toString().replace("-", "");
        filename = uuid + "_" + filename;
        fff.transferTo(new File(path, filename));

        return "success";
    }

    @RequestMapping("/fileUpload3")
    public String fileUpload3(MultipartFile fff) throws Exception {
        // 定义另一个服务器路径
        String path = "http://localhost:9090/FileUploadServer_war_exploded/uploads/";

        // 是上传文件，保存
        String filename = fff.getOriginalFilename();
        String uuid = UUID.randomUUID().toString().replace("-", "");
        filename = uuid + "_" + filename;

        // 创建客户端对象
        Client client = Client.create();
        // 和图片服务器进行连接
        WebResource webResource = client.resource(path + filename);
        // 上传文件
        webResource.put(fff.getBytes());

        return "success";
    }
}
