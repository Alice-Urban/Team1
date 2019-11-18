<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import = "java.util.LinkedList" %>
    <%@ page import= "com.accenture.model.Utente" %>
    <%@page errorPage="Error.jsp" %>

    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>


<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<style>

table {
  width: 90%;
  background-color: white;
  border-collapse: collapse;
  border-color: pink;
  border-style: solid;
  color: black;
}
td{
border:1px solid grey;
}

html{
    height:90%;
    min-height:90%;}
body{
    min-height:90%;}
    
h1,p {
font-family: 'Open Sans', arial, sans-serif;
font-weight: bold;
color: 	pink;

}
</style>

<h1>Iscritti al sito Web:</h1>
<%
session.getAttribute("listaUtenti");
%>
<% %>

<body>

<table>
<thead>
<tr>

<td>Username</td> 
<td>Password</td>  
<td>Nome</td>
<td>Cognome</td>
<td>Indirizzo</td>
<td>Città</td>
<td>DataNascita</td>
<td>Gestisci clienti </td>

</tr>
</thead>

 <c:forEach items="${listaUtenti}" var="items">					
				<tr>
					<td><c:out value="${items.username}" /></td>
					<td><c:out value="${items.password}" /></td>					
					<td><c:out value="${items.nome}" /></td>
					<td><c:out value="${items.cognome}" /></td>
					<td><c:out value="${items.indirizzo}" /></td>
					<td><c:out value="${items.città}" /></td>
					<td><c:out value="${items.data_nascita}" /></td>

								
				</tr>

					
					<td> <a href="AggiornaProfilo.jsp?username=${items.username}"> Update </a>
					
					<br>
					
					<a href="ServletDelete?username=${items.username}"> Delete </a>
					
					</td>
					</tr>

				
     </c:forEach>
	</table>

 
<p>Per tornare alla HomePage <a href= "HomePage.jsp"> Clicca qui! </a><p> 
      
    </body>

    </html>

  
