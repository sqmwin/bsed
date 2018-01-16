
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
    <title>${profession.name}</title>
</head>
<body>
<div>
    <a href="${pageContext.request.contextPath}/list_profession?categoryId=10">返回上一页</a>
</div>
<div>
    <table>
        <thead>
        <tr>
            <th>专家姓名</th>
            <th>专家职业</th>
            <th>专家简介</th>
            <th>专家图片</th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <td>${profession.name}</td>
            <td>${profession.jobTitle}</td>
            <td>${profession.description}</td>
            <td><img src="${pageContext.request.contextPath}/${profession.imageUrl}" alt="${profession.imageUrl}" width="150" height="200"></td>
        </tr>
        </tbody>
    </table>
</div>
</body>
</html>
