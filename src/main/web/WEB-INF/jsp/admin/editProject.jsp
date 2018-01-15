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
    <title>编辑项目页面</title>
    <%--<script type="text/javascript">--%>
        <%--&lt;%&ndash;生成年份下拉列表,并通过project的默认time选择默认选项&ndash;%&gt;--%>
        <%--function createYear() {--%>
            <%--var time = ${project.time.year};--%>
            <%--var year = document.getElementById("year");--%>
            <%--for (var i = 2000; i <= 2030; i++) {--%>
                <%--var option = document.createElement('option');--%>
                <%--option.setAttribute('value', i);--%>
                <%--if (time === i) {--%>
                    <%--option.setAttribute('selected', true);--%>
                <%--}--%>
                <%--option.innerHTML = i;--%>
                <%--year.appendChild(option);--%>
            <%--}--%>
        <%--}--%>
    <%--</script>--%>
</head>
<body onload="createYear()">
<c:set var="p" value="${project}"/>
<div>编辑项目</div>
<div>
    <form method="post" action="${pageContext.request.contextPath}/admin_project_edit">
        <table>
            <tr>
                <td>项目id</td>
                <td>项目所属分类id</td>
                <td>项目所属分类类型</td>
                <td>项目标题</td>
                <td>项目描述</td>
                <td>项目创建时间</td>
                <td>项目名称</td>
                <td>业主名称</td>
                <td>项目地点</td>
                <td>占地面积</td>
                <td>设计时间</td>
                <td>项目页面url</td>
            </tr>
            <tr>
                <td>${p.id}<input type="hidden" id="id" name="id" value="${p.id}"/> </td>
                <td><input type="text" id="categoryId" name="categoryId" value="${p.categoryId}"></td>
                <td>
                    <select id="categoryType" name="categoryType">
                        <option value="type_landscape"<c:if test="${p.categoryType == 'type_landscape'}">
                            selected="selected"
                        </c:if>>景观设计(type_landscape)</option>
                        <option value="type_tourism"<c:if test="${p.categoryType == 'type_tourism'}">
                            selected="selected"
                        </c:if>>旅游规划(type_tourism)</option>
                        <option value="type_decoration"<c:if test="${p.categoryType == 'type_decoration'}">
                            selected="selected"
                        </c:if>>建筑装饰设计(type_decoration)</option>
                        <option value="type_wonderland"<c:if test="${p.categoryType == 'type_wonderland'}">
                            selected="selected"
                        </c:if>>智慧乐园(type_wonderland)</option>
                        <option value="type_art"<c:if test="${p.categoryType == 'type_art'}">
                            selected="selected"
                        </c:if>>艺术雕塑(type_art)</option>
                        <option value="type_garden"<c:if test="${p.categoryType == 'type_garden'}">
                            selected="selected"
                        </c:if>>苗圃种植(type_garden)</option>
                        <option value="type_other"<c:if test="${p.categoryType == 'type_other'}">
                            selected="selected"
                        </c:if>>关于蓝海(type_other)</option>
                    </select>
                </td>
                <td><input type="text" id="title" name="title" value="${p.title}"></td>
                <td><textarea name="description" id="description" cols="50" rows="10">${p.description}</textarea></td>
                <td>
                    <fmt:formatDate value="${p.createDate}" pattern="yyyy-MM-dd"/>
                    <input type="hidden" id="createDate" name="createDate" value="${p.createDate}"/>
                </td>
                <td><input type="text" id="name" name="name" value="${p.name}"></td>
                <td><input type="text" id="owner" name="owner" value="${p.owner}"></td>
                <td><input type="text" id="location" name="location" value="${p.location}"></td>
                <td><input type="text" id="area" name="area" value="${p.area}">㎡</td>
                <td>
                    <%--<select name="year" id="year">--%>
                        <%--<option value="">---请选择---</option>--%>
                    <%--</select>年--%>
                    <input type="text" id="year" name="year" size="4" maxlength="4" value="<fmt:formatDate value="${p.time}" pattern="yyyy"/>">年
                </td>
                <td><input type="text" id="projectPageUrl" name="projectPageUrl" value="${p.projectPageUrl}"></td>
            </tr>

            <tr>
                <td colspan="2" align="center">
                    <button type="submit">修改项目</button>
                </td>
                <td colspan="2" align="center">
                    <form method="post" action="admin_project_list">
                    <button type="submit">撤销修改</button>
                    </form>
                </td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>
