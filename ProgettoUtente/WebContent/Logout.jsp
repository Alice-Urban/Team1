<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<style>
h1 {
color:pink;

font-family: 'Open Sans', arial, sans-serif;
font-weight: bold;
}
</style>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Complimenti! Hai effettuato il Logout!</h1>

<%session.invalidate();%>
<h2>Per tornare alla HomePage <a href= "HomePage.jsp"> Clicca qui! </a> </h2>
</body>
</html>