<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Hello User</title>
</head>
<body>
<h2>Hola, 
<%= request.getParameter("userName") %> !</h2>
<b>Tu nombre escrito 3 veces:</b><br>
<%
String name = request.getParameter("userName");
for (int i=0; i<3; i++) {   %>
 Repetición:<%= i %> Nombre:<%= name %> <br>
<%}
%>


</body>
</html>