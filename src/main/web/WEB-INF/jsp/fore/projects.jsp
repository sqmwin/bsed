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
    <a href="${pageContext.request.contextPath}/forehome">返回主页</a>
</div>
<div>
    <table>
        <thead>
        <tr>
            <th>id</th>
            <th>分类id</th>
            <th>分类类型</th>
            <th>项目标题</th>
            <th>项目图片</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${projects}" var="p">
            <tr>
                <td>${p.id}</td>
                <td>${p.categoryId}</td>
                <td>${p.categoryType}</td>
                <td>
                    <a href="${pageContext.request.contextPath}/show_project?id=${p.id}">${p.title}</a>
                </td>
                <%--<td>${p.imageUrl}</td>--%>
                <td><img src="${pageContext.request.contextPath}/${p.imageUrl}" alt="${p.imageUrl}" height="200" width="300"></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>
