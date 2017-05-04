<%-- 
    Document   : HighestIndex
    Created on : Apr 25, 2017, 1:52:20 PM
    Author     : a01334390
--%>

<%@page import="AdvancedElements.HighestBenefitCC"%>
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
        <title>Productos que generaron más beneficio</title>
         <link href="https://cdnjs.cloudflare.com/ajax/libs/foundicons/3.0.0/foundation-icons.css" rel='stylesheet' type='text/css'>
         <link rel="stylesheet" href="https://dhbhdrzi4tiry.cloudfront.net/cdn/sites/foundation.min.css">
        <link href="AdvancedViews/newStyling.css" rel="stylesheet" type="text/css">
        <link rel="shortcut icon" href="/favicon.ico" type="image/x-icon">
        <link rel="icon" href="/favicon.ico" type="image/x-icon">
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
            <br>
        <br><br>
        <br><br>
        <br>
        <table border="1" align="center">
            <thead>
                <tr class="centeredform whitetxt">
                    <th>Tipo de Cuaderno</th>
                    <th>Beneficio en ventas</th>
                </tr>
            </thead>
            <tbody>
                <%HighestBenefitCC[] order = (HighestBenefitCC[])request.getAttribute("hob");%>
                <% for(int i=0;i<order.length;i++){%>
                <tr>
                    <td><%=order[i].getType()%></td>
                    <td><%=order[i].getMaxBenefit()%></td>
                </tr>
                 <% } %>
            </tbody>
        </table>

    </body>
</html>
