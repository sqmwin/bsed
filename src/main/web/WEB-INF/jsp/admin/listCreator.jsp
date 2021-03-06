<%--
  Created by IntelliJ IDEA.
  User: songqiming
  Date: 2018/1/10
  Time: 下午5:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>主创人员管理页面</title>
</head>
<body>

<%@include file="../include/adminNavigator.jsp"%>
<div>
    <table>
        <thead>
        <tr>
            <th>id</th>
            <th>主创姓名</th>
            <th>主创职业</th>
            <th>主创简介</th>
            <th>主创图片</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${creators}" var="c">
            <tr>
                <td>${c.id}</td>
                <td>${c.name}</td>
                <td>${c.jobTitle}</td>
                <td>${c.description}</td>
                <td>
                    <a href="${pageContext.request.contextPath}/admin/admin_select_creator_image_page?id=${c.id}">
                        <img src="${pageContext.request.contextPath}/${c.imageUrl}" alt="${c.imageUrl}" width="150" height="200">更改图片</a>
                </td>
                <td>
                    <a href="${pageContext.request.contextPath}/admin/admin_edit_creator_page?id=${c.id}">编辑新闻</a>
                </td>
                <td>
                    <a href="${pageContext.request.contextPath}/admin/admin_creator_delete?id=${c.id}">删除新闻</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
        <form method="post" action="${pageContext.request.contextPath}/admin/admin_creator_add">
            <tfoot>
            <tr>
                <td>新增主创</td>
                <td>主创姓名</td>
                <td>主创职业</td>
                <td>主创简介</td>
            </tr>
            <tr>
                <td>主创id自动生成</td>
                <td><input  id="name" name="name" type="text"></td>
                <td><input  id="jobTitle" name="jobTitle" type="text"></td>
                <td><textarea name="description" id="description" cols="50" rows="10"></textarea></td>
                <td colspan="2" align="center">
                    <button type="submit">新增主创</button>
                </td>
            </tr>
            </tfoot>
        </form>
    </table>
</div>

<%--pageHelp分页--%>
<%@include file="../include/pageHelper.jsp"%>

</body>
</html>
