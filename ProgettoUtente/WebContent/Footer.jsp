<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<style>
 .footer {
   position: fixed;
   left: 0;
   bottom: 0;
   width: 100%;
   background-color: pink;
   color: white;
   text-align: center;
}
  



li a {
  display: block;
  color: white;
  text-align: center;
  padding: 14px 16px;
  text-decoration: none;
}

li a:hover:not(.active) {
  background-color: black;
}

.active {
  background-color: pink;
}
</style>
<meta charset="ISO-8859-1">
<title>Footer</title>
</head>

<body>

<nav>
<div class= "footer">
 <ul>
  
  <li><a class="active">Developed by: Alice Urban &copy;</a></li>
  <li><a href="HomePage.jsp">HomePage</a></li>
  <li><a href="mailto:indirizzo@email.com">Contattaci!</a></li>

</ul>
</div>
</nav>
</body>
</html>