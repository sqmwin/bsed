<%--
  Created by IntelliJ IDEA.
  User: sqm
  Date: 2018-01-08
  Time: 20:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<script src="${pageContext.request.contextPath}/js/jquery/jquery-3.2.1.min.js"></script>
<html>
<head>
    <title>后台管理主页</title>
</head>
<body>
<%@include file="../include/adminNavigator.jsp"%>
<div>${message}</div>
<div id="content">
</div>


<button id="${pageContext.request.contextPath}/admin/admin_category_list" type="button" onclick="admin()">获取category_json</button>


</body>
<script type="text/javascript">
    var jsonObj = null;

    var content = document.getElementById("content");

    function admin() {

        var xmlHttpRequest = null;

        if(window.XMLHttpRequest){
            xmlHttpRequest = new XMLHttpRequest();
        } else if (window.ActiveXObject){
            xmlHttpRequest = new ActiveXObject("Microsoft.XMLHTTP");
        }

        xmlHttpRequest.onreadystatechange = function callBack() {
            if (xmlHttpRequest.readyState === 4 && xmlHttpRequest.status === 200) {
                // jsonString = eval("(" + xmlHttpRequest.responseText + ")");
                jsonObj = JSON.parse(xmlHttpRequest.responseText);

                // $(jsonObj).each(function () {
                //     var category = "id:" + this.id ;
                //     var innerDiv = document.createElement("div");
                //     innerDiv.innerHTML = category;
                //     content.appendChild(innerDiv);
                // })

                // for (var key in jsonObj) {
                //     console.log(key);
                //     console.log(jsonObj(key));
                // }

                // for(var i = 0; i< jsonObj.length; i++) {
                //     var category = jsonObj[i];
                //     var innerDiv = document.createElement("div");
                //     innerDiv.innerHTML = category;
                //     content.appendChild(innerDiv);
                // }

                content.innerHTML = jsonObj;
            }
        };

        xmlHttpRequest.open("GET", "${pageContext.request.contextPath}/admin/admin_category_list_with_json");

        xmlHttpRequest.send(null);
    }

</script>
</html>
