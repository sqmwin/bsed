<%--
  Created by IntelliJ IDEA.
  User: sqm
  Date: 2018-01-06
  Time: 22:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>主创页面</title>
</head>
<body>
<%@include file="../include/foreNavigator.jsp"%>
<div>
    <table>
        <thead>
        <tr>
            <th>主创名称</th>
            <th>主创职业</th>
            <th>主创图片</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${creators}" var="c">
            <tr>
                <td>
                    <a href="${pageContext.request.contextPath}/show_creator?id=${c.id}">${c.name}</a>
                </td>
                <td>${c.jobTitle}</td>
                <td><img src="${pageContext.request.contextPath}/${c.imageUrl}" alt="${c.imageUrl}" height="200" width="150"></td>
            </tr>
        </c:forEach>
        </tbody>
        <tfoot>
        <tr>
            <td colspan="3">主创团队简介</td>
        </tr>
        <tr>
            <td colspan="3">${category.description}</td>
        </tr>
        </tfoot>
    </table>
</div>
</body>
</html>
