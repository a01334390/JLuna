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
        <link rel="stylesheet" href="https://dhbhdrzi4tiry.cloudfront.net/cdn/sites/foundation.min.css" type="text/css">
        <link href="https://cdnjs.cloudflare.com/ajax/libs/foundicons/3.0.0/foundation-icons.css" rel='stylesheet' type='text/css'>
        <link href="AdvancedViews/newStyling.css" rel="stylesheet" type="text/css">
        <link rel="shortcut icon" href="/favicon.ico" type="image/x-icon">
        <link rel="icon" href="/favicon.ico" type="image/x-icon">
        <title>Beneficio alto</title>
    </head>
    <body>
        <script src="js/vendor/jquery.js"></script>
        <script src="js/vendor/what-input.js"></script>
        <script src="js/vendor/foundation.js"></script>
        <script src="js/app.js"></script>
        <div class="top-bar-container" data-sticky-container>
            <div class="sticky sticky-topbar" data-sticky data-options="anchor: page; marginTop: 0; stickyOn: small;">
                <div class="top-bar blackbg">
                    <div class="top-bar-left">
                        <ul class="dropdown menu blackbg" data-dropdown-menu>
                            <li class="menu-text whitetxt"><%=session.getAttribute("currentSessionName")%></li>
                            <li><a href="http://localhost:8080/WebLuna/AdvancedHome?action.x=139&action.y=71&action=priorityOrders" class="whitetxt whitehover">Ordenes por prioridad y fecha</a></li>
                            <li><a href="http://localhost:8080/WebLuna/AdvancedHome?action.x=120&action.y=92&action=clientsOrders" class="whitetxt whitehover">Ordenes con mas clientes</a></li>
                            <li><a href="http://localhost:8080/WebLuna/AdvancedHome?action.x=101&action.y=74&action=highestBenefit" class="whitetxt whitehover">Pedidos con mas beneficio</a></li>
                            <li><a href="http://localhost:8080/WebLuna/AdvancedHome?action.x=175&action.y=176&action=materialsToNotebooks" class="whitetxt whitehover">Asignar materiales</a></li>
                            <li><a href="http://localhost:8080/WebLuna/AdvancedHome?action.x=164&action.y=27&action=macro" class="whitetxt whitehover">Macro vista</a></li>
                            <li class="whitetxt"><a href="http://localhost:8080/WebLuna/home.jsp" class="whitetxt whitehover">Vistas Basicas</a>
                            </li>
                            </div>
                        <div class="top-bar-right">
                            <ul class="dropdown menu blackbg" data-dropdown-menu>
                                <li><a href="#" class="whitetxt whitehover">Logout</a></li>
                            </ul>
                        </div>
                    </div>
                </div>
            </div>
            <br>
            <br>
            <div class="notebookhd"><h1 class="whitetxt">Ordenes con el mayor beneficio</h1></div>
    </body>
    <br>
    <div align="center">
    <form action="HighestBenefit" method="POST" name="formGetByCalendar" data-abide>
        Fecha uno: <input type="text" value="1990-01-01" name="date1" required><br>
        Fecha dos: <input type="text" value="2200-01-01" name="date2" required>
        <input type="submit" value="Submit" />
    </form>
    </div>

</html>
