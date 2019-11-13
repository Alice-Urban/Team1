<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
h1, h3{
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
color:red;

}

</style>

<meta charset="ISO-8859-1">
<title>HomePage</title>
</head>
<body>
<header><%@ include file="Header.jsp"%></header>
<h1><b> Bentornato! </b> </h1>  <br>
<h2>Effettua il Login: </h2>



<p> <% String risposta1 = (String)session.getAttribute("errore");
if ((risposta1!=null)&& (!(session.isNew()))){
out.println (risposta1);
}%>
</p>



<form action ="LoginServlet" method="POST">
  <b>Username: </b> <input placeholder ="username" type = "text" name="username_inserito">
  <b>Password: </b> <input placeholder ="password" type = "password" name="password_inserita"> 
  <input  type="submit" value="Invia" name ="bottone">
</form>

 <p> <% String delete = (String) session.getAttribute("delete");
if((delete!=null)){
out.println (delete);
}%>
</p>
<b>Non ti sei ancora registrato?</b> <a href= "Registrazione.jsp"> Clicca qui! </a> 




<footer><%@ include file="Footer.jsp"%></footer>
</body>

</html>