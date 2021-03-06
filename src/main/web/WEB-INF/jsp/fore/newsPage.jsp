
<%--
  Created by IntelliJ IDEA.
  User: songqiming
  Date: 2018/1/15
  Time: 14:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>${news.title}</title>
</head>
<body>
<%@include file="../include/foreNavigator.jsp"%>
<div>
    <table>
        <thead>
        <tr>
            <th>新闻标题</th>
            <th>新闻时间</th>
            <th>新闻静态页面url</th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <td>${news.title}</td>
            <td><fmt:formatDate value="${news.createDate}" pattern="yyyy-MM-dd"/></td>
            <td>${news.newsPageUrl}</td>
        </tr>
        </tbody>
    </table>
</div>
</body>
</html>
