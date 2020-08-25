package com.http.servlet.home;

import com.dao.service.CategoryDao;
import com.dao.service.ProductDao;
import com.entity.CATEGORY;
import com.entity.PRODUCT;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@WebServlet(urlPatterns = "/productSelect")
public class productSelect extends HttpServlet {
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

        String parentId = req.getParameter("parentId");
        String parentName = req.getParameter("parentName");
        String id = req.getParameter("id");
        String name = req.getParameter("name");
        System.out.println(id + "--" + name);
        System.out.println(parentId + "--" + parentName);
        req.setAttribute("id", id);
        req.setAttribute("name", name);
        req.setAttribute("parentId", parentId);
        req.setAttribute("parentName", parentName);

        // 获取商品列表
        int parentIdInt = -1;
        int childIdInt = -1;
        if (parentId != null) {
            // 说明有子分类和父分类
            parentIdInt = Integer.parseInt(parentId);
            childIdInt = Integer.parseInt(id);
        } else {
            // 说明只有父分类
            parentIdInt = Integer.parseInt(id);
        }
        ArrayList<PRODUCT> products = ProductDao.selectByCateId(parentIdInt, childIdInt);
        req.setAttribute("product_list", products);

        req.getRequestDispatcher("productList.jsp").forward(req, resp);
    }
}
