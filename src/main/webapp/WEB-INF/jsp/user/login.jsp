<%--
  Created by IntelliJ IDEA.
  User: 陈志强
  Date: 13-10-16
  Time: 下午8:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>
<html>
<head>
    <title>登录页面</title>
</head>
<body>
<form method="post">
    姓名： <input type="text" name="name"/> <sf:errors path="name"/><br/>
    密码： <input type="password" name="password"/>   <sf:errors path="password"/><br/>
    <input type="submit" value="登录"/>
</form>
</body>
</html>