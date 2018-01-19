
<%--
  Created by IntelliJ IDEA.
  User: songqiming
  Date: 2018/1/15
  Time: 14:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<html>
<head>
    <title>${profession.name}</title>
</head>
<body>
<%@include file="../include/foreNavigator.jsp"%>
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
