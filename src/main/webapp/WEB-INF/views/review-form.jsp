<%--
  Created by IntelliJ IDEA.
  User: Hi
  Date: 23/05/2025
  Time: 9:06 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Đánh giá sản phẩm</title>
</head>
<body>
<h2>Gửi đánh giá của bạn</h2>

<form:form method="post" modelAttribute="reviewForm">

    <div>
        <form:label path="name">Tên:</form:label>
        <form:input path="name"/>
        <form:errors path="name" cssClass="error"/>
    </div>

    <div>
        <form:label path="email">Email:</form:label>
        <form:input path="email"/>
        <form:errors path="email" cssClass="error"/>
    </div>

    <div>
        <form:label path="rating">Đánh giá (1 - 5 sao):</form:label>
        <form:select path="rating">
            <form:option value="" label="--Chọn--"/>
            <form:option value="1" label="1 sao"/>
            <form:option value="2" label="2 sao"/>
            <form:option value="3" label="3 sao"/>
            <form:option value="4" label="4 sao"/>
            <form:option value="5" label="5 sao"/>
        </form:select>
        <form:errors path="rating" cssClass="error"/>
    </div>

    <div>
        <form:label path="comment">Bình luận:</form:label>
        <form:textarea path="comment" rows="4" cols="50"/>
        <form:errors path="comment" cssClass="error"/>
    </div>

    <div>
        <input type="submit" value="Gửi đánh giá"/>
    </div>
</form:form>

<style>
    .error {
        color: red;
        font-style: italic;
    }
</style>
</body>
</html>
