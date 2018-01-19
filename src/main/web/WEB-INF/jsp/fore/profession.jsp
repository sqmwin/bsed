<%--
  Created by IntelliJ IDEA.
  User: sqm
  Date: 2018-01-06
  Time: 23:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>专家页面</title>
</head>
<body>
<%@include file="../include/foreNavigator.jsp"%>
<div>
    <table>
        <thead>
        <tr>
            <th>专家名称</th>
            <th>专家职业</th>
            <th>专家图片</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${profession}" var="p">
            <tr>
                <td>
                    <a href="${pageContext.request.contextPath}/show_profession?id=${p.id}">${p.name}</a>
                </td>
                <td>${p.jobTitle}</td>
                <td><img src="${pageContext.request.contextPath}/${p.imageUrl}" alt="${p.imageUrl}" height="200" width="150"></td>
            </tr>
        </c:forEach>
        </tbody>
        <tfoot>
        <tr>
            <td colspan="3">专家团队简介</td>
        </tr>
        <tr>
            <td colspan="3">${category.description}</td>
        </tr>
        </tfoot>
    </table>
</div>
</body>
</html>
