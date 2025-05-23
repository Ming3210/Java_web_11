<%--
  Created by IntelliJ IDEA.
  User: Hi
  Date: 23/05/2025
  Time: 9:53 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>



<h2>Chỉnh sửa danh mục</h2>

<c:if test="${not empty error}">
    <div style="color:red">${error}</div>
</c:if>

<form:form method="post" modelAttribute="category" action="${pageContext.request.contextPath}/categories/edit">

    <form:hidden path="id" />

    <form:input path="categoryName" id="categoryName" /> <br>
    <form:errors path="categoryName" cssClass="error" /> <br>

    <label for="status">Kích hoạt:</label>
    <form:checkbox path="status" id="status" /> <br>

    <button type="submit">Cập nhật</button>
</form:form>

<a href="${pageContext.request.contextPath}/categories">Quay lại danh sách</a>

<style>
    .error {
        color: red;
        font-size: 0.9em;
    }
</style>
