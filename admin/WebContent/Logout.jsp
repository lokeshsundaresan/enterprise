<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

</head>
<body>

<% if((session.getAttribute("user"))!=null)
   {
    
   	session.removeAttribute("user");
    response.sendRedirect("admin.html");
   	}
    else{
    	session.removeAttribute("user");
   		response.sendRedirect("admin.html");
    }%>
</body>
</html>