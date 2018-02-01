<%--
  Created by IntelliJ IDEA.
  User: songqiming
  Date: 2018/1/23
  Time: 09:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
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
