<%--
  Created by IntelliJ IDEA.
  User: 14489
  Date: 2021/9/10
  Time: 19:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">

<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>主页</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css" integrity="sha384-HSMxcRTRxnN+Bdg0JdbxYKrThecOKuH5zCYotlSAcp1+c8xmyTe9GYg1l9a69psu" crossorigin="anonymous">
</head>

<body>
<div class="navbar navbar-default">
    <div class="container-fluid">
        <div class="row">
            <div class="col-lg-12">

                <div class="navbar-header">
                    <button class="navbar-toggle" data-target="#mobile_menu" data-toggle="collapse"><span
                            class="icon-bar"></span><span class="icon-bar"></span><span
                            class="icon-bar"></span></button>
                    <a href="${pageContext.request.contextPath}/views/mainPage.jsp" class="navbar-brand">${user.getUserName()}</a>
                </div>

                <div class="navbar-collapse collapse" id="mobile_menu">
                    <ul class="nav navbar-nav">
                        <li class="active"><a href="#" onclick="change('pageChangeGoods','?clazz=Goods')">主页</a></li>
                        <li><a href="#" onclick="change('pageChangeOrder','?clazz=orderUser')">我的订单</a></li>
                        <li><a href="#" onclick="change('pageChangeCar','?clazz=car')">购物车</a></li>
                        <li><a href="#" class="dropdown-toggle" data-toggle="dropdown">商品分类 <span
                                class="caret"></span></a>
                            <ul class="dropdown-menu">
                                <li><a href="#" onclick="change('pageChangeGoods','?clazz=goodCategory&tableDataClazz=1')">电器</a></li>
                                <li><a href="#" onclick="change('pageChangeGoods','?clazz=goodCategory&tableDataClazz=2')">家具</a></li>
                                <li><a href="#" onclick="change('pageChangeGoods','?clazz=goodCategory&tableDataClazz=3')">书籍</a></li>
                            </ul>
                        </li>
                    </ul>
                    <ul class="nav navbar-nav">
                        <li>
                            <form action="" class="navbar-form">
                                <div class="form-group">
                                    <div class="input-group">
                                        <input type="search" name="search" id="search" placeholder="查询商品" class="form-control">
                                        <span class="input-group-addon" onclick="search()"><span
                                                class="glyphicon glyphicon-search"></span></span>
                                    </div>
                                </div>
                            </form>
                        </li>
                    </ul>

                    <ul class="nav navbar-nav navbar-right">
                        <li>
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                                <span class="glyphicon glyphicon-user"></span> 个人中心 <span
                                    class="caret"></span>
                            </a>
                            <ul class="dropdown-menu">
                                <li><a href="#" onclick="change1('personalInfo')">个人信息查看</a></li>
                                <li><a href="#" onclick="change1('changePassword')">个人密码修改</a></li>
                            </ul>
                        </li>
                        <li><a href="#" class="dropdown-toggle" data-toggle="dropdown"><span
                                class="glyphicon glyphicon-log-in"></span> 登录 / 注册 <span
                                class="caret"></span></a>
                            <ul class="dropdown-menu">
                                <li><a href="${pageContext.request.contextPath}/views/login.jsp">登录</a></li>
                                <li><a href="${pageContext.request.contextPath}/views/register.jsp">注册</a></li>
                            </ul>
                        </li>
                    </ul>
                </div>
            </div>
        </div>
    </div>
</div>

<iframe id="iframe" name="iframe" src="${pageContext.request.contextPath}/views/common/welcome.jsp" scrolling="no" frameborder="0" width="100%" height="80%"></iframe>

</body>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/jquery-3.6.0.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js" integrity="sha384-aJ21OjlMXNL5UyIl/XNwTMqvzeRMZH2w8c5cRVpzpU8Y5bApTppSuUkhZXN0VxHd" crossorigin="anonymous"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/pageJump.js"></script>
</html>
