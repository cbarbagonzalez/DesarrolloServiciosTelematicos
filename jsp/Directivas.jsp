<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page errorPage="error.jsp" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<HTML><HEAD><TITLE>Página JSP</TITLE></HEAD>
<P> Contenido dinámico creado por diferentes mecanismos:<UL>
<LI><B>Expresion.</B><BR>
Nombre del servidor: <%= request.getServerName() %>.
<LI><B>Scriptlet.</B><BR>
<% out.println("Datos enviados con la peticion GET: " + request.getQueryString()); %>
<%  int i;  
  if (request.getQueryString()==null) {
    i=0;
}  else
    i=1;
  int valor=100/i;
%>
<LI><B>Declaracion (mas una expresion).
</B><BR>
<%! private int accessCount = 0; %>
Accesos a la pagina: <%= ++accessCount %>
<LI><B>Directiva (mas una expresion).</B>
<BR>
<%@page import = "java.util.*" %>
Fecha actual: <%= new Date() %>
</UL></BODY></HTML>
