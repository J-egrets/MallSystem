<%--
  Created by IntelliJ IDEA.
  User: 14489
  Date: 2021/9/16
  Time: 17:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>分页查询</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/bootstrap.css">
</head>

<body>
<button id="showButton" type="button" class="btn btn-info" onclick="start()">显示</button>
<div class="table-responsive">
    <table class="table table-hover">
        <tr>
            <td>用户名</td>
            <td>密码</td>
            <td>性别</td>
            <td>电话</td>
            <td>地址</td>
            <td>状态</td>
            <td>操作</td>
        </tr>
        <c:forEach var="u" items="${userList}" varStatus="st">
            <tr>
                <td id="userName${st.index}">${u.getUserName()}</td>
                <td>${u.getPassword()}</td>
                <td>${u.getGender()}</td>
                <td>${u.getPhone()}</td>
                <td>${u.getAddress()}</td>
                <td>
                    <c:if test="${u.getStatus() == 0}">
                        正常
                    </c:if>
                    <c:if test="${u.getStatus() == 1}">
                        冻结
                    </c:if>
                </td>
                <td>
                    <c:if test="${u.getStatus() == 0}">
                        <button type="button" class="btn btn-primary btn-sm" onclick="ice(${st.index},1)">冻结</button>
                    </c:if>
                    <c:if test="${u.getStatus() == 1}">
                        <button type="button" class="btn btn-success btn-sm" onclick="ice(${st.index},0)">解冻</button>
                    </c:if>
                    <button type="button" class="btn btn-danger btn-sm" onclick="deleteUser(${st.index})">删除</button>
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
<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/pageChangeUser.js"></script>
</html>

