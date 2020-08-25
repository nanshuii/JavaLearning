<%--
  Created by IntelliJ IDEA.
  User: ledon
  Date: 2020/8/23
  Time: 10:13 上午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="menu.jsp"%>
<!--/sidebar-->
<div class="main-wrap">

    <div class="crumb-wrap">
        <div class="crumb-list"><i class="icon-font"></i><a href="admin_index.jsp">首页</a><span class="crumb-step">&gt;</span><span class="crumb-name">商品管理</span></div>
    </div>
    <div class="result-wrap">
        <form action="admin_doUserDelete" name="myform" id="myform" method="post">
            <div class="result-title">
                <div class="result-list">
                    <a href="admin_productAdd"><i class="icon-font"></i>新增商品</a>
                </div>
            </div>
            <div class="result-content">
                <table class="result-tab" width="80%">
                    <tr>
                        <th class="tc" width="5%"><input class="allChoose" name="" onclick="selectAll(this)" type="checkbox"></th>
                        <th>商品ID</th>
                        <th>商品名称</th>
                        <th>商品描述</th>
                        <th>商品价格</th>
                        <th>商品库存</th>
                        <th>商品分类</th>
                        <th>商品图片</th>
                        <th>操作</th>
                    </tr>
                    <c:forEach items="${product_list}" var="product">
                        <tr>
                            <td class="tc"><input name="id[]" value="${product.PRODUCT_ID}" type="checkbox"></td>
                            <td>${product.PRODUCT_ID}</td>
                            <td>${product.PRODUCT_NAME}</td>
                            <td>${product.PRODUCT_DESC}</td>
                            <td>¥${product.PRODUCT_PRICE}</td>
                            <td>${product.PRODUCT_STOCK}</td>
                            <td>${product.PRODUCT_FID}-${product.PRODUCT_CID}</td>
                            <td><img src="/MainProject_war_exploded${product.PRODUCT_FILENAME}" width="100px" height="100px"></td>
                            <td><a href="">修改</a> <a href="">删除</a></td>
                        </tr>
                    </c:forEach>
                </table>
            </div>
        </form>
    </div>
</div>
<!--/main-->
</body>
</html>
