<%--
  Created by IntelliJ IDEA.
  User: ledon
  Date: 2020/8/5
  Time: 10:57 下午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>EL获取域中的数据</title>
</head>
<body>
    <%
        request.setAttribute("name", "aaa");
        session.setAttribute("name", "bbb");
    %>
    ${requestScope.name}
    ${requestScope.ddd}
    ${sessionScope.name}

</body>
</html>
