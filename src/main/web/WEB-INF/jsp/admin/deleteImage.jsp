<%--
  Created by IntelliJ IDEA.
  User: songqiming
  Date: 2018/1/11
  Time: 15:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>删除图片通知页面</title>
    <meta http-equiv="refresh" content ="5;url=${pageContext.request.contextPath}/admin_image_list">
    <script type="text/javascript">
        var i = 6;
        function shownum(){
            i=i-1;
            document.getElementById("time").innerHTML=i+"秒后自动跳转图库管理界面";
            setTimeout('shownum()',1001);
        }
    </script>
</head>
<body onload="shownum()">
<div>
删除成功
</div>
<div>
    <span id="time"></span>
</div>
</body>
</html>
