package com.http.servlet.product;

import com.dao.service.CategoryDao;
import com.entity.CATEGORY;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@WebServlet(urlPatterns = "/manage/admin_productAdd")
public class productAdd extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ArrayList<CATEGORY> categoriesParent = CategoryDao.selectAll(0);
        ArrayList<CATEGORY> categoriesChild = CategoryDao.selectAll(-1);
        Map<Integer, ArrayList<CATEGORY>> map = new HashMap<Integer, ArrayList<CATEGORY>>();
        for (int i = 0; i < categoriesChild.size(); i++) {
            CATEGORY category = categoriesChild.get(i);
            Integer parentId = Integer.valueOf(category.getCATE_PARENT_ID());
            if (map.get(parentId) == null) {
                ArrayList<CATEGORY> c = new ArrayList<CATEGORY>();
                c.add(category);
                map.put(parentId, c);
            } else {
                ArrayList<CATEGORY> c = map.get(parentId);
                c.add(category);
                map.put(parentId, c);
            }
        }
        req.setAttribute("cate_parent_list", categoriesParent);
        req.setAttribute("cate_child_map", map);
        req.getRequestDispatcher("admin_productAdd.jsp").forward(req, resp);
    }
}
