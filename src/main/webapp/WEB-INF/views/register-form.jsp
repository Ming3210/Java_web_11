<%--
  Created by IntelliJ IDEA.
  User: Hi
  Date: 23/05/2025
  Time: 8:04 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Form Đăng Ký</title>
</head>
<body>
<h2>Đăng ký tài khoản</h2>

<form:form modelAttribute="registerUser" method="post" action="${pageContext.request.contextPath}/register">

    <div>
        <form:label path="name">Tên:</form:label>
        <form:input path="name" />
        <form:errors path="name" cssClass="error" />
    </div>

    <div>
        <form:label path="email">Email:</form:label>
        <form:input path="email" />
        <form:errors path="email" cssClass="error" />
    </div>

    <div>
        <form:label path="password">Mật khẩu:</form:label>
        <form:password path="password" />
        <form:errors path="password" cssClass="error" />
    </div>

    <div>
        <input type="submit" value="Đăng ký" />
    </div>
</form:form>

<style>
    .error {
        color: red;
    }
</style>

</body>
</html>
