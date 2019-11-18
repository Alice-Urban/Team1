<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<style>
ul {
	list-style-type: none;
	margin: 0;
	padding: 0;
	overflow: hidden;
	background-color: grey;
	
}

li  {
	float: left;
	border-right: 1px solid #bbb;
	color: white;
	text-align: right;
}

li:last-child {
	border-right: none;
}

li a {
	display: block;
	color: white;
	text-align: center;
	padding: 14px 16px;
	text-decoration: none;
}

li


 


a
:hover




:not


 


(
.active


 


)
{
background-color:
green;





}
.active:hover {
	background-color: green;
}





</style>
</head>

<title>Navigazione</title>
</head>

<body>

	<nav>

		<ul>

			<li><a class="active" href="HomePage.jsp">HomePage</a></li>
			<li><a class ="active" href="Registrazione.jsp">Registrazione</a></li>
			<li><a class="active" href="Benvenuto.jsp">Login</a></li>
			
			 
			
			
			
			
			
			
			
 			<li><% String admin = (String)session.getAttribute("username");
    String passwordAdmin = (String)session.getAttribute("password");
    if (admin != null){
        if (admin.equalsIgnoreCase("admin")) {
        	if (passwordAdmin.equalsIgnoreCase("admin123")) { %>
        		 <a class= "active" href="Lista">Lista</a>
			<% } 
        	}
        
    }%> 
 
</li>

			
		  
			 <li style="float:right"  >Area personale    <br>

			<% String username =(String)session.getAttribute("username");
	        if (username!=null) 
            out.println (username);%></li>
            
  <li><%String user = (String)session.getAttribute("username");
       if (user != null){ %>
      
        <a  href="Logout.jsp">Logout</a> 
      <% }%> 

		</ul>




	</nav>

</body>
</html>