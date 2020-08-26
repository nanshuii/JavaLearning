<%--
  Created by IntelliJ IDEA.
  User: ledon
  Date: 2020/8/20
  Time: 7:05 下午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="wrapper clearfix">
    <div class="clearfix" id="top"><h1 class="fl"><a href="index.html"><img src="img/logo.png"/></a></h1>
        <div class="fr clearfix" id="top1"><p class="fl">
            <c:if test="${isLogin != 1}">
                <a href="login.jsp" id="login">登录</a><a href="reg.jsp" id="reg">注册</a>
            </c:if>
            <c:if test="${isLogin == 1}">
                你好:<a href="login.jsp" id="login">${login_user.USER_NAME}</a>
            </c:if>
        </p>
            <form action="#" method="get" class="fl"><input type="text" placeholder="热门搜索：干花花瓶"/><input
                    type="button"/></form>
            <div class="btn fl clearfix"><a href="userInfo.jsp"><img src="img/grzx.png"/></a><a href="#" class="er1"><img
                    src="img/ewm.png"/></a><a href="cartSelect"><img src="img/gwc.png"/></a>
                <p><a href="#"><img src="img/smewm.png"/></a></p></div>
        </div>
    </div>
    <ul class="clearfix" id="bott">
        <li><a href="indexSelect">首页</a></li>
        <c:forEach items="${cate_parent_list}" var="cate_parent">
            <li><a href="productSelect?id=${cate_parent.CATE_ID}&name=${cate_parent.CATE_NAME}">${cate_parent.CATE_NAME}</a>
                <div class="sList2">
                    <div class="clearfix">
                        <c:forEach items="${cate_child_map.get(cate_parent.CATE_ID)}" var="cate_child">
                            <a href="productSelect?id=${cate_child.CATE_ID}&name=${cate_child.CATE_NAME}&parentId=${cate_parent.CATE_ID}&parentName=${cate_parent.CATE_NAME}">${cate_child.CATE_NAME}</a>
                        </c:forEach>
                    </div>
                </div>
            </li>
        </c:forEach>
        <li><a href="#">所有商品</a>
            <div class="sList">
                <div class="wrapper  clearfix"><a href="paint.html">
                    <dl>
                        <dt><img src="img/nav1.jpg"/></dt>
                        <dd>浓情欧式</dd>
                    </dl>
                </a><a href="paint.html">
                    <dl>
                        <dt><img src="img/nav2.jpg"/></dt>
                        <dd>浪漫美式</dd>
                    </dl>
                </a><a href="paint.html">
                    <dl>
                        <dt><img src="img/nav3.jpg"/></dt>
                        <dd>雅致中式</dd>
                    </dl>
                </a><a href="paint.html">
                    <dl>
                        <dt><img src="img/nav6.jpg"/></dt>
                        <dd>简约现代</dd>
                    </dl>
                </a><a href="paint.html">
                    <dl>
                        <dt><img src="img/nav7.jpg"/></dt>
                        <dd>创意装饰</dd>
                    </dl>
                </a></div>
            </div>
        </li>
    </ul>
</div>
