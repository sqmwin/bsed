<%--
  Created by IntelliJ IDEA.
  User: songqiming
  Date: 2018/1/11
  Time: 14:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>图库管理</title>
</head>
<body>
<div>
    <form action="admin_home">
        <button type="submit">返回上一级</button>
    </form>
</div>
<div>
<table>
    <form method="post" action="admin_image_add" enctype="multipart/form-data">
        <thead>
        <tr>
            <th>新增图片</th>
        </tr>
        <tr>
            <th>
                <input type="file" name="image" id="image">
            </th>
            <th>
                <input type="submit" value="新增本地图片">
            </th>
        </tr>
        <tr>
            <th>图片</th>
        </tr>
        </thead>
    </form>
    <tbody>
        <c:forEach items="${images}" var="i">
            <tr>
                <th><img src="${pageContext.request.contextPath}/${i.url}" alt="${i.url}" width="300" height="200"></th>
                <th><a href="admin_image_delete?id=${i.id}">删除图片</a></th>
            </tr>
        </c:forEach>
    </tbody>

</table>
</div>
</body>
</html>
