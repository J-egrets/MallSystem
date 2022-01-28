<%--
  Created by IntelliJ IDEA.
  User: 14489
  Date: 2021/9/10
  Time: 23:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>个人信息修改</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/bootstrap.css">
</head>
<body>
<div class="container-fluid">
    <div class="row">
        <div class="col-md-3">

        </div>
        <div class="col-md-7">
            <form class="form-horizontal col-center-block" action="${pageContext.request.contextPath}/UserServlet">

                <div class="form-group">
                    <label for="inputPassword" class="col-sm-2 control-label">旧密码</label>
                    <div class="col-sm-6">
                        <input type="password" class="form-control" id="inputPassword" placeholder="旧密码" name="passwordOld">
                    </div>
                </div>

                <div class="form-group">
                    <label for="inputPassword1" class="col-sm-2 control-label">新密码</label>
                    <div class="col-sm-6">
                        <input type="password" class="form-control" id="inputPassword1" placeholder="新密码" name="password1">
                    </div>
                </div>

                <div class="form-group">
                    <label for="inputPassword2" class="col-sm-2 control-label">重复新密码</label>
                    <div class="col-sm-6">
                        <input type="password" class="form-control" id="inputPassword2" placeholder="重复新密码" name="password2">
                    </div>
                </div>

                <input name="op" value="changePassword" type="hidden"><br/>

                <div class="form-group">
                    <div class="col-sm-offset-2 col-sm-6">
                        <button type="submit" class="btn btn-info btn-block">修改</button>
                    </div>
                </div>
            </form>
        </div>
    </div>

</div>

</body>
</html>
