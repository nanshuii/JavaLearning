<%--
  Created by IntelliJ IDEA.
  User: ledon
  Date: 2020/9/10
  Time: 9:54 下午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Params请求参数绑定</title>
</head>
<body>
    <a href="params/test">test</a>
    <a href="params/test?username=pig">username=pig</a>
    <a href="params/testServlet">test</a>
    <br>
<%--    <form action="params/testBean" method="post">--%>
<%--        姓名 <input type="text" name="username"><br>--%>
<%--        密码 <input type="text" name="password"><br>--%>
<%--        金额 <input type="number" name="money"><br>--%>
<%--        用户姓名 <input type="text" name="user.name"><br>--%>
<%--        用户密码 <input type="text" name="user.pwd"><br>--%>
<%--        <input type="submit" value="提交">--%>
<%--    </form>--%>

<%--    <form action="params/testBean" method="post">--%>
<%--        姓名 <input type="text" name="username"><br>--%>
<%--        密码 <input type="text" name="password"><br>--%>
<%--        金额 <input type="number" name="money"><br>--%>
<%--        用户姓名 <input type="text" name="user.name"><br>--%>
<%--        用户密码 <input type="text" name="user.pwd"><br>--%>
<%--        用户姓名 <input type="text" name="list[0].name"><br>--%>
<%--        用户密码 <input type="text" name="list[0].pwd"><br>--%>
<%--        用户姓名 <input type="text" name="list[1].name"><br>--%>
<%--        用户密码 <input type="text" name="list[1].pwd"><br>--%>
<%--        用户姓名 <input type="text" name="map['1'].name"><br>--%>
<%--        用户密码 <input type="text" name="map['1'].pwd"><br>--%>
<%--        用户姓名 <input type="text" name="map['2'].name"><br>--%>
<%--        用户密码 <input type="text" name="map['2'].pwd"><br>--%>
<%--        <input type="submit" value="提交">--%>
<%--    </form>--%>


    <form action="params/testUserBean" method="post">
        用户姓名 <input type="text" name="name"><br>
        用户密码 <input type="text" name="pwd"><br>
        用户生日 <input type="text" name="date"><br>
        <input type="submit" value="提交">
    </form>

</body>
</html>
