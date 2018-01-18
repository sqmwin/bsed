<%--
  Created by IntelliJ IDEA.
  User: sqm
  Date: 2018-01-09
  Time: 20:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>编辑分类页面</title>
</head>
<body>
<div>编辑分类</div>
<div>
    <form method="post" action="${pageContext.request.contextPath}/admin/admin_category_edit">
        <table>
            <tr>
                <td>分类名称</td>
                <td><input  id="name" name="name" type="text" value="${category.name}"></td>
            </tr>
            <tr>
                <td>分类类型</td>
                <td>
                    <select id="type" name="type">
                        <option value="type_landscape"<c:if test="${category.type == 'type_landscape'}">
                            selected="selected"
                        </c:if>>景观设计(type_landscape)</option>
                        <option value="type_tourism"<c:if test="${category.type == 'type_tourism'}">
                            selected="selected"
                        </c:if>>旅游规划(type_tourism)</option>
                        <option value="type_decoration"<c:if test="${category.type == 'type_decoration'}">
                            selected="selected"
                        </c:if>>建筑装饰设计(type_decoration)</option>
                        <option value="type_wonderland"<c:if test="${category.type == 'type_wonderland'}">
                            selected="selected"
                        </c:if>>智慧乐园(type_wonderland)</option>
                        <option value="type_art"<c:if test="${category.type == 'type_art'}">
                            selected="selected"
                        </c:if>>艺术雕塑(type_art)</option>
                        <option value="type_garden"<c:if test="${category.type == 'type_garden'}">
                            selected="selected"
                        </c:if>>苗圃种植(type_garden)</option>
                        <option value="type_other"<c:if test="${category.type == 'type_other'}">
                            selected="selected"
                        </c:if>>关于蓝海(type_other)</option>
                    </select>
                </td>
            </tr>
            <tr>
                <td>分类描述</td>
                <td>
                    <textarea name="description" id="description" cols="50" rows="10">${category.description}</textarea>
                </td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <button type="submit">修改分类</button>
                </td>
                <td colspan="2" align="center">
                    <form method="get" action="${pageContext.request.contextPath}/admin/admin_category_list">
                        <button type="submit">撤销修改</button>
                    </form>
                </td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>
