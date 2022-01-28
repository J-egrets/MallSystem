<%--
  Created by IntelliJ IDEA.
  User: 14489
  Date: 2021/9/11
  Time: 0:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>分页查询</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/bootstrap.css">
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/js/jquery-3.6.0.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/js/pageChangeGoods.js"></script>
</head>

<body>
<button id="showButton" type="button" class="btn btn-info" onclick="start()">显示</button>
<div class="table-responsive">
    <table class="table table-hover">
        <tr class="text-center">
            <td>货品id</td>
            <td>货品名称</td>
            <td>货品类别</td>
            <td>货品描述</td>
            <td>价格</td>
            <td>货品图片</td>
            <td>剩余量</td>
            <td>购买量</td>
            <td>操作</td>
        </tr>
        <c:forEach var="goods" items="${goodsList}" varStatus="st">
            <tr class="text-center">
                <td id="goodsId${st.index}">${goods.getId()}</td>
                <td>${goods.getName()}</td>
                <td>${goods.getCategoryId()}</td>
                <td>${goods.getDescription()}</td>
                <td>${goods.getPrice()}</td>
                <td>
                    <img src="${pageContext.request.contextPath}/ImageServlet?filename=${goods.getImg()}" style="width: 8em;height: 7em;">
                </td>
                <td>${goods.getCount()}</td>
                <td>
                    <div class="input-group">
                        <span class="input-group-btn">
                            <button class="btn btn-default" type="button" onclick="changeNum(-1,${st.index})">-</button>
                        </span>
                        <input id="countNum${st.index}" type="text" class="form-control" placeholder="0">
                        <span class="input-group-btn">
                            <button class="btn btn-default" type="button" onclick="changeNum(1,${st.index})">+</button>
                        </span>
                    </div>
                </td>
                <td>
                    <button type="button" class="btn btn-success btn-sm" onclick="addCar(${st.index})">加入购物车</button>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>

<nav aria-label="Page navigation">
    <ul class="pagination">
        <li>
            <a href="${pageContext.request.contextPath}/PageChangeServlet?clazz=${clazz}&curPage=${previousPage}&tableDataClazz=${tableDataClazz}&key=${key}"
               aria-label="Previous">
                <span aria-hidden="true">&laquo;</span>
            </a>
        </li>
        <c:forEach var="temp" begin="1" end="${pageCount}">
            <li>
                <a href="${pageContext.request.contextPath}/PageChangeServlet?clazz=${clazz}&curPage=${temp}&tableDataClazz=${tableDataClazz}&key=${key}">${temp}</a>
            </li>
        </c:forEach>
        <li>

            <a href="${pageContext.request.contextPath}/PageChangeServlet?clazz=${clazz}&curPage=${nextPage}&tableDataClazz=${tableDataClazz}&key=${key}"
               aria-label="Next">
                <span aria-hidden="true">&raquo;</span>
            </a>
        </li>
    </ul>
</nav>

</body>
</html>
