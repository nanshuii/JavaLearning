package com.http.servlet.home;

import com.dao.service.ProductDao;
import com.entity.PRODUCT;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(urlPatterns = "/productDetail")
public class productDetail extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        PRODUCT product = ProductDao.productGetById(Integer.parseInt(id));
        req.setAttribute("product", product);

        // 保存成用户最近访问
        HttpSession session = req.getSession();
        ArrayList<Integer> lastIds = (ArrayList<Integer>)session.getAttribute("product_last_ids");
        System.out.println("last ids = " + lastIds);
        if (lastIds == null) {
            lastIds = new ArrayList<Integer>();
        } else {
            // 读取所有最近商品
            ArrayList<PRODUCT> products_list_last = new ArrayList<PRODUCT>();
            for (Integer id_last : lastIds) {
                PRODUCT product_last = ProductDao.productGetById(id_last);
                if (product_last != null) {
                    products_list_last.add(product_last);
                }
            }
            req.setAttribute("product_list_last", products_list_last);
        }
        Integer id_integer = Integer.parseInt(id);
        System.out.println(id_integer);
        if (!lastIds.contains(id_integer)) {
            lastIds.add(id_integer);
            if (lastIds.size() == 6) {
                lastIds.remove(0);
            }
        }
        session.setAttribute("product_last_ids", lastIds);
        System.out.println("last ids = " + lastIds);

        // 查找同类商品，形成推荐列表
        int cid = product.getPRODUCT_CID();
        int fid = product.getPRODUCT_FID();
        ArrayList<PRODUCT> recommendProducts = ProductDao.selectByCateId(fid, cid);
        req.setAttribute("product_list_recommend", recommendProducts);
        System.out.println(recommendProducts);
        req.getRequestDispatcher("proDetail.jsp").forward(req, resp);
    }
}
