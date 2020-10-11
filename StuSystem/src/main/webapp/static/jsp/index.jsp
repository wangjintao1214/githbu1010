<%--
  Created by IntelliJ IDEA.
  User: 孙阔
  Date: 2020/10/11
  Time: 8:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
                <input type="text" name="title"><input type="button" value="提交检索" onclick="submit()">
                <input type="button" value="新增标准" onclick="add()">
                <input type="button" value="删除标准" onclick="del()">
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
    </table>
</center>
</body>
</html>
