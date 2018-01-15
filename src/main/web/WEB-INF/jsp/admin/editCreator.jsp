
<%--
  Created by IntelliJ IDEA.
  User: sqm
  Date: 2018-01-10
  Time: 09:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>编辑主创页面</title>

</head>
<body>
<c:set var="c" value="${creator}"/>
<div>编辑主创</div>
<div>
    <form method="post" action="${pageContext.request.contextPath}/admin_creator_edit">
        <table>
            <tr>
                <td>主创id</td>
                <td>主创姓名</td>
                <td>主创职业</td>
                <td>主创简介</td>
            </tr>
            <tr>
                <td>${c.id}<input type="hidden" id="id" name="id" value="${c.id}"></td>
                <td><input type="text" id="name" name="name" value="${c.name}"></td>
                <td><input type="text" id="jobTitle" name="jobTitle" value="${c.jobTitle}"></td>
                <td><textarea name="description" id="description" cols="50" rows="10">${c.description}</textarea></td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <button type="submit">修改主创</button>
                </td>
                <td colspan="2" align="center">
                    <form method="post" action="admin_creator_list">
                        <button type="submit">撤销修改</button>
                    </form>
                </td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>
