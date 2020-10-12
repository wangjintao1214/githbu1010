<%--
  Created by IntelliJ IDEA.
  User: 孙阔
  Date: 2020/10/11
  Time: 8:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript" src="/static/js/jquery-1.12.4.js"></script>
</head>
<body>
<center>
    <h2>标准信息列表</h2>
    <table border="1" style="width: 800px;height: 100px;">
        <tr align="right">
            <td colspan="7">
                <form action="/" method="post">
                <input type="text" name="title"><input type="button" value="提交检索" onclick="submit()">
                <input type="button" value="新增标准" onclick="add()">
                <input type="button" value="删除标准" onclick="del()">
                </form>
            </td>
        </tr>
        <tr class="bian" align="center" style="font-weight: bolder;background-color: #808080">
            <td><input type="checkbox" class="kuang"></td>
            <td>标准号</td>
            <td>中文名称</td>
            <td>版本</td>
            <td>发布日期</td>
            <td>实施日期</td>
            <td>操作</td>
        </tr>
        <c:forEach items="${pageInfo.list}" var="list">
            <tr align="center">
                <td><input type="checkbox" class="kuang" name="check" value="${list.id}"></td>
                <input type="hidden" value="${list.id}">
                <td>${list.stdNum}</td>
                <td>${list.zhname}</td>
                <td>${list.versionn}</td>
                <td>${list.releaseDate}</td>
                <td>${list.implDate}</td>
                <td><a href="/down?filename=${list.packagePath}">下载</a>&nbsp;&nbsp;<a href="/chaupd?id=${list.id }">修改</a></td>
            </tr>
        </c:forEach>
    </table>
    <div>
        共${pageInfo.total}条  第${pageInfo.pageNum}/${pageInfo.pages}页
        <a href="/?pageIndex=${pageInfo.firstPage}">首页</a>
        <c:if test="${pageInfo.hasPreviousPage}">
            <a href="/?pageIndex=${pageInfo.prePage}">上一页</a>
        </c:if>
        <c:forEach items="${pageInfo.navigatepageNums}" var="i">
            <a href="/?pageIndex=${i}">${i}</a>
        </c:forEach>
        <c:if test="${pageInfo.hasNextPage}">
            <a href="/?pageIndex=${pageInfo.nextPage}">下一页</a>
        </c:if>
        <a href="/?pageIndex=${pageInfo.lastPage}">尾页</a>
    </div>
    <p>${success}</p>
</center>
<script>
    function del() {
        var check = $("[name=check]:checked");
        var flag = confirm("确认是否删除");
        if (flag) {
            if (check != undefined) {
                check.each(function () {
                    var id="";
                    id+=$(this).val()+",";
                    location.href="/dodel/"+id;
                })
            } else {
                alert("请选择删除项");

            }
        }
    }
</script>
</body>
</html>
