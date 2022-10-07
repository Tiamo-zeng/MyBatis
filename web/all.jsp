<%--
  Created by IntelliJ IDEA.
  User: Tiamo
  Date: 2022/9/20
  Time: 17:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table border="1" align="center">
    <caption>学生信息表</caption>
    <tr>
        <th>学号</th>
        <th>姓名</th>
        <th>性别</th>
        <th>年龄</th>
        <th>操作</th>
    </tr>
    <!--循环遍历-->
    <c:forEach items="${stuList}" var="stu">
        <tr>
            <td>${stu.stuid}</td>
            <td>${stu.stuname}</td>
            <td>${stu.stusex}</td>
            <td>${stu.stuage}</td>
            <td>
                <a href="StuInfoServlet?code=2&stuid=${stu.stuid }">修改</a>
                <a href="StuInfoServlet?code=6&stuid=${stu.stuid }">删除</a>
            </td>
        </tr>
    </c:forEach>
    <Tr>
        <Td colspan="8" align="center">
            <a href="StuInfoServlet?code=5">新增</a>
        </Td>
    </Tr>
</table>
</body>
</html>
