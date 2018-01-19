
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
    <title>${creator.name}</title>
</head>
<body>
<%@include file="../include/foreNavigator.jsp"%>
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
