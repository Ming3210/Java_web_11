<%--
  Created by IntelliJ IDEA.
  User: Hi
  Date: 23/05/2025
  Time: 10:06 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<h2>Thêm danh mục mới</h2>

<c:if test="${not empty error}">
    <div style="color:red">${error}</div>
</c:if>

<form:form method="post" modelAttribute="category" action="${pageContext.request.contextPath}/categories/add">

    <label for="categoryName">Tên danh mục:</label>
    <form:input path="categoryName" id="categoryName" /> <br>
    <form:errors path="categoryName" cssClass="error" /> <br>

    <label for="status">Kích hoạt:</label>
    <form:checkbox path="status" id="status" /> <br>

    <button type="submit">Thêm mới</button>
</form:form>

<a href="${pageContext.request.contextPath}/categories">Quay lại danh sách</a>

<style>
    .error {
        color: red;
        font-size: 0.9em;
    }
</style>
