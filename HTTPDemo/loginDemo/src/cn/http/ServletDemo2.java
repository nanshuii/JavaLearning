package cn.http;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.Map;
import java.util.Set;

@WebServlet(urlPatterns = "/demo2")
public class ServletDemo2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 设置流字符集
        req.setCharacterEncoding("utf-8");

        String name = req.getParameter("name");
        System.out.println("name = " + name);

        Enumeration<String> parameterNames = req.getParameterNames();
        while (parameterNames.hasMoreElements()) {
            String n = parameterNames.nextElement();
            String[] vs = req.getParameterValues(n);
            System.out.println(n + "  --  " + Arrays.toString(vs));
        }

        Map<String, String[]> parameterMap = req.getParameterMap();
        Set<String> keySet = parameterMap.keySet();
        for (String key: keySet) {
            String[] vs = req.getParameterValues(key);
            System.out.println(key + "  --  " + Arrays.toString(vs));
        }
    }
}
