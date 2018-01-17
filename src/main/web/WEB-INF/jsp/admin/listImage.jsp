<%--
  Created by IntelliJ IDEA.
  User: songqiming
  Date: 2018/1/11
  Time: 14:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>图库管理</title>
</head>
<script type="text/javascript">
    var jsonString = null;

    var content = document.getElementById("content");

    function admin() {
        var form = new FormData(document.getElementById("admin_image_add_with_json"));

        var xmlHttpRequest = null;

        if(window.XMLHttpRequest){
            xmlHttpRequest = new XMLHttpRequest();
        } else if (window.ActiveXObject){
            xmlHttpRequest = new ActiveXObject("Microsoft.XMLHTTP");
        }

        xmlHttpRequest.onreadystatechange = function back() {
            if (xmlHttpRequest.readyState === 4 && xmlHttpRequest.status === 200) {
                content.innerText = jsonString;
            }
        };

        xmlHttpRequest.open("post", "${pageContext.request.contextPath}/admin_image_add_with_json",false);

        xmlHttpRequest.send(form);

        $.ajax({
            url:"${pageContext.request.contextPath}/admin_image_add_with_json",
            type:"post",
            data:form,
            professData: false,
            contentType: false
        });
    }

</script>
<body>


<%@include file="../include/adminNavigator.jsp"%>
<div id="content"></div>
<div>
<table>
    <form method="post" id="admin_image_add_with_json" enctype="multipart/form-data">
        <thead>
        <tr>
            <th>新增图片(json)</th>
        </tr>
        <tr>
            <th>
                <input type="file" name="image_json" id="image_json">
            </th>
            <th>
                <input type="submit" value="新增本地图片（json）" onclick="admin()">
            </th>
        </tr>
        <tr>
            <th>图片</th>
        </tr>
        </thead>
    </form>
    <form method="post" action="admin_image_add" enctype="multipart/form-data">
        <thead>
        <tr>
            <th>新增图片</th>
        </tr>
        <tr>
            <th>
                <input type="file" name="image" id="image">
            </th>
            <th>
                <input type="submit" value="新增本地图片">
            </th>
        </tr>
        <tr>
            <th>图片</th>
        </tr>
        </thead>
    </form>
    <tbody>
        <c:forEach items="${images}" var="i">
            <tr>
                <th><img src="${pageContext.request.contextPath}/${i.url}" alt="${i.url}" width="300" height="200"></th>
                <th><a href="admin_image_delete?id=${i.id}">删除图片</a></th>
            </tr>
        </c:forEach>
    </tbody>

</table>
</div>
</body>
</html>
