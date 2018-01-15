<%--
  Created by IntelliJ IDEA.
  User: songqiming
  Date: 2018/1/10
  Time: 下午5:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>主创人员管理页面</title>
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
            <th>主创姓名</th>
            <th>主创职业</th>
            <th>主创简介</th>
            <th>主创图片</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${creators}" var="c">
            <tr>
                <td>${c.id}</td>
                <td>${c.name}</td>
                <td>${c.jobTitle}</td>
                <td>${c.description}</td>
                <td>
                    <a href="admin_select_creator_image_page?id=${c.id}">
                        <img src="${pageContext.request.contextPath}/${c.imageUrl}" alt="${c.imageUrl}" width="150" height="200">更改图片</a>
                </td>
                <td>
                    <a href="${pageContext.request.contextPath}/admin_edit_creator_page?id=${c.id}">编辑新闻</a>
                </td>
                <td>
                    <a href="${pageContext.request.contextPath}/admin_creator_delete?id=${c.id}">删除新闻</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
        <form method="post" action="${pageContext.request.contextPath}/admin_creator_add">
            <tfoot>
            <tr>
                <td>新增主创</td>
                <td>主创姓名</td>
                <td>主创职业</td>
                <td>主创简介</td>
            </tr>
            <tr>
                <td>主创id自动生成</td>
                <td><input  id="name" name="name" type="text"></td>
                <td><input  id="jobTitle" name="jobTitle" type="text"></td>
                <td><textarea name="description" id="description" cols="50" rows="10">${c.description}</textarea></td>
                <td colspan="2" align="center">
                    <button type="submit">新增主创</button>
                </td>
            </tr>
            </tfoot>
        </form>
    </table>
</div>
<%--pageHelp分页--%>
<div>
    <style>
        nav ul {
            list-style: none;
        }
        nav ul li {
            float: left;
            width: 20px;
        }
    </style>
    <nav>
        <ul class="pagenation">
            <li <c:if test="${!page.hasPrevious}">class="disabled"</c:if>>
                <a href="?start=0" aria-label="Previous">
                    <span aria-hidden="true">&laquo;</span>
                </a>
            </li>

            <li <c:if test="${!page.hasPrevious}">class="disabled"</c:if>>
                <a href="?start=${page.start - page.count}" aria-label="Previous">
                    <span aria-hidden="true">&lsaquo;</span>
                </a>
            </li>

            <c:forEach begin="0" end="${page.totalPage-1}" varStatus="status">
                <li <c:if test="${status.index * page.count == page.start}">class="disabled"</c:if>>
                    <a href="?start=${status.index * page.count}" <c:if test="${status.index * page.count == page.start}">class="current"</c:if>>${status.count}</a>
                </li>
            </c:forEach>

            <li <c:if test="${!page.hasNext}">class="disabled"</c:if>>
                <a href="?start=${page.start + page.count}" aria-label="Next">
                    <span aria-hidden="true">&rsaquo;</span>
                </a>
            </li>
            <li <c:if test="${!page.hasNext}">class="disabled"</c:if>>
                <a href="?start=${page.last}" aria-label="Next">
                    <span aria-hidden="true">&raquo;</span>
                </a>
            </li>
        </ul>
    </nav>
</div>
</body>
<script type="text/javascript">
    $(function () {
        $("ul.pagenation li.disabled a").click(function () {
            return false;
        })
    })
</script>

</body>
</html>
