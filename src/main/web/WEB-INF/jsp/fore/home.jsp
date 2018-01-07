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
    <title>bsed</title>

    <script src="${pageContext.request.contextPath}/js/jquery/jquery-3.2.1.min.js"></script>
    <script type="text/javascript">
        $(function(){
            $(".navbar").mouseover(function(){
                $(this).children("ul").show();
                console.log(this);
            });
            $(".navbar").mouseout(function(){
                $(this).children("ul").hide();
            });
        })
    </script>

    <style type="text/css">
        *{ margin:0px; padding:0px;}
        #menu{ width:1200px; height:40px; margin:0 auto;}
        ul{ list-style:none;}
        ul li{
            float: left;
            line-height: 40px;
            text-align: center;
            position:relative;
        }
        ul li ul{width: 90px;position: absolute;left: 0;top: 40px;display: none;}
        ul li ul li{float: none;margin-top:3px; }
    </style>
</head>
<body>
<div id="menu">
    <ul>
        <li><a href="#">首页</a></li>
        <li class="navbar"><a href="#">景观设计</a>
            <ul>
                <li><a href="#">${categories[0]}</a></li>
                <li><a href="#">${categories[1]}</a></li>
            </ul>
        </li>
        <li class="navbar"><a href="#">旅游规划</a>
            <ul>
                <li><a href="#">${categories[2]}</a></li>
                <li><a href="#">${categories[3]}</a></li>
                <li><a href="#">${categories[4]}</a></li>
            </ul>
        </li>
        <li><a href="#">建筑装饰设计</a></li>
        <li><a href="#">智慧乐园</a></li>
        <li><a href="#">艺术雕塑</a></li>
        <li><a href="#">苗圃种植</a></li>
        <li class="navbar"><a href="#">关于蓝海</a>
            <ul>
                <li><a href="#">${categories[5]}</a></li>
                <li><a href="#">${categories[6]}</a></li>
                <li><a href="#">${categories[7]}</a></li>
                <li><a href="#">${categories[8]}</a></li>
                <li><a href="#">${categories[9]}</a></li>
                <li><a href="#">${categories[10]}</a></li>
                <li><a href="#">${categories[11]}</a></li>
            </ul>
        </li>
        <li><a href="#">关注蓝海</a></li>
        <li><a href="#">后台管理</a></li>
    </ul>
</div>
</body>
</html>
