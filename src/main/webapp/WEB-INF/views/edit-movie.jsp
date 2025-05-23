<%--
  Created by IntelliJ IDEA.
  User: Hi
  Date: 23/05/2025
  Time: 7:26 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Update Movie</title>
</head>
<body>
<h2>Update Movie</h2>

<form action="/update-movie" method="post" enctype="multipart/form-data">
  <input type="hidden" name="id" value="${movie.id}"/>

  <label>Title:</label>
  <input type="text" name="title" value="${movie.title}" required maxlength="100"/><br/>

  <label>Director:</label>
  <input type="text" name="director" value="${movie.director}" required maxlength="50"/><br/>

  <label>Release Date:</label>
  <input type="date" name="releaseDate" value="${movie.releaseDate}" required/><br/>

  <label>Genre:</label>
  <input type="text" name="genre" value="${movie.genre}" required maxlength="30"/><br/>

  <label>Poster (upload new if want to change):</label>
  <input type="file" name="poster"/><br/>

  <img src="${movie.poster}" alt="Current Poster" width="150"/><br/><br/>

  <button type="submit">Update Movie</button>
</form>

</body>
</html>
