<%--
  Created by IntelliJ IDEA.
  User: songqiming
  Date: 2018/1/17
  Time: 19:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" isELIgnored="false"%>

<div id="menu">
    <div>欢迎${pageContext.session.getAttribute("user").nickname}</div>
    <ul>
        <li><a href="${pageContext.request.contextPath}/admin/admin_user_logout">退出</a></li>
        <li><a href="${pageContext.request.contextPath}/admin/admin_category_list">分类管理</a></li>
        <li><a href="${pageContext.request.contextPath}/admin/admin_project_list">项目管理</a></li>
        <li><a href="${pageContext.request.contextPath}/admin/admin_news_list">新闻管理</a></li>
        <li><a href="${pageContext.request.contextPath}/admin/admin_creator_list">主创团队管理</a></li>
        <li><a href="${pageContext.request.contextPath}/admin/admin_profession_list">专家团队管理</a></li>
        <li><a href="${pageContext.request.contextPath}/admin/admin_image_list">图库管理</a>
        <li><a href="${pageContext.request.contextPath}/admin/admin_user_edit_page">修改密码</a></li>
    </ul>
    <div></div>
</div>
