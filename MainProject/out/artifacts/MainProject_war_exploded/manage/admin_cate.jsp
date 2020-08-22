<%--
  Created by IntelliJ IDEA.
  User: ledon
  Date: 2020/8/22
  Time: 3:46 下午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="menu.jsp"%>
<!--/sidebar-->
<div class="main-wrap">

    <div class="crumb-wrap">
        <div class="crumb-list"><i class="icon-font"></i><a href="index.html">首页</a><span class="crumb-step">&gt;</span><span class="crumb-name">用户管理</span></div>
    </div>
    <div class="search-wrap">
        <div class="search-content">
            <form action="admin_doUserSelect" method="get">
                <table class="search-tab">
                    <tr>
                        <th width="70">用户名:</th>
                        <td><input class="common-text" placeholder="用户名" name="keywords" value="${param.keywords}" id="" type="text"></td>
                        <td><input class="btn btn-primary btn2" type="submit"></td>
                    </tr>
                </table>
            </form>
        </div>
    </div>
    <div class="result-wrap">
        <form action="admin_doUserDelete" name="myform" id="myform" method="post">
            <div class="result-title">
                <div class="result-list">
                    <a href="admin_cateAdd"><i class="icon-font"></i>新增分类</a>
                    <a id="batchDel" href="javascript:deleteCates('确认删除这些分类？', 'myform')"><i class="icon-font"></i>批量删除</a>
                </div>
            </div>
            <div class="result-content">
                <table class="result-tab" width="50%">
                    <tr>
                        <th class="tc" width="5%"><input class="allChoose" name="" onclick="selectAll(this)" type="checkbox"></th>
                        <th>分类ID</th>
                        <th>分类名称</th>
                        <th>操作</th>
                    </tr>

                    <c:forEach items="${cate_list}" var="cate">
                        <c:if test="${cate.CATE_PARENT_ID == 0}">
                            <tr>
                                <td class="tc"><input name="id[]" value="${cate.CATE_ID}" type="checkbox"></td>
                                <td>${cate.CATE_ID}</td>
                                <td>${cate.CATE_NAME}</td>
                                <td><a href="admin_cateUpdate?id=${cate.CATE_ID}">修改</a> <a href="javascript:deleteCate('确认删除这个分类？', ${cate.CATE_ID})">删除</a></td>
                            </tr>
                                <c:forEach items="${cate_list}" var="c_cate">
                                    <c:if test="${cate.CATE_ID == c_cate.CATE_PARENT_ID}">
                                        <tr>
                                            <td class="tc"><input name="id[]" value="${c_cate.CATE_ID}" type="checkbox"></td>
                                            <td>${c_cate.CATE_ID}</td>
                                            <td>${c_cate.CATE_NAME}</td>
                                            <td><a href="admin_cateUpdate?id=${c_cate.CATE_ID}">修改</a> <a href="javascript:deleteCate('确认删除这个分类？', ${c_cate.CATE_ID})">删除</a></td>
                                        </tr>
                                    </c:if>
                                </c:forEach>
                        </c:if>
                    </c:forEach>
                </table>
            </div>
        </form>
    </div>
</div>
<!--/main-->
</div>
<script>
    function deleteCate(msg, id) {
        if (confirm(msg)) {
            location.href = "admin_doCateDelete?id="+id;
        }
    }
    function deleteCates(msg, ids) {

    }
</script>
</body>
</html>