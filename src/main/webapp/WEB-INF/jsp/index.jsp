<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Music for mood</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="<c:url value="/css/w3.css"/>" rel="stylesheet" type="text/css">
    <link href="<c:url value="/css/navbar.css"/>" rel="stylesheet" type="text/css">
</head>
<body>

<nav class="w3-sidenav w3-light-grey w3-card-2" style="width:270px">
  <div class="w3-container">
    <h5><strong>Выберите настроение:</strong></h5>
  </div>
  <c:forEach items="${moods}" var="mood">
    <a href="#" class="tablink" onclick="openMood(event, '${mood}')">${mood}</a>
  </c:forEach>
</nav>

<div style="margin-left:290px">
  <div id="grid" class="mood"/>
</div>

<script src="js/mood.js"></script>
</body>
</html>