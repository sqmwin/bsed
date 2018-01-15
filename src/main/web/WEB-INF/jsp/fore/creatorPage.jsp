
<%--
  Created by IntelliJ IDEA.
  User: songqiming
  Date: 2018/1/15
  Time: 14:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>${creator.name}</title>
</head>
<body>
<div>
    <a href="${pageContext.request.contextPath}/list_creators?categoryId=9">返回上一页</a>
</div>
<div>
    <table>
        <thead>
        <tr>
            <th>主创姓名</th>
            <th>主创职业</th>
            <th>主创简介</th>
            <th>主创图片</th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <td>${creator.name}</td>
            <td>${creator.jobTitle}</td>
            <td>${creator.description}</td>
            <td><img src="${pageContext.request.contextPath}/${creator.imageUrl}" alt="${creator.imageUrl}" width="150" height="200"></td>
        </tr>
        </tbody>
    </table>
</div>
</body>
</html>
