<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
<h1> Benvenuto/a <% String usern = (String)session.getAttribute("username");
if(usern!=null){
out.println(usern);}%>! </h1>





<h2>Per aggiornare il profilo modifica i seguenti campi: </h2>


<% String admin = (String)session.getAttribute("username"); 
	String adminPSw = (String)session.getAttribute("password");
	if (admin != null) {
  		if(admin.equalsIgnoreCase("admin")) { 
  			if (adminPSw.equalsIgnoreCase("admin123")) {
  			String user=	request.getParameter("username");
  			session.setAttribute("userDaUpdate", user);
  				%>

 <form action ="ServletAdministrator" method="POST">
  <b>Password:</b> <input placeholder ="password" type = "password" name="password"> <br>
  <b>Nome: </b> <input placeholder ="nome" type = "text" name="nome"> <br>
  <b>Cognome: </b> <input placeholder ="cognome" type = "text" name="cognome"> <br>
  <b>Indirizzo: </b> <input placeholder ="indirizzo" type = "text" name="indirizzo"> <br>
  <b>Città: </b> <input placeholder ="città" type = "text" name="città"> <br>
  <b>Data di nascita:</b> <input placeholder ="data_nascita"  type = "date" name="data_di_nascita"> <br>
  
  <input  type="submit" value="Invia" name ="bottoneUpdate"> <br>
</form>

<%		
  			}
  		}
  	} 
  	%>





<% String altroUser = (String)session.getAttribute("username"); 
	String altroUserPSw2 = (String)session.getAttribute("password");
	if (altroUser != null) {
  		if(!(altroUser.equalsIgnoreCase("admin"))) { 
  			if (!(altroUserPSw2.equalsIgnoreCase("admin123"))) { %>



 <form action ="AggiornaProfilo" method="POST">
  <b>Password:</b> <input placeholder ="password" type = "password" name="password"> <br>
  <b>Nome: </b> <input placeholder ="nome" type = "text" name="nome"> <br>
  <b>Cognome: </b> <input placeholder ="cognome" type = "text" name="cognome"> <br>
  <b>Indirizzo: </b> <input placeholder ="indirizzo" type = "text" name="indirizzo"> <br>
  <b>Città: </b> <input placeholder ="città" type = "text" name="città"> <br>
  <b>Data di nascita:</b> <input placeholder ="data_nascita"  type = "date" name="data_di_nascita"> <br>
  
  <input  type="submit" value="Invia" name ="bottoneUpdate"> <br>
</form>


<%	out.println(altroUser);
  			}
  		}
  	} 
  	%>




<footer><%@ include file="Footer.jsp"%></footer>
</body>



</body>
</html>