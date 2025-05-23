<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Hi
  Date: 23/05/2025
  Time: 9:53 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<h2>Danh sách danh mục</h2>

<a href="${pageContext.request.contextPath}/categories/add">
  <button>Thêm danh mục mới</button>
</a>

<c:forEach var="category" items="${categories}">
  <div style="margin-bottom: 10px;">
    <strong>${category.categoryName}</strong> -
    <span>
        Trạng thái:
        <c:choose>
          <c:when test="${category.status}">
            <span style="color:green;">Kích hoạt</span>
          </c:when>
          <c:otherwise>
            <span style="color:red;">Không kích hoạt</span>
          </c:otherwise>
        </c:choose>
      </span>

    &nbsp;&nbsp;|&nbsp;&nbsp;
    <a href="${pageContext.request.contextPath}/categories/edit?id=${category.id}">Sửa</a>

    <form action="${pageContext.request.contextPath}/categories/delete" method="post" style="display:inline;">
      <input type="hidden" name="id" value="${category.id}" />
      <button type="submit" onclick="return confirm('Bạn có chắc muốn xóa?');">Xóa</button>
    </form>
  </div>
</c:forEach>
