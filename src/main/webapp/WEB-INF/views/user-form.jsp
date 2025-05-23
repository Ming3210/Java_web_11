<%--
  Created by IntelliJ IDEA.
  User: Hi
  Date: 23/05/2025
  Time: 7:47 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Form Đăng Ký User</title>
</head>
<body>
<h2>Form Đăng Ký User</h2>
<form:form modelAttribute="user" method="post" action="${pageContext.request.contextPath}/user/save">

    <div>
        <form:label path="id">ID:</form:label>
        <form:input path="id"/><br>
        <form:errors path="id" cssClass="error"/>
    </div>

    <div>
        <form:label path="name">Tên:</form:label>
        <form:input path="name"/><br>
        <form:errors path="name" cssClass="error"/>
    </div>

    <div>
        <form:label path="email">Email:</form:label>
        <form:input path="email"/><br>
        <form:errors path="email" cssClass="error"/>
    </div>

    <div>
        <form:label path="address">Địa chỉ:</form:label>
        <form:input path="address"/>
        <br>
        <form:errors path="address" cssClass="error"/>
    </div>

    <div>
        <form:label path="phoneNumber">Điện thoại:</form:label>
        <form:input path="phoneNumber"/><br>
        <form:errors path="phoneNumber" cssClass="error"/>

    </div>

    <div>
        <input type="submit" value="Gửi"/>
    </div>
</form:form>

<style>
    .error {
        color: red;
    }
</style>
</body>
</html>
