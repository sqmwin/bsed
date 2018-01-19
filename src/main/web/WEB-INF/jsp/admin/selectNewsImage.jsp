<%--
  Created by IntelliJ IDEA.
  User: songqiming
  Date: 2018/1/11
  Time: 15:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>选择新闻图片</title>
</head>
<body>
<div>
    <table>
        <thead>
        <tr>
            <th><a href="${pageContext.request.contextPath}/admin/admin_news_list">取消</a></th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${images}" var="i">
            <tr>
                <th><img src="${pageContext.request.contextPath}/${i.url}" alt="${i.url}" width="300" height="200"></th>
                <th><a href="${pageContext.request.contextPath}/admin/admin_news_image_select?id=${news_id}&imageUrl=${i.url}">选择</a></th>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>