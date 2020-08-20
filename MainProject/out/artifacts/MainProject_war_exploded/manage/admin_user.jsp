<%--
  Created by IntelliJ IDEA.
  User: ledon
  Date: 2020/8/16
  Time: 10:46 下午
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
                        <a href="admin_userAdd.jsp"><i class="icon-font"></i>新增用户</a>
                        <a id="batchDel" href="javascript:deleteUsers('确认删除这些用户？', 'myform')"><i class="icon-font"></i>批量删除</a>
                    </div>
                </div>
                <div class="result-content">
                    <table class="result-tab" width="100%">
                        <tr>
                            <th class="tc" width="5%"><input class="allChoose" name="" onclick="selectAll(this)" type="checkbox"></th>
                            <th>ID</th>
                            <th>姓名</th>
                            <th>性别</th>
                            <th>生日</th>
                            <th>邮箱</th>
                            <th>手机</th>
                            <th>操作</th>
                        </tr>

                        <c:forEach items="${users}" var="user">
                            <tr>
                                <td class="tc"><input name="id[]" value="${user.USER_ID}" type="checkbox"></td>
                                <td>${user.USER_ID}</td>
                                <td>${user.USER_NAME}</td>
                                <td>${user.USER_SEX ==  'T' ? '男' : '女'}</td>
                                <td>${user.USER_BIRTHDAY}</td>
                                <td>${user.USER_EMAIL}</td>
                                <td>${user.USER_MOBILE}</td>
                                <td>
                                    <a class="link-update" href="admin_doUserUpdate?id=${user.USER_ID}&cp=${currentPage}${keywords}">修改</a>
                                    <c:if test="${user.USER_STATUS == 1}">
                                        <a class="link-del" href="javascript:deleteUser('确定删除该用户[${user.USER_NAME}]？', 'admin_doUserDelete?id=${user.USER_ID}&cp=${currentPage}')">删除</a>
                                    </c:if>
                                </td>
                            </tr>
                        </c:forEach>

                        <script>
                            // 判断删除
                            function deleteUser(msg, url) {
                                if (confirm(msg)) {
                                    location.href = url;
                                }
                            }
                            // 批量删除
                            function deleteUsers(msg, formName) {
                                if (confirm(msg)) {
                                    let form = document.getElementById(formName);
                                    form.submit();
                                }
                            }
                            // 全选非全选
                            function selectAll(o) {
                                let arr = document.getElementsByName("id[]");
                                for (let i = 0; i < arr.length; i++) {
                                    arr[i].checked = o.checked;
                                }
                            }
                        </script>
                    </table>
                    <div class="list-page">
                        共${totalNum}条记录，当前${currentPage}/${totalPage}页
                        <a href="/MainProject_war_exploded/manage/admin_doUserSelect?cp=1${keywords}">首页</a>
                        <a href="/MainProject_war_exploded/manage/admin_doUserSelect?cp=${currentPage-1 < 1 ? 1 : currentPage-1}${keywords}">上一页</a>
                        <a href="/MainProject_war_exploded/manage/admin_doUserSelect?cp=${currentPage+1 > totalPage ? totalPage : currentPage+1}${keywords}">下一页</a>
                        <a href="/MainProject_war_exploded/manage/admin_doUserSelect?cp=${totalPage}${keywords}">尾页</a>
                    </div>
                </div>
            </form>
        </div>
    </div>
    <!--/main-->
</div>
</body>
</html>
