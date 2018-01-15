
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
    <title>编辑新闻页面</title>

</head>
<body>
<c:set var="n" value="${news}"/>
<div>编辑项目</div>
<div>
    <form method="post" action="${pageContext.request.contextPath}/admin_news_edit">
        <table>
            <tr>
                <td>新闻id</td>
                <td>新闻标题</td>
                <td>新闻创建时间</td>
                <td>新闻静态页面url</td>
            </tr>
            <tr>
                <td>${n.id}<input type="hidden" id="id" name="id" value="${n.id}"></td>
                <td><input type="text" id="title" name="title" value="${n.title}"></td>
                <td>
                    <fmt:formatDate value="${p.createDate}" pattern="yyyy-MM-dd"/>
                </td>
                <td><input type="text" id="newsPageUrl" name="newsPageUrl" value="${n.newsPageUrl}"></td>
            </tr>

            <tr>
                <td colspan="2" align="center">
                    <button type="submit">修改项目</button>
                </td>
                <td colspan="2" align="center">
                    <form method="post" action="admin_news_list">
                        <button type="submit">撤销修改</button>
                    </form>
                </td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>
