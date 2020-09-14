<%--
  Created by IntelliJ IDEA.
  User: ledon
  Date: 2020/9/14
  Time: 11:39 上午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

    <a href="account/findAll">findAll</a>
    <br><br>
    <form action="account/save" method="post">
        name: <input type="text" name="name">
        money: <input type="number" name="money">
        <input type="submit" value="提交">
    </form>

</body>
</html>
