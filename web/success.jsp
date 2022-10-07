<%--
  Created by IntelliJ IDEA.
  User: Tiamo
  Date: 2022/10/7
  Time: 15:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="StuInfoServlet?code=4" method="post">
    <table border="1" align="center">
        <Tr>
            <td>员工姓名:</td>
            <td>
                <input type="text" name="stuname">
            </td>
        </Tr>
        <Tr>
            <td>员工性别:</td>
            <td>
                <input type="radio" name="stusex" value="男" checked="checked">男
                <input type="radio" name="stusex" value="女">女
            </td>
        </Tr>
        <Tr>
            <td>员工年龄:</td>
            <td>
                <input type="text" name="stuage">
            </td>
        </Tr>
        <Tr>
            <td colspan="2" align="center">
                <input type="submit" value="新增">
            </td>
        </Tr>
    </table>
    </table>
</form>
</body>
</html>
