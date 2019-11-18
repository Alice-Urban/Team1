<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
 <%@page errorPage="Error.jsp" %>
<!DOCTYPE html>
<html>
<head>
<style>
h1,h2{
font-family: 'Open Sans', arial, sans-serif;
font-weight: bold;
color: 	pink;
}
p {
color: red;
font-family: 'Open Sans', arial, sans-serif;
font-weight: bold;

}
</style>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

</head>



<body>
<header><%@ include file="Header.jsp"%></header>
<h1> Benvenuto/a!</h1>

<h2>Completa il form per registrarti: </h2>

<p><% String risposta = (String)session.getAttribute("error");
if (risposta!=null){
out.println (risposta);
}%> </p>
 <form action ="RegistrazioneServlet" method="POST">
  <b>Username: </b> <input placeholder ="username" type = "text" name="username_inserito"> <br> 
  <b>Password: </b> <input placeholder ="password" type = "password" name="password_inserita"> <br>
  <b>Nome:     </b> <input placeholder ="nome" type = "text" name="nome_inserito"> <br>
  <b>Cognome: </b> <input placeholder ="cognome" type = "text" name="cognome_inserito"> <br>
  <b>Indirizzo: </b> <input placeholder ="indirizzo" type = "text" name="indirizzo_inserito"> <br>
  <b>Città: </b> <input placeholder ="città" type = "text" name="città_inserita"> <br>
  <b>Data di nascita:</b> <input placeholder ="data_nascita"  type = "date" name="data_nascita"> <br>
  
  <input  type="submit" value="Invia" name ="bottoneRegistrazione"> <br>


</form>

<footer><%@ include file="Footer.jsp"%></footer>
</body>

</html>