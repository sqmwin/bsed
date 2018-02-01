<%--
  Created by IntelliJ IDEA.
  User: songqiming
  Date: 2018/1/17
  Time: 17:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<html>
<head>
    <title>登录后台管理</title>
</head>
<body>
<%@include file="../include/foreNavigator.jsp"%>
<div>
    ${message}
</div>
<form method="post" action="${pageContext.request.contextPath}/admin/admin_user_login/">
    <table>
        <tr>
            <td>用户名：</td>
            <td><input type="text" id="username" name="username"></td>
        </tr>
        <tr>
            <td>密码：</td>
            <td><input type="password" id="password" name="password"></td>
        </tr>
        <tr>
            <td><input type="submit" value="登陆"></td>
        </tr>
    </table>
</form>
</body>
</html>
