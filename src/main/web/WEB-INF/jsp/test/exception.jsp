<%--
  Created by IntelliJ IDEA.
  User: songqiming
  Date: 2018/1/18
  Time: 16:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/test/exception_test" method="get">
    <input type="text" id="test" name="test"/>
    <input type="submit" value="go">
</form>
</body>
</html>
