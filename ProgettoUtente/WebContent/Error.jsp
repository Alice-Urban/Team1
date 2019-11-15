<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <%@page isErrorPage = "true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Errore</title>
</head>
<body>
<h1>Oops...</h1>
    <h2><c:out value="${Errore}"/> <br></h2>
   
     <br> <img src="https://miro.medium.com/max/2800/1*QFRce-OnlybDjvWhMX8Y-w.gif">
     
</body>
</html>