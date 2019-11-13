<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome page</title>
</head>
<style type="text/css">
h1 {
font-family: 'Open Sans', arial, sans-serif;
font-weight: bold;
color: 	#C5908E;

}
h2 {
font-family: 'Open Sans', arial, sans-serif;
font-weight: bold;
color:	#FBBBB9;
}
p {
font-family: 'Open Sans', arial, sans-serif;
font-weight: bold;
color:	#FBBBB9;
align: right;
}
</style>
<header><%@ include file="Header.jsp"%></header>


<body>

<h1> Benvenuto/a <% String usernam = (String)session.getAttribute("username");
if(usernam!=null){
out.println(usernam);}%>! </h1>



 
<h2>Per tornare alla HomePage <a href= "HomePage.jsp"> Clicca qui! </a> </h2>

<h3> Vuoi eliminarti? Inserisci il tuo username: </h3>

<p> <% String update = (String)session.getAttribute("update");
if(update!=null){
out.println(update);}%>


<form action= "RegistrazioneServlet" method ="GET"> 
<b>Username:</b> <input placeholder ="username" type = "text" name="username_inserito">
<input type= "submit" value="Elimina" name= "bottone2"> 
</form>

<h4>Per aggiornare il tuo profilo <a href= "AggiornaProfilo.jsp"> Clicca qui! </a></h4>

<a href ="Logout.jsp">
<input type="button" name="bottone" value="Logout">
</a>

<footer><%@ include file="Footer.jsp"%></footer>
</body>

</html>