<%-- 
    Document   : usershow
    Created on : Apr 18, 2017, 3:23:55 PM
    Author     : a01334390
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    if (session.getAttribute("currentSessionName") == null) {
        response.sendRedirect("/index.jsp");
    }
    if (!session.getAttribute("currentPrivilegeLevel").equals("admin")) {
        response.sendRedirect("/index.jsp");
    }
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
    </body>
</html>
