<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: ledon
  Date: 2020/8/6
  Time: 9:39 上午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>JSTL</title>
</head>
<body>
    <c:forEach begin="1" end="10" var="i" step="1" varStatus="s">
        ${i}${s.index}${s.count}
    </c:forEach>

    <%
      List list = new ArrayList();
      list.add("aaa");
      list.add("bbb");
      list.add("ccc");
      request.setAttribute("list", list);
    %>

    <c:forEach items="${list}" var="str" varStatus="s">
        ${s.index} ${s.count} ${str}
    </c:forEach>

</body>
</html>
