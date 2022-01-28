<%--
  Created by IntelliJ IDEA.
  User: 14489
  Date: 2021/9/10
  Time: 11:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">

<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>登录</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/bootstrap.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/login.css">
</head>

<body>
<div class="container-fluid">
    <div class="row">
        <div class="col-md-8">

        </div>
        <div class="col-md-4">
            <form class="form-horizontal col-center-block" action="${pageContext.request.contextPath}/UserServlet">
                <div>
                    <img src="${pageContext.request.contextPath}/static/img/logo.png" class="img-location" alt="logo">
                </div>
                <div class="form-group">
                    <label for="inputUserName" class="col-sm-2 control-label">用户名</label>
                    <div class="col-sm-6">
                        <input type="text" class="form-control" id="inputUserName" placeholder="用户名" name="userName">
                    </div>
                </div>

                <div class="form-group">
                    <label for="inputPassword" class="col-sm-2 control-label">密码</label>
                    <div class="col-sm-6">
                        <input type="password" class="form-control" id="inputPassword" placeholder="密码" name="password">
                    </div>
                </div>

                <input name="op" value="login" type="hidden"><br/>

                <div class="form-group">
                    <div class="col-sm-offset-2 col-sm-6">
                        <button type="submit" class="btn btn-info btn-block">登录</button>
                    </div>
                </div>
                <div class="col-sm-offset-5">
                        <span>
                            <a href="${pageContext.request.contextPath}/views/register.jsp">免费注册</a>
                            |&nbsp;忘记密码?
                        </span>
                </div>
            </form>
        </div>
    </div>

</div>
</body>

</html>
