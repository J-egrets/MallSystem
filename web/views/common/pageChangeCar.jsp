<%--
  Created by IntelliJ IDEA.
  User: 14489
  Date: 2021/9/12
  Time: 17:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>购物车页面</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/bootstrap.css">
</head>
<body>

<button id="showButton" type="button" class="btn btn-info" onclick="start()">显示</button>
<div class="table-responsive">
    <table class="table table-hover">
        <tr class="text-center">
            <td>货品名</td>
            <td>货品图片</td>
            <td>货品数量</td>
            <td>货品单价</td>
            <td>总价</td>
            <td>操作</td>
        </tr>
        <c:forEach var="car" items="${carList}">
            <tr class="text-center">
                <td>${car.getGoodsName()}</td>
                <td>
                    <img src="${pageContext.request.contextPath}/ImageServlet?filename=${car.getGoodsImg()}" style="width: 8em;height: 7em;">
                </td>
                <td>${car.getNumber()}</td>
                <td>${car.getGoodsPrice()}</td>
                <td>${car.getTotalPrice()}</td>
                <td>
                    <button type="button" class="btn btn-danger btn-sm" onclick="deleteCar(${car.getGoodsId()},${car.getId()})">删除</button>
                    <button type="button" class="btn btn-success btn-sm" onclick="createOrder(${car.getGoodsId()},${car.getId()})">下单</button>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>

<nav aria-label="Page navigation">
    <ul class="pagination">
        <li>
            <a href="${pageContext.request.contextPath}/PageChangeServlet?clazz=${clazz}&curPage=${previousPage}"
               aria-label="Previous">
                <span aria-hidden="true">&laquo;</span>
            </a>
        </li>
        <c:forEach var="temp" begin="1" end="${pageCount}">
            <li>
                <a href="${pageContext.request.contextPath}/PageChangeServlet?clazz=${clazz}&curPage=${temp}">${temp}</a>
            </li>
        </c:forEach>
        <li>

            <a href="${pageContext.request.contextPath}/PageChangeServlet?clazz=${clazz}&curPage=${nextPage}"
               aria-label="Next">
                <span aria-hidden="true">&raquo;</span>
            </a>
        </li>
    </ul>
</nav>
</body>

<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/jquery-3.6.0.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/pageChangeCar.js"></script>
</html>
