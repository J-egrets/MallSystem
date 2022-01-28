<%--
  Created by IntelliJ IDEA.
  User: 14489
  Date: 2021/9/17
  Time: 14:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>订单管理</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/bootstrap.css">
</head>
<body>
<button id="showButton" type="button" class="btn btn-info" onclick="start()">显示</button>
<div class="table-responsive">
    <table class="table table-hover">
        <tr>
            <td>订单编号</td>
            <td>下单人</td>
            <td>货品名</td>
            <td>下单件数</td>
            <td>订单状态</td>
            <td>下单时间</td>
            <td>发货方式</td>
            <td>付款方式</td>
            <td>总价</td>
            <td>操作</td>
        </tr>
        <c:forEach var="order" items="${orderList}">
            <tr>
                <td>${order.getId()}</td>
                <td>${order.getUserName()}</td>
                <td>${order.getGoodsName()}</td>
                <td>${order.getCount()}</td>
                <td>
                    <c:if test="${order.getStatus() == 0}">
                        审核中
                    </c:if>
                    <c:if test="${order.getStatus() == 1}">
                        通过
                    </c:if>
                    <c:if test="${order.getStatus() == 2}">
                        未通过
                    </c:if>
                </td>
                <td>${order.getOrderTime()}</td>
                <td>${order.getSendType()}</td>
                <td>${order.getPayType()}</td>
                <td>${order.getTotalPrice()}</td>
                <td>
                    <c:if test="${order.getStatus() == 0}">
                        <button type="button" class="btn btn-success"
                                onclick="changeStatus(${order.getId()},1)">
                            通过
                        </button>
                        <button type="button" class="btn btn-success btn-danger"
                                onclick="changeStatus(${order.getId()},2)">
                            不通过
                        </button>
                    </c:if>
                    <c:if test="${order.getStatus() == 1}">
                        <button type="button" class="btn btn-info"
                                onclick="changeStatus(${order.getId()},0)">
                            审核
                        </button>
                    </c:if>
                    <c:if test="${order.getStatus() == 2}">
                        <button type="button" class="btn btn-info"
                                onclick="changeStatus(${order.getId()},0)">
                            审核
                        </button>
                    </c:if>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>

<nav aria-label="Page navigation">
    <ul class="pagination">
        <li>
            <a href="${pageContext.request.contextPath}/pageChangeAdminServlet?clazz=${clazz}&curPage=${previousPage}"
               aria-label="Previous">
                <span aria-hidden="true">&laquo;</span>
            </a>
        </li>
        <c:forEach var="temp" begin="1" end="${pageCount}">
            <li>
                <a href="${pageContext.request.contextPath}/pageChangeAdminServlet?clazz=${clazz}&curPage=${temp}">${temp}</a>
            </li>
        </c:forEach>
        <li>

            <a href="${pageContext.request.contextPath}/pageChangeAdminServlet?clazz=${clazz}&curPage=${nextPage}"
               aria-label="Next">
                <span aria-hidden="true">&raquo;</span>
            </a>
        </li>
    </ul>
</nav>
</body>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/jquery-3.6.0.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/dealOrder.js"></script>
</html>
