<%@ page import="cn.domain.User" %>
<%@ page import="java.util.Date" %><%--
  Created by IntelliJ IDEA.
  User: ledon
  Date: 2020/8/5
  Time: 11:05 下午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%
        User user = new User();
        user.setName("name");
        user.setAge(22);
        user.setDate(new Date());

        request.setAttribute("user", user);
    %>
    ${requestScope.user.name}
    ${requestScope.user.age}
    ${requestScope.user.date}


</body>
</html>
