<%--
  Created by IntelliJ IDEA.
  User: 14489
  Date: 2021/9/16
  Time: 21:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>增加货品</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/bootstrap.css">
</head>
<body>
<div class="container-fluid">
    <div class="col-md-4">

    </div>
    <div class="col-md-3">
        <form class="form-horizontal" method="post" enctype="multipart/form-data" action="${pageContext.request.contextPath}/AdminServlet?par=addGoods">
            <div class="form-group">
                <label for="goodsId" class="col-sm-3 control-label">货品ID</label>
                <div class="col-sm-9">
                    <input type="text" class="form-control" id="goodsId" placeholder="ID" name="goodsId">
                </div>
            </div>
            <div class="form-group">
                <label for="goodsName" class="col-sm-3 control-label">货品名</label>
                <div class="col-sm-9">
                    <input type="text" class="form-control" id="goodsName" placeholder="货品名" name="goodsName">
                </div>
            </div>
            <div class="form-group">
                <label for="category" class="col-sm-3 control-label">货品类别</label>
                <div class="col-sm-9">
                    <select class="form-control" id="category" name="category">
                        <option>电器</option>
                        <option>家具</option>
                        <option>书籍</option>
                    </select>
                </div>
            </div>
            <div class="form-group">
                <label for="description" class="col-sm-3 control-label">货品描述</label>
                <div class="col-sm-9">
                    <input type="text" class="form-control" id="description" placeholder="货品描述" name="description">
                </div>
            </div>
            <div class="form-group">
                <label for="goodsImg" class="col-sm-3 control-label">货品图片</label>
                <div class="col-sm-9">
                    <input type="file" id="goodsImg" name="file">
                </div>

            </div>

            <div class="form-group">
                <label for="price" class="col-sm-3 control-label">货品单价</label>
                <div class="col-sm-9">
                    <input type="text" class="form-control" id="price" placeholder="货品单价" name="price">
                </div>
            </div>
            <div class="form-group">
                <label for="count" class="col-sm-3 control-label">货品储存量</label>
                <div class="col-sm-9">
                    <input type="text" class="form-control" id="count" placeholder="货品储存量" name="count">
                </div>
            </div>

            <div class="form-group">
                <div class="col-sm-offset-3 col-sm-9">
                    <button type="submit" class="btn btn-default">添加</button>
                </div>
            </div>
        </form>
    </div>
</div>

</body>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/jquery-3.6.0.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/addGoods.js"></script>
</html>
