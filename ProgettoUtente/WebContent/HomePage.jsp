<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">






}
.active:hover {
	background-color: green;
}

h1{
font-family: 'Open Sans', arial, sans-serif;
font-weight: bold;
color: 	#black;

}
h2,h5 {
font-family: 'Open Sans', arial, sans-serif;
font-weight: bold;
color:	black;

}

p {
font-family: 'Open Sans', arial, sans-serif;
font-weight: bold;
color:black;

}

aside {

float: right;
width:25%;
margin: 0 1.5%;
 
}


</style>

<meta charset="ISO-8859-1">
<title>HomePage</title>
</head>
<body>
<header><%@ include file="Header.jsp"%></header>

<aside>

<h1><b>Benvenuto <% String usern = (String)session.getAttribute("username");
if(usern!=null){
out.println(usern);}%>!</b></h1>



<h2><b>Effettua il Login:</b> </h2>

 




<p> <% String risposta1 = (String)session.getAttribute("errore");
if ((risposta1!=null)&& (!(session.isNew()))){
out.println (risposta1);
}%>
</p>



<form action ="LoginServlet" method="POST">
  <b>Username: </b> <input placeholder ="username" type = "text" name="username_inserito"><br>
  <b>Password: </b> <input placeholder ="password" type = "password" name="password_inserita"> 
  <input  type="submit" value="Invia" name ="bottone">
</form>

 <p> <% String delete = (String) session.getAttribute("delete");
if((delete!=null)){
out.println (delete);
}%>
</p>
<b>Non ti sei ancora registrato?</b> <a href= "Registrazione.jsp"> Clicca qui! </a> 


</aside>


<footer><%@ include file="Footer.jsp"%></footer>
</body>

</html>