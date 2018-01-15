<%--
  Created by IntelliJ IDEA.
  User: songqiming
  Date: 2018/1/10
  Time: 下午5:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>新闻管理页面</title>
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
            <th>创建时间</th>
            <th>新闻标题</th>
            <th>新闻静态页面url</th>
            <th>新闻图片</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${news}" var="n">
            <tr>
                <td>${n.id}</td>
                <td><fmt:formatDate value="${n.createDate}" pattern="yyyy-MM-dd"/></td>
                <td>${n.title}</td>
                <td>${n.newsPageUrl}</td>
                <td>
                    <a href="admin_select_news_image_page?id=${n.id}">
                        <img src="${pageContext.request.contextPath}/${n.imageUrl}" alt="${n.imageUrl}" width="300" height="200">更改图片</a>
                </td>
                <td>
                    <a href="${pageContext.request.contextPath}/admin_edit_news_page?id=${n.id}">编辑新闻</a>
                </td>
                <td>
                    <a href="${pageContext.request.contextPath}/admin_news_delete?id=${n.id}">删除新闻</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
        <form method="post" action="${pageContext.request.contextPath}/admin_news_add">
            <tfoot>
            <tr>
                <td>新增新闻</td>
                <td>创建时间</td>
                <td>新闻标题</td>
                <td>新闻静态页面url</td>
            </tr>
            <tr>
                <td>新闻id自动生成</td>
                <td>新闻创建时间自动生成</td>
                <td><input  id="title" name="title" type="text"></td>
                <td><input  id="newsPageUrl" name="newsPageUrl" type="text"></td>
                <td><input id="categoryId" name="categoryId" type="hidden"></td>
                <td><input id="categoryType" name="categoryType" type="hidden"></td>
                <td colspan="2" align="center">
                    <button type="submit">新增新闻</button>
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
