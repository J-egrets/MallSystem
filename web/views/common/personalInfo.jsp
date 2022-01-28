<%--
  Created by IntelliJ IDEA.
  User: 14489
  Date: 2021/9/10
  Time: 21:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>个人信息</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css" integrity="sha384-HSMxcRTRxnN+Bdg0JdbxYKrThecOKuH5zCYotlSAcp1+c8xmyTe9GYg1l9a69psu" crossorigin="anonymous">
    <style>
        .col-center{
            position: relative;
            top: 5em;
        }
    </style>
</head>
<body>
    <div class="container-fluid">
        <div class="row">
            <div class="col-md-12 col-center">
                <p class="text-center">用户名：${user.getUserName()} </p>
                <p class="text-center">密码：${user.getPassword()} </p>
                <p class="text-center">性别：${user.getGender()} </p>
                <p class="text-center">电话：${user.getPhone()} </p>
                <p class="text-center">地址：${user.getAddress()} </p>
                <p class="text-center">
                    账户状态：
                    <c:if test="${user.getStatus() == 0}">
                        正常
                    </c:if>
                    <c:if test="${user.getStatus() == 1}">
                        冻结
                    </c:if>
                </p>
                <p class="text-center">
                    身份：
                    <c:if test="${user.getRole() == 0}">
                        管理员
                    </c:if>
                    <c:if test="${user.getRole() == 1}">
                        普通用户
                    </c:if>
                </p>
            </div>
        </div>
    </div>
</body>
</html>
