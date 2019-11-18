<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <%@page isErrorPage = "true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<style>
h1,h2 {
font-family: cursive;
}
</style>
<title>Errore</title>
</head>
<body>
<h1><font color= red>Oops...</font></h1>
    <h2><font color= red><c:out value="${Errore}"/></font> </h2><br>
   
 
    
   
     <br> <img src="https://miro.medium.com/max/2800/1*QFRce-OnlybDjvWhMX8Y-w.gif">
     
</body>
</html>