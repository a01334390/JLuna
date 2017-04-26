<%-- 
    Document   : highestbenefit
    Created on : 21/04/2017, 01:32:24 AM
    Author     : Alex
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="AdvancedElements.HighestBenefitCC"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
        <meta charset="utf-8"/>
        <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
        <link rel="stylesheet" href="https://dhbhdrzi4tiry.cloudfront.net/cdn/sites/foundation.min.css">
        <link href="https://cdnjs.cloudflare.com/ajax/libs/foundicons/3.0.0/foundation-icons.css" rel='stylesheet' type='text/css'>
        <link href="customStyling" rel="stylesheet" type="text/css">
        <title>Beneficio alto</title>
    </head>
    <body>
        <h1>Orders with the highest benefit</h1>
    </body>
    <form action="HighestBenefit" method="POST" name="formGetByCalendar" data-abide>
        Fecha uno: <input type="text" value="1990-01-01" name="date1" required><br>
        Fecha dos: <input type="text" value="2200-01-01" name="date2" required>
        <input type="submit" value="Submit" />
    </form>

</html>
