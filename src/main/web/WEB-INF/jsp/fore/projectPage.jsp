
<%--
  Created by IntelliJ IDEA.
  User: sqm
  Date: 2018-01-08
  Time: 18:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>${project.title}</title>
</head>
<body>
<%@include file="../include/foreNavigator.jsp"%>
<div>
    <table>
        <thead>
        <tr>
            <th>id</th>
            <th>分类id</th>
            <th>分类类型</th>
            <th>项目标题</th>
            <th>项目描述</th>
            <th>创建时间</th>
            <th>项目名称</th>
            <th>业主名称</th>
            <th>项目地点</th>
            <th>占地面积</th>
            <th>设计时间</th>
            <th>项目页面url</th>
        </tr>
        </thead>
        <tbody>
            <tr>
                <td>${project.id}</td>
                <td>${project.categoryId}</td>
                <td>${project.categoryType}</td>
                <td>${project.title}</td>
                <td>${project.description}</td>
                <td>
                    <fmt:formatDate value="${project.createDate}" pattern="yyyy-MM-dd"/>
                </td>
                <td>${project.name}</td>
                <td>${project.owner}</td>
                <td>${project.location}</td>
                <td>${project.area}㎡</td>
                <td>
                    <fmt:formatDate value="${project.time}" pattern="yyyy"/>
                </td>
                <td>${project.projectPageUrl}</td>
            </tr>
        </tbody>
    </table>
</div>
</body>
</html>
