<%--
  Created by IntelliJ IDEA.
  User: songqiming
  Date: 2018/1/17
  Time: 19:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" isELIgnored="false"%>

<div>
    欢迎${pageContext.session.getAttribute("user").nickname}
</div>
<%--分类--%>
<div>
    <a href="${pageContext.request.contextPath}/admin_category_list">分类管理</a>
</div>

<%--项目--%>
<div>
    <a href="${pageContext.request.contextPath}/admin_project_list">项目管理</a>
</div>

<%--新闻--%>
<div>
    <a href="${pageContext.request.contextPath}/admin_news_list">新闻管理</a>
</div>

<%--主创团队--%>
<div>
    <a href="${pageContext.request.contextPath}/admin_creator_list">主创团队管理</a>
</div>

<%--专家团队--%>
<div>
    <a href="${pageContext.request.contextPath}/admin_profession_list">专家团队管理</a>
</div>

<%--图库管理--%>
<div>
    <a href="${pageContext.request.contextPath}/admin_image_list">图库管理</a>
</div>

<%--修改密码--%>
<div>
    ${pageContext.request.getAttribute("message")}
</div>
<div>
    <a href="${pageContext.request.contextPath}/admin_user_edit_page">修改密码</a>
</div>