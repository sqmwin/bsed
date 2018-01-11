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
<table>
    <thead>
        <tr>
            <th>图片url</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach items="${images}" var="i">
            <tr>
                <th>${i.url}</th>
                <th><a href="admin_image_delete?id=${i.id}">删除图片</a></th>
            </tr>
        </c:forEach>
    </tbody>
    <form method="post" action="admin_image_add" enctype="multipart/form-data">
        <tfoot>
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
        </tfoot>
    </form>
</table>
</div>
</body>
</html>
