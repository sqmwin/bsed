<%--
  Created by IntelliJ IDEA.
  User: songqiming
  Date: 2018/1/11
  Time: 12:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>上传页面</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/fileUpload" method="post" enctype="multipart/form-data">
    <input type="file" name="file"/>
    <input type="submit" name="submit" value="上传"/>
</form>
</body>
</html>
