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
  <title>注册页面</title>
  <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/bootstrap.css">
  <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/register.css">
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
          <label for="inputPassword1" class="col-sm-2 control-label">密码</label>
          <div class="col-sm-6">
            <input type="password" class="form-control" id="inputPassword1" placeholder="密码" name="password1">
          </div>
        </div>

        <div class="form-group">
          <label for="inputPassword2" class="col-sm-2 control-label">重复密码</label>
          <div class="col-sm-6">
            <input type="password" class="form-control" id="inputPassword2" placeholder="重复密码" name="password2">
          </div>
        </div>

        <div class="form-group">
          <label class="col-sm-2 control-label">性别</label>
          <div class="col-sm-6">
            <label class="radio-inline">
              <input type="radio" name="gender" id="inlineRadio1" value="男"> 男
            </label>
            <label class="radio-inline">
              <input type="radio" name="gender" id="inlineRadio2" value="女"> 女
            </label>
          </div>
        </div>

        <div class="form-group">
          <label for="phone" class="col-sm-2 control-label">电话</label>
          <div class="col-sm-6">
            <input type="text" class="form-control" id="phone" placeholder="电话" name="phone">
          </div>
        </div>

        <div class="form-group">
          <label for="address" class="col-sm-2 control-label">地址</label>
          <div class="col-sm-6">
            <input type="text" class="form-control" id="address" placeholder="地址" name="address">
          </div>
        </div>

        <input name="op" value="register" type="hidden"><br/>

        <div class="form-group">
          <div class="col-sm-offset-2 col-sm-6">
            <button type="submit" class="btn btn-info btn-block">注册</button>
          </div>
        </div>
      </form>
    </div>
  </div>

</div>
</body>

</html>
