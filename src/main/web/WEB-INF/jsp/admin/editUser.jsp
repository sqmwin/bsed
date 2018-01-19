<%--
  Created by IntelliJ IDEA.
  User: songqiming
  Date: 2018/1/17
  Time: 18:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>

<html>
<head>
    <title>修改密码</title>
</head>
<body>
<%@include file="../include/adminNavigator.jsp"%>

<form action="${pageContext.request.contextPath}/admin/admin_user_edit" method="post">
    <table>
        <tr>
            <td>新密码</td>
            <td><input type="password" id="password" name="password"></td>
        </tr>
        <tr>
            <td>确认新密码</td>
            <td><input type="password" id="ensure" name="ensure"></td>
        </tr>
        <tr>
            <td>${passwordMessage}</td>
        </tr>
        <tr>
            <td><input type="submit" value="修改密码"></td>
        </tr>
    </table>
</form>
</body>
</html>
