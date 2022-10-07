<%--
  Created by IntelliJ IDEA.
  User: Tiamo
  Date: 2022/10/7
  Time: 14:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
·<form action="StuInfoServlet?code=3" method="post">
    <table border="1" align="center">
        <caption>修改学生信息</caption>
        <tr>
            <Td>学号</Td>
            <Td>
                <input type="text" name="stuid" value="${stuInfo.stuid }">
            </Td>
        </tr>
        <tr>
            <Td>姓名</Td>
            <Td>
                <input type="text" name="stuname" value="${stuInfo.stuname }">
            </Td>
        </tr>
        <tr>

            <Td>性别</Td>
            <Td>
                <c:if test="${stuInfo.stusex=='男' }" var="bool">
                    <input type="radio" name="stusex" value="男" checked="checked">男
                    <input type="radio" name="stusex" value="女">女
                </c:if>
                <c:if test="${!bool }">
                    <input type="radio" name="stusex" value="男">男
                    <input type="radio" name="stusex" value="女"  checked="checked">女
                </c:if>
            </Td>
        </tr>
        <tr>
            <Td>年龄</Td>
            <Td>
                <input type="text" name="stuage" value="${stuInfo.stuage }">
            </Td>
        </tr>
        <tr>
            <Td colspan="2" align="center">

                <input type="submit" value="修改">
            </Td>
        </tr>
    </table>
</form>
</body>
</html>
