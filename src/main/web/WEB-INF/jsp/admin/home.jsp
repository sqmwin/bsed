<%--
  Created by IntelliJ IDEA.
  User: sqm
  Date: 2018-01-08
  Time: 20:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script src="${pageContext.request.contextPath}/js/jquery/jquery-3.2.1.min.js"></script>
<html>
<head>
    <title>后台管理主页</title>
</head>
<body>
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


<div id="content">


</div>


<button id="admin_category_list" type="button" onclick="admin()">获取category_json</button>


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

        xmlHttpRequest.open("GET", "${pageContext.request.contextPath}/admin_category_list_with_json");

        xmlHttpRequest.send(null);
    }

</script>
</html>
