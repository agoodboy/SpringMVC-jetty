<%--
  Created by IntelliJ IDEA.
  User: 陈志强
  Date: 13-10-16
  Time: 下午3:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<head>
    <title>添加用户</title>
</head>
<body>
    <form:form method="post" modelAttribute="user">
        姓名： <form:input path="name"></form:input>   </br>
        昵称： <form:input path="nikeName"/>    </br>
        密码： <form:input path="password"/>   </br>
        邮箱： <form:input path="email"/>       </br>

        <input type="submit" value="提交"/>
    </form:form>
</body>
</html>