<%--
  Created by IntelliJ IDEA.
  User: ledon
  Date: 2020/8/5
  Time: 8:19 下午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isErrorPage="true" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>服务器正忙</h1>
    <%
        String message = exception.getMessage();
        out.print(message);
    %>
</body>
</html>
