<%--
  Created by IntelliJ IDEA.
  User: sqm
  Date: 2018-01-09
  Time: 20:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>删除项目通知页面</title>
    <meta http-equiv="refresh" content ="5;url=admin_project_list">
    <script type="text/javascript">
        var i = 6;
        function shownum(){
            i=i-1;
            document.getElementById("time").innerHTML=i+"秒后自动跳转项目管理界面";
            setTimeout('shownum()',1001);
        }
    </script>
</head>
<body onload="shownum()">
<div>
    <c:choose>
        <c:when test="${result.equals('true')}">删除成功</c:when>
        <c:otherwise>删除失败</c:otherwise>
    </c:choose>
</div>
<div>
    <span id="time"></span>
</div>
</body>
</html>