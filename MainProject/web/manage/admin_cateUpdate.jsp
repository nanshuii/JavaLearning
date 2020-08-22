<%--
  Created by IntelliJ IDEA.
  User: ledon
  Date: 2020/8/22
  Time: 8:00 下午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="menu.jsp"%>
<!--/sidebar-->
<div class="main-wrap">

    <div class="crumb-wrap">
        <div class="crumb-list"><i class="icon-font"></i><a href="admin_index.jsp">首页</a><span class="crumb-step">&gt;</span><a class="crumb-name" href="admin_user.jsp">分类管理</a><span class="crumb-step">&gt;</span><span>新增分类</span></div>
    </div>
    <div class="result-wrap">
        <div class="result-content">
            <form action="admin_doCateUpdate" method="post" id="myform" name="myform">
                <input type="hidden" name="id" value="${current_cate.CATE_ID}">
                <table class="insert-tab" width="100%">
                    <tbody>
                    <tr>
                        <th><i class="require-red">*</i>父级分类：</th>
                        <td>
                            <select class="common-text required" name="parentId">
                                <option value="0">root</option>
                                <c:forEach items="${cate_list}" var="cate">
                                    <c:if test="${cate.CATE_PARENT_ID == 0}">
                                        <c:if test="${current_cate.CATE_PARENT_ID == cate.CATE_ID}">
                                            <option value="${cate.CATE_ID}"} selected="selected">${cate.CATE_NAME}</option>
                                        </c:if>
                                        <c:if test="${current_cate.CATE_PARENT_ID != cate.CATE_ID}">
                                            <option value="${cate.CATE_ID}"}>${cate.CATE_NAME}</option>
                                        </c:if>
                                    </c:if>
                                </c:forEach>
                            </select>
                        </td>

                    </tr>
                    <tr>
                        <th><i class="require-red">*</i>分类名称：</th>
                        <td>
                            <input class="common-text required" id="name" name="name" size="50" value="${current_cate.CATE_NAME}" type="text">
                        </td>
                    </tr>
                    <tr>
                        <th></th>
                        <td>
                            <input class="btn btn-primary btn6 mr10" value="修改" type="submit">
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


