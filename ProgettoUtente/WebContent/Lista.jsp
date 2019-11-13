<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import = "java.util.LinkedList" %>
    <%@ page import= "com.accenture.model.Utente" %>

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
td {

border: 1px solid grey;}


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


<body>

<table>
<thead>
<tr>

<th>Username</th> 
<th>Password</th>  
<th>Nome</th>
<th>Cognome</th>
<th>Indirizzo</th>
<th>Città</th>
<th>DataNascita</th>
<th>Actions</th>
</tr>
</thead>

 <c:forEach items="${listaUtenti}" var="current">
        <tr>
          <td><c:out value="${current.username}" /><td>
          <td><c:out value="${current.password}" /><td>
           <td><c:out value="${current.nome}" /><td>
            <td><c:out value="${current.cognome}" /><td>
             <td><c:out value="${current.indirizzo}" /><td>
              <td><c:out value="${current.città}" /><td>
               <td><c:out value="${current.data_nascita}" /><td>
           
        </tr>
     </c:forEach>
	</table>


<p>Per tornare alla HomePage <a href= "HomePage.jsp"> Clicca qui! </a><p> 
      
    </body>
    </html>
  