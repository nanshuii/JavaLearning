<%--
  Created by IntelliJ IDEA.
  User: ledon
  Date: 2020/9/11
  Time: 11:27 上午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <a href="anno/testRequestParam?name=哈哈哈哈">RequestParam</a>
<br>
    <form action="anno/testRequestBody" method="post">
        用户姓名 <input type="text" name="name"><br>
        用户密码 <input type="text" name="pwd"><br>
        用户生日 <input type="text" name="date"><br>
        <input type="submit" value="提交">
    </form>
<br>
    <a href="anno/testPathVariable/">testPathVariable</a><br>
    <a href="anno/testPathVariable/1">testPathVariable 1</a><br>
    <a href="anno/testPathVariable/2">testPathVariable 2</a>


</body>
</html>
