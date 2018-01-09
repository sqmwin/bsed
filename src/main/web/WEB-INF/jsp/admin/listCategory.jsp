<%--
  Created by IntelliJ IDEA.
  User: sqm
  Date: 2018-01-08
  Time: 20:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>分类管理</title>
</head>
<body>
<div>
    <table>
        <thead>
        <tr>
            <th>id</th>
            <th>分类名称</th>
            <th>分类类型</th>
            <th>分类描述</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${categories}" var="c">
            <tr>
                <td>${c.id}</td>
                <td>${c.name}</td>
                <td>${c.description}</td>
                <td>
                    <a href="admin_category_edit?id=${c.id}">编辑分类</a>
                </td>
                <td>
                    <a href="admin_category_delete?id=${c.id}">删除分类</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
<div>新增分类</div>
    <form method="post" id="addForm" action="admin_category_add">
        <table>
            <tr>
                <td>分类名称</td>
                <td><input  id="name" name="name" type="text" class="form-control"></td>
            </tr>
            <tr>
                <td>分类类型</td>
                <td>
                    <input id="categoryPic" accept="image/*" type="file" name="image" />
                </td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <button type="submit">新增分类</button>
                </td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>
