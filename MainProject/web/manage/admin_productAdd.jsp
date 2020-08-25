<%--
  Created by IntelliJ IDEA.
  User: ledon
  Date: 2020/8/24
  Time: 10:39 上午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="menu.jsp"%>
<!--/sidebar-->
<div class="main-wrap">

    <div class="crumb-wrap">
        <div class="crumb-list"><i class="icon-font"></i><a href="admin_index.jsp">首页</a><span class="crumb-step">&gt;</span><a class="crumb-name" href="admin_user.jsp">商品管理</a><span class="crumb-step">&gt;</span><span>新增商品</span></div>
    </div>
    <div class="result-wrap">
        <div class="result-content">
            <form action="admin_doProductAdd" method="post" id="myform" name="myform" enctype="multipart/form-data">
                <table class="insert-tab" width="100%">
                    <tbody>
                    <tr>
                        <th><i class="require-red">*</i>产品分类：</th>
                        <td>
                            <select class="common-text required" name="cateId">
                                <c:forEach items="${cate_parent_list}" var="cate_parent">
                                    <option value="" disabled="disabled">1-${cate_parent.CATE_NAME}</option>
                                    <c:forEach items="${cate_child_map.get(cate_parent.CATE_ID)}" var="cate_child">
                                        <option value="${cate_parent.CATE_ID}-${cate_child.CATE_ID}">${cate_parent.CATE_ID}-${cate_child.CATE_ID}</option>
                                    </c:forEach>
                                </c:forEach>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <th><i class="require-red">*</i>商品名称：</th>
                        <td>
                            <input class="common-text required" id="name" name="productName" size="50" value="" type="text">
                        </td>
                    </tr>
                    <tr>
                        <th><i class="require-red">*</i>商品价格：</th>
                        <td>
                            <input class="common-text required" id="price" name="productPrice" size="50" value="" type="text">
                        </td>
                    </tr>
                    <tr>
                        <th><i class="require-red">*</i>商品库存：</th>
                        <td>
                            <input class="common-text required" id="stock" name="productStock" size="50" value="" type="number">
                        </td>
                    </tr>
                    <tr>
                        <th><i class="require-red">*</i>商品图片：</th>
                        <td>
                            <input class="common-text required" id="image" name="productImage" size="50" value="" type="file">
                        </td>
                    </tr>
                    <tr>
                        <th><i class="require-red">*</i>商品描述：</th>
                        <td>
                            <input class="common-text required" id="price" name="productDesc" size="50" value="" type="text">
                        </td>
                    </tr>
                    <tr>
                        <th></th>
                        <td>
                            <input class="btn btn-primary btn6 mr10" value="提交" type="submit">
                            <input class="btn btn6" onClick="history.go(-1)" value="返回" type="button">
                        </td>
                    </tr>
                    </tbody></table>
            </form>
        </div>
    </div>

</div>
<!--/main-->
</div>
</body>
</html>