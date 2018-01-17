<%--
  Created by IntelliJ IDEA.
  User: sqm
  Date: 2018-01-06
  Time: 22:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>新闻页面</title>
</head>
<body>
<div>
    <a href="${pageContext.request.contextPath}/forehome">返回主页</a>
</div>
<div>
    <table>
        <thead>
        <tr>
            <th>新闻标题</th>
            <th>新闻时间</th>
            <th>新闻图片</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${newsList}" var="n">
            <tr>
                <td>
                    <a href="${pageContext.request.contextPath}/show_news?id=${n.id}">${n.title}</a>
                </td>
                <td><fmt:formatDate value="${n.createDate}" pattern="yyyy-MM-dd"/></td>
                <td><img src="${pageContext.request.contextPath}/${n.imageUrl}" alt="${n.imageUrl}" height="200" width="300"></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>
