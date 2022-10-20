<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Página JSP</title>
    </head>
    <body>
        <h1>Página JSP con expresiones!</h1>
        <b>-Ruta:</b> <%= request. getContextPath() %>
        <br>
        <b>Método HTTP:</b>  <%= request.getMethod() %>
        <br>
        <b>Fecha actual: </b><%= new java.util.Date() %>
    </body>
</html>