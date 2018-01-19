<%--
  Created by IntelliJ IDEA.
  User: sqm
  Date: 2018-01-09
  Time: 20:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>删除分类通知页面</title>
    <meta http-equiv="refresh" content ="2;url=${pageContext.request.contextPath}/admin/admin_category_list">
    <script type="text/javascript">
        var i = 3;
        function shownum(){
            i=i-1;
            document.getElementById("time").innerHTML=i+"秒后自动跳转分类管理界面";
            setTimeout('shownum()',1001);
        }
    </script>
</head>
<body onload="shownum()">
<div>
    <c:choose>
        <c:when test="${result}">删除成功</c:when>
        <c:otherwise>删除失败</c:otherwise>
    </c:choose>
</div>
<div>
    <span id="time"></span>
</div>
</body>
</html>
