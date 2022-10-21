<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="bean.BeanHola" %>
    
<!DOCTYPE html>
<jsp:useBean id="Hola" class="bean.BeanHola">
  <jsp:setProperty name="Hola" property="*" />
</jsp:useBean>

<HTML><HEAD><TITLE>Tercer ejemplo JSP</TITLE>
<CENTER><table BORDER=5 BGCOLOR="#EF8429"><TR><TH CLASS="TITLE">JSP y Beans</table>
</CENTER>
<H1>
Voy a saludar: <jsp:getProperty name="Hola" property="name" />
</H1>
</BODY>
</HTML>