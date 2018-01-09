<%--
  Created by IntelliJ IDEA.
  User: sqm
  Date: 2018-01-07
  Time: 21:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta name="description" content="">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>主页</title>

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
</head>
<body>
<div id="menu">
    <ul>
        <li><a href="#">首页</a></li>
        <li class="navbar"><a href="list_projects_by_category_type?categoryType=type_landscape">景观设计</a>
            <ul>
                <li><a href="list_projects_by_category_id?categoryId=1">${categories[0].name}</a></li>
                <li><a href="list_projects_by_category_id?categoryId=2">${categories[1].name}</a></li>
            </ul>
        </li>
        <li class="navbar"><a href="list_projects_by_category_type?categoryType=type_tourism">旅游规划</a>
            <ul>
                <li><a href="list_projects_by_category_id?categoryId=3">${categories[2].name}</a></li>
                <li><a href="list_projects_by_category_id?categoryId=4">${categories[3].name}</a></li>
                <li><a href="list_projects_by_category_id?categoryId=5">${categories[4].name}</a></li>
            </ul>
        </li>
        <li><a href="list_projects_by_category_type?categoryType=type_decoration">建筑装饰设计</a></li>
        <li><a href="list_projects_by_category_type?categoryType=type_wonderland">智慧乐园</a></li>
        <li><a href="list_projects_by_category_type?categoryType=type_art">艺术雕塑</a></li>
        <li><a href="list_projects_by_category_type?categoryType=type_garden">苗圃种植</a></li>
        <li class="navbar"><a href="#">关于蓝海</a>
            <ul>
                <li><a href="philosophy">${categories[5].name}</a></li>
                <li><a href="list_news">${categories[6].name}</a></li>
                <li><a href="honor">${categories[7].name}</a></li>
                <li><a href="list_creators">${categories[8].name}</a></li>
                <li><a href="list_profession">${categories[9].name}</a></li>
                <li><a href="join">${categories[10].name}</a></li>
                <li><a href="partner">${categories[11].name}</a></li>
            </ul>
        </li>
        <li><a href="follow">关注蓝海</a></li>
        <li><a href="admin">后台管理</a></li>
    </ul>
</div>
</body>
</html>
