
<%--
  Created by IntelliJ IDEA.
  User: sqm
  Date: 2018-01-06
  Time: 11:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>项目管理页面</title>
    <script src="${pageContext.request.contextPath}/js/jquery/jquery-3.2.1.min.js"></script>
    <script type="text/javascript">
        <%--生成年份下拉列表--%>
        function createYear() {
            var year = document.getElementById("year");
            for (var i = 2000; i <= 2030; i++) {
                var option = document.createElement('option');
                option.setAttribute('value', i);
                option.innerHTML = i;
                year.appendChild(option);
            }
        }
    </script>


</head>
<body onload="createYear()">
<div>
    <form action="admin_home">
        <button type="submit">返回上一级</button>
    </form>
</div>
<div>
    <table>
        <thead>
        <tr>
            <th>项目id</th>
            <th>项目所属分类id</th>
            <th>项目所属分类类型</th>
            <th>项目标题</th>
            <th>项目描述</th>
            <th>项目创建时间</th>
            <th>项目名称</th>
            <th>业主名称</th>
            <th>项目地点</th>
            <th>占地面积</th>
            <th>设计时间</th>
            <th>项目页面url</th>
            <th>项目图片</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${projects}" var="p">
            <tr>
                <td>${p.id}</td>
                <td>${p.categoryId}</td>
                <td>${p.categoryType}</td>
                <td>${p.title}</td>
                <td>${p.description}</td>
                <td>
                    <fmt:formatDate value="${p.createDate}" pattern="yyyy-MM-dd"/>
                </td>
                <td>${p.name}</td>
                <td>${p.owner}</td>
                <td>${p.location}</td>
                <td>${p.area}㎡</td>
                <td>
                    <fmt:formatDate value="${p.time}" pattern="yyyy"/>
                </td>
                <td>${p.projectPageUrl}</td>
                <td>
                    <a href="admin_select_project_image_page?id=${p.id}">
                    <img src="${pageContext.request.contextPath}/${p.imageUrl}" alt="${p.imageUrl}" width="300" height="200"><br/>
                    更改项目图片</a>
                </td>
                <td>
                    <a href="admin_edit_project_page?id=${p.id}">编辑项目</a>
                </td>
                <td>
                    <a href="admin_project_delete?id=${p.id}">删除项目</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
        <form method="post" action="admin_project_add">
        <tfoot>
            <tr>
                <td>新增项目</td>
                <th>项目所属分类id</th>
                <th>项目所属分类类型</th>
                <th>项目标题</th>
                <th>项目描述</th>
                <th>项目创建时间</th>
                <th>项目名称</th>
                <th>业主名称</th>
                <th>项目地点</th>
                <th>占地面积</th>
                <th>设计时间</th>
                <th>项目页面url</th>
                <th></th>
            </tr>
                <tr>
                    <td>项目id自动给出</td>
                    <td><input  id="categoryId" name="categoryId" type="text"></td>
                    <td>
                        <select id="categoryType" name="categoryType">
                            <option value="type_landscape">type_landscape</option>
                            <option value="type_tourism">type_tourism</option>
                            <option value="type_decoration">type_decoration</option>
                            <option value="type_wonderland">type_wonderland</option>
                            <option value="type_art">type_art</option>
                            <option value="type_garden">type_garden</option>
                            <option value="type_other">type_other</option>
                        </select>
                    </td>
                    <td><input  id="title" name="title" type="text"></td>
                    <td><textarea name="description" id="description" cols="30" rows="10"></textarea></td>
                    <td>项目创建时间自动生成</td>
                    <td><input  id="name" name="name" type="text"></td>
                    <td><input  id="owner" name="owner" type="text"></td>
                    <td><input  id="location" name="location" type="text"></td>
                    <td><input  id="area" name="area" type="text">㎡</td>
                    <td>
                        <select name="year" id="year">
                            <option value="">---请选择---</option>
                        </select>年
                    </td>
                    <td><input  id="projectPageUrl" name="projectPageUrl" type="text"></td>
                    <td></td>
                    <td colspan="2" align="center">
                        <button type="submit">新增项目</button>
                    </td>
                </tr>
        </tfoot>
        </form>
    </table>
</div>

<%--pageHelp分页--%>
<div>
    <style>
        nav ul {
            list-style: none;
        }
        nav ul li {
            float: left;
            width: 20px;
        }
    </style>
    <nav>
        <ul class="pagenation">
            <li <c:if test="${!page.hasPrevious}">class="disabled"</c:if>>
                <a href="?start=0" aria-label="Previous">
                    <span aria-hidden="true">&laquo;</span>
                </a>
            </li>

            <li <c:if test="${!page.hasPrevious}">class="disabled"</c:if>>
                <a href="?start=${page.start - page.count}" aria-label="Previous">
                    <span aria-hidden="true">&lsaquo;</span>
                </a>
            </li>

            <c:forEach begin="0" end="${page.totalPage-1}" varStatus="status">
                <li <c:if test="${status.index * page.count == page.start}">class="disabled"</c:if>>
                    <a href="?start=${status.index * page.count}" <c:if test="${status.index * page.count == page.start}">class="current"</c:if>>${status.count}</a>
                </li>
            </c:forEach>

            <li <c:if test="${!page.hasNext}">class="disabled"</c:if>>
                <a href="?start=${page.start + page.count}" aria-label="Next">
                    <span aria-hidden="true">&rsaquo;</span>
                </a>
            </li>
            <li <c:if test="${!page.hasNext}">class="disabled"</c:if>>
                <a href="?start=${page.last}" aria-label="Next">
                    <span aria-hidden="true">&raquo;</span>
                </a>
            </li>
        </ul>
    </nav>
</div>
</body>
<script type="text/javascript">
    $(function () {
        $("ul.pagenation li.disabled a").click(function () {
            return false;
        })
    })
</script>
</html>
