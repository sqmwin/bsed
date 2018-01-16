
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
    <title>编辑专家页面</title>

</head>
<body>
<c:set var="p" value="${profession}"/>
<div>编辑专家</div>
<div>
    <form method="post" action="${pageContext.request.contextPath}/admin_profession_edit">
        <table>
            <tr>
                <td>专家id</td>
                <td>专家姓名</td>
                <td>专家职业</td>
                <td>专家简介</td>
            </tr>
            <tr>
                <td>${p.id}<input type="hidden" id="id" name="id" value="${p.id}"></td>
                <td><input type="text" id="name" name="name" value="${p.name}"></td>
                <td><input type="text" id="jobTitle" name="jobTitle" value="${p.jobTitle}"></td>
                <td><textarea name="description" id="description" cols="50" rows="10">${p.description}</textarea></td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <button type="submit">修改专家</button>
                </td>
                <td colspan="2" align="center">
                    <form method="get" action="admin_profession_list">
                        <button type="submit">撤销修改</button>
                    </form>
                </td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>
