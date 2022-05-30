<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<title>Music for mood</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="<c:url value="/css/w3.css"/>" rel="stylesheet" type="text/css">
<style>
body {
  margin: 20px;
}

.mood {
  display: none;
  grid-template-columns: 300px 300px 300px;
  grid-gap: 10px;
  background-color: #fff;
  color: #444;
}

.box {
  color: #fff;
  border-radius: 5px;
  padding: 20px;
}

div#box a:visited {
    color: white;
}

</style>
<body>

<nav class="w3-sidenav w3-light-grey w3-card-2" style="width:270px">
  <div class="w3-container">
    <h5><b>Выберите настроение:</b></h5>
  </div>
  <c:forEach items="${moods}" var="mood">
    <a href="#" class="tablink" onclick="openCity(event, '${mood.name}')">${mood.name}</a>
  </c:forEach>
</nav>

<div style="margin-left:290px">
  <c:forEach items="${moods}" var="mood">
      <div id="${mood.name}" class="mood">
        <c:forEach items="${mood.playlists}" var="playlist">
            <div class="box w3-light-grey ${playlist.name}">
                <a href="${playlist.url}">${playlist.name}</a>
            </div>
        </c:forEach>
      </div>
  </c:forEach>
</div>

<script>
function openCity(evt, moodName) {
  var i, x, tablinks;
  x = document.getElementsByClassName("mood");
  for (i = 0; i < x.length; i++) {
     x[i].style.display = "none";
  }
  tablinks = document.getElementsByClassName("tablink");
  for (i = 0; i < x.length; i++) {
      tablinks[i].className = tablinks[i].className.replace(" w3-red", "");
  }
  document.getElementById(moodName).style.display = "grid";
  evt.currentTarget.className += " w3-red";
}
</script>

</body>
</html>