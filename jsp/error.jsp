<%@ page import="java.io.PrintWriter"%>
<%@ page isErrorPage="true"%>
<!DOCTYPE html>
<html>
    <head><title>JSP Page</title>
    </head>
<body>
Ha ocurrido un error:<br/>
<i><%= exception %></i><br/>
El problema se encuentra en:<br/>
<pre>
<% exception.printStackTrace( new PrintWriter( out ) ); %>
</pre>
</body>
</html>