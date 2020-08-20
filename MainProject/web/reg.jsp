<%--
  Created by IntelliJ IDEA.
  User: ledon
  Date: 2020/8/18
  Time: 11:09 下午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>注册</title>
    <link rel="stylesheet" type="text/css" href="css/public.css"/>
    <link rel="stylesheet" type="text/css" href="css/login.css"/>
    <script src="js/Calendar.js"></script>
    <script src="js/jquery-1.12.4.min.js"></script>
    <style>
        .reg p .error{
            display: inline-block;
            border: 1px solid red;
            background-color: #EEEEEE;
            color: red;
            margin-left: 20px;
            height: 25px;
            line-height: 25px;
            padding-left: 5px;
            padding-right: 5px;
        }
    </style>
    <script>
        function FocusItem(obj) {
            if ($(obj).attr("code") == "code") {
                $(obj).next().next("span").html("").removeClass("error");
            } else {
                $(obj).next("span").html("").removeClass("error");
            }
        }
        function BlurItem(obj) {
            let msgBox = $(obj).next("span");
            if ($(obj).attr("name") == "code") {
                msgBox = $(obj).next().next("span");
            }
            switch ($(obj).attr("name")) {
                case "username":
                    if (obj.value == "") {
                        msgBox.html("用户名不能为空");
                        msgBox.addClass("error");
                    } else {
                        let url = "usernameCheck?name=" + encodeURI($(obj).val()) + "&" + new Date();
                        $.get(url, function (data) {
                            if (data == "false") {
                                msgBox.html("用户名已存在");
                                msgBox.addClass("error");
                            } else {
                                msgBox.html("").removeClass("error");
                            }
                        });
                    }
                    break;
                case "name":
                    if (obj.value == "") {
                        msgBox.html("姓名不能为空");
                        msgBox.addClass("error");
                    }
                    break;
                case "password":
                    if (obj.value == "") {
                        msgBox.html("密码不能为空");
                        msgBox.addClass("error");
                    }
                    break;
                case "rePassword":
                    if (obj.value == "") {
                        msgBox.html("密码不能为空");
                        msgBox.addClass("error");
                    } else if($(obj).val() != $("input[name='password']").val()) {
                        msgBox.html("两次密码不一致");
                        msgBox.addClass("error");
                    }
                    break;
                case "code":
                    if (obj.value == "") {
                        msgBox.html("验证码不能为空");
                        msgBox.addClass("error");
                    } else {
                        let url = "codeCheck?code=" + encodeURI($(obj).val()) + "&" + new Date();
                        $.get(url, function (data) {
                            if (data == "false") {
                                msgBox.html("验证码不正确");
                                msgBox.addClass("error");
                            } else {
                                msgBox.html("").removeClass("error");
                            }
                        })
                    }
                    break;
            }
        }
    </script>
</head>
<body><!-------------------reg-------------------------->
<div class="reg">
    <form action="register" method="post"><h1><a href="index.html"><img src="img/temp/logo.png"></a></h1>
        <p><h1 style="padding: 0px;margin: 0px;font-size: 30px;background-color: blue;text-align: center;line-height: 60px;color: #ffffff;">用户注册</h1></p>
        <p><input type="text" name="username" value="" placeholder="请输入用户名" onfocus="FocusItem(this)" onblur="BlurItem(this)"><span></span></p>
        <p><input type="text" name="name" value="" placeholder="请输入姓名" onfocus="FocusItem(this)" onblur="BlurItem(this)"><span></span></p>
        <p><input type="text" name="password" value="" placeholder="请确认密码" onfocus="FocusItem(this)" onblur="BlurItem(this)"><span></span></p>
        <p><input type="text" name="rePassword" value="" placeholder="请确认密码" onfocus="FocusItem(this)" onblur="BlurItem(this)"><span></span></p>
        <p>
            <input style="width: 15px;height: 15px;" type="radio" name="sex" value="T" checked="checked">男
            <input style="width: 15px;height: 15px;" type="radio" name="sex" value="F">女
            <span></span></p>
        <p><input name="birthday" type="text" style="padding-left: 5px;size: 10px;" onclick="SelectDate(this)" readonly="readonly" placeholder="请输入生日"><span></span></p>
        <p><input type="text" name="email" value="" placeholder="请输入邮箱" onfocus="FocusItem(this)" onblur="BlurItem(this)"><span></span></p>
        <p><input type="text" name="mobile" value="" placeholder="请输入手机号" onfocus="FocusItem(this)" onblur="BlurItem(this)"><span></span></p>
        <p><input type="text" name="address" value="" placeholder="请输入地址" onfocus="FocusItem(this)" onblur="BlurItem(this)"><span></span></p>
        <p><input class="code" type="text" name="code" value="" placeholder="验证码" onfocus="FocusItem(this)" onblur="BlurItem(this)"><img
                src="img/temp/code.jpg"><span></span></p>
        <p><input type="submit" name="" value="注册"></p>
        <p class="txtL txt">完成此注册，即表明您同意了我们的<a href="#">
            <使用条款和隐私策略>
        </a></p>
        <p class="txt"><a href="#"><span></span>已有账号登录</a></p>
        <!--<a href="#" class="off"><img src="img/temp/off.png"></a>--></form>
</div>
</body>
</html>
