<%--
  Created by IntelliJ IDEA.
  User: songqiming
  Date: 2018/1/17
  Time: 18:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改密码</title>
</head>
<body>
<div>
    <a href="javascript:history.back(-1)">返回上一页</a>
</div>
<div>
    ${pageContext.request.getAttribute("message")}
</div>
<form action="${pageContext.request.contextPath}/admin_user_edit" method="post">
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
            <td><input type="hidden" id="username" name="username" value="${pageContext.session.getAttribute("user").username}"></td>
            <td><input type="submit" value="修改密码"></td>
        </tr>
    </table>
</form>
</body>
</html>
