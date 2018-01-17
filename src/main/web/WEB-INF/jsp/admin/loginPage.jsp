<%--
  Created by IntelliJ IDEA.
  User: songqiming
  Date: 2018/1/17
  Time: 17:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录后台管理</title>
</head>
<body>
<div>
    <a href="${pageContext.request.contextPath}/forehome">返回上一页</a>
</div>
<div>
    ${pageContext.request.getAttribute("message")}
</div>
<form method="post" action="${pageContext.request.contextPath}/admin_user_login">
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
