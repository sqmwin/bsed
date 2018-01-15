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
    <%--<script src="${pageContext.request.contextPath}/js/jquery/jquery-3.2.1.min.js"></script>--%>
    <%--<script type="text/javascript">--%>
        <%--var url = path + 'listCategory.jsp';--%>
    <%--</script>--%>
</head>
<body>
<div>
    <form action="${pageContext.request.contextPath}/admin_home">
        <button type="submit">返回上一级</button>
    </form>
</div>
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
                <td>${c.type}</td>
                <td>${c.description}</td>
                <td>
                    <a href="${pageContext.request.contextPath}/admin_edit_category_page?id=${c.id}">编辑分类</a>
                </td>
                <td>
                    <a href="${pageContext.request.contextPath}/admin_category_delete?id=${c.id}">删除分类</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
        <form method="post" action="${pageContext.request.contextPath}/admin_category_add">
        <tfoot>
            <tr>
                <td>新增分类</td>
                <td>分类名称</td>
                <td>分类类型</td>
                <td>分类描述</td>
            </tr>
            <tr>
                <td>分类id自动给出</td>
                <td><input  id="name" name="name" type="text"></td>
                <td>
                    <select id="type" name="type">
                        <option value="type_landscape">type_landscape</option>
                        <option value="type_tourism">type_tourism</option>
                        <option value="type_decoration">type_decoration</option>
                        <option value="type_wonderland">type_wonderland</option>
                        <option value="type_art">type_art</option>
                        <option value="type_garden">type_garden</option>
                        <option value="type_other">type_other</option>
                    </select>
                </td>
                <td>
                    <textarea name="description" id="description" cols="50" rows="10"></textarea>
                </td>
                <td colspan="2" align="center">
                    <button type="submit">新增分类</button>
                </td>
            </tr>
        </tfoot>
        </form>
    </table>
</div>
</body>
</html>
