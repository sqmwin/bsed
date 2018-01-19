<%--
  Created by IntelliJ IDEA.
  User: songqiming
  Date: 2018/1/19
  Time: 10:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>

<script src="${pageContext.request.contextPath}/js/jquery/jquery-3.2.1.min.js"></script>
<script type="text/javascript">
    $(function(){
        $(".navbar").mouseover(function(){
            $(this).children("ul").show();
        });
        $(".navbar").mouseout(function(){
            $(this).children("ul").hide();
        });
    })
</script>

<style type="text/css">
    *{ margin:0px; padding:0px;}
    #menu{ width:1500px; height:40px; margin:0 auto;}
    ul{ list-style:none;}
    ul li{
        float: left;
        line-height: 40px;
        text-align: center;
        position:relative;
    }

    ul li ul{width: 100px;position: absolute;left: 0;top: 40px;display: none;}
    ul li ul li{float: none;margin-top:3px; }
    a{
        text-decoration: none;
        display:block; width:100px;
    }
</style>

<div id="menu">
    <ul>
        <li><a href="${pageContext.request.contextPath}/index">首页</a></li>
        <li class="navbar"><a href="${pageContext.request.contextPath}/list_projects_by_category_type?categoryType=type_landscape">景观设计</a>
            <ul>
                <li><a href="${pageContext.request.contextPath}/list_projects_by_category_id?categoryId=1">住宅楼盘</a></li>
                <li><a href="${pageContext.request.contextPath}/list_projects_by_category_id?categoryId=2">主题商业</a></li>
            </ul>
        </li>
        <li class="navbar"><a href="${pageContext.request.contextPath}/list_projects_by_category_type?categoryType=type_tourism">旅游规划</a>
            <ul>
                <li><a href="${pageContext.request.contextPath}/list_projects_by_category_id?categoryId=3">乡村文创旅游</a></li>
                <li><a href="${pageContext.request.contextPath}/list_projects_by_category_id?categoryId=4">民俗文化</a></li>
                <li><a href="${pageContext.request.contextPath}/list_projects_by_category_id?categoryId=5">旅游+</a></li>
            </ul>
        </li>
        <li><a href="${pageContext.request.contextPath}/list_projects_by_category_type?categoryType=type_decoration">建筑装饰设计</a></li>
        <li><a href="${pageContext.request.contextPath}/list_projects_by_category_type?categoryType=type_wonderland">智慧乐园</a></li>
        <li><a href="${pageContext.request.contextPath}/list_projects_by_category_type?categoryType=type_art">艺术雕塑</a></li>
        <li><a href="${pageContext.request.contextPath}/list_projects_by_category_type?categoryType=type_garden">苗圃种植</a></li>
        <li class="navbar"><a href="#">关于蓝海</a>
            <ul>
                <li><a href="${pageContext.request.contextPath}/idea">企业理念</a></li>
                <li><a href="${pageContext.request.contextPath}/list_news">蓝海动态</a></li>
                <li><a href="${pageContext.request.contextPath}/honor">荣誉资质</a></li>
                <li><a href="${pageContext.request.contextPath}/list_creators?categoryId=9">主创团队</a></li>
                <li><a href="${pageContext.request.contextPath}/list_profession?categoryId=10">专家团队</a></li>
                <li><a href="${pageContext.request.contextPath}/join">加入蓝海</a></li>
                <li><a href="${pageContext.request.contextPath}/partner">合作伙伴</a></li>
            </ul>
        </li>
        <li><a href="${pageContext.request.contextPath}/follow">关注蓝海</a></li>
        <li><a href="${pageContext.request.contextPath}/admin_login_page">后台管理</a></li>
        <li><a href="${pageContext.request.contextPath}/test/uploadPage.jsp">upload</a></li>
        <li><a href="${pageContext.request.contextPath}/test/exception_test_page">exception</a></li>
    </ul>
</div>
