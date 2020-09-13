<%--
  Created by IntelliJ IDEA.
  User: ledon
  Date: 2020/9/10
  Time: 3:56 下午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript" src="js/jquery.min.js"></script>
    <script>
        $(function () {
            $("#btn").click(function () {
                $.ajax({
                    url: "user/testAjax",
                    contentType: "application/json;charset=UTF-8",
                    data: '{"username":"嘿嘿嘿","password":"123","age":30}',
                    dataType: "json",
                    type: "post",
                    success: function (data) {
                        alert(data)
                    }
                });
            });
        });
    </script>
</head>
<body>
    <a href="user/testString">testString</a>
    <br><br>
    <a href="user/testVoid">testVoid</a>
    <br><br>
    <a href="user/testForward">testForward</a>
    <br><br>
    <a href="user/testRedirect">testRedirect</a>
    <br><br>
    <a href="user/testModelAndView">testModelAndView</a>
    <br><br>
    <button id="btn">发送ajax请求</button>
    <br><br>
    <form action="user/fileUpload1" method="post" enctype="multipart/form-data">
        选择文件 <input type="file" name="fff"><br>
        <input type="submit" value="上传">
    </form>
    <br><br>
    <form action="user/fileUpload2" method="post" enctype="multipart/form-data">
        选择文件 <input type="file" name="fff"><br>
        <input type="submit" value="上传">
    </form>
    <br><br>
    <form action="user/fileUpload3" method="post" enctype="multipart/form-data">
        选择文件 <input type="file" name="fff"><br>
        <input type="submit" value="上传">
    </form>
</body>
</html>
