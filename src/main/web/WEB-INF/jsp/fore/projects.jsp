<%--
  Created by IntelliJ IDEA.
  User: sqm
  Date: 2018-01-06
  Time: 14:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>项目列表</title>
</head>
<body>
<div>
    <table>
        <thead>
        <tr>
            <th>id</th>
            <th>分类id</th>
            <th>分类类型</th>
            <th>项目标题</th>
            <th>项目图片url</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${projects}" var="p">
            <tr>
                <td>${p.id}</td>
                <td>${p.categoryId}</td>
                <td>${p.categoryType}</td>
                <td>
                    <a href="show_project?id=${p.id}">${p.title}</a>
                </td>
                <td>${p.imageUrl}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>
