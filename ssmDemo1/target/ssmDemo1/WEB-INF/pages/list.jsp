<%--
  Created by IntelliJ IDEA.
  User: ledon
  Date: 2020/9/14
  Time: 11:44 上午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>List</title>
</head>
<body>
    <p>list</p>
    <c:forEach items="${list}" var="account">
        <p>account</p>
        <p>${account.name}</p>
        <p>${account.money}</p>
        <br>
    </c:forEach>
</body>
</html>
