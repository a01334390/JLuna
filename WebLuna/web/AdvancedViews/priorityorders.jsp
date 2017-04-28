<%-- 
    Document   : priorityorders
    Created on : 21/04/2017, 01:16:56 AM
    Author     : Alex
--%>

<%@page import="AdvancedElements.OrderOrders"%>
<%@page import="AdvancedElements.OrderClients"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<%
    if (session.getAttribute("currentSessionName") == null) {
        response.sendRedirect("/index.jsp");
    }
    if (!session.getAttribute("currentPrivilegeLevel").equals("admin")) {
        response.sendRedirect("/index.jsp");
    }
%>
    <head>
        <meta charset="utf-8"/>
        <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
        <link rel="stylesheet" href="https://dhbhdrzi4tiry.cloudfront.net/cdn/sites/foundation.min.css">
        <link href="https://cdnjs.cloudflare.com/ajax/libs/foundicons/3.0.0/foundation-icons.css" rel='stylesheet' type='text/css'>
        <link href="newStyling.css" rel="stylesheet" type="text/css">
        <title>Pedidos de prioridad</title>
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
                            <li><a href="#" class="whitetxt whitehover">Ordenes por prioridad y fecha</a></li>
                            <li><a href="#" class="whitetxt whitehover">Ordenes con mas clientes</a></li>
                            <li><a href="#" class="whitetxt whitehover">Pedidos con mas beneficio</a></li>
                            <li><a href="#" class="whitetxt whitehover">Asignar materiales</a></li>
                            <li><a href="#" class="whitetxt whitehover">Macro vista</a></li>
                            <li class="whitetxt"><a href="#" class="whitetxt whitehover">Vistas Basicas</a>
                            </li>
                            </div>
                        <div class="top-bar-right">
                        </div>
                    </div>
                </div>
            </div>
            <br>
            <br>
        <div class="notebookhd"><h1 class="whitetxt">Pedidos de prioridad</h1>
    </body>
    
    <h3 class="centeredform">Pedidos por fecha</h3>
            <div class="formm">
    <form>
    <table border="1">
                <thead>
                    <tr class="centeredform whitetxt">
                        <th>Fecha</th>
                        <th>Prioridad</th>
                        <th>Primer nombre</th>
                        <th>Segundo nombre</th>
                    </tr>
                </thead>
                <tbody>
                    <% OrderOrders order= new OrderOrders();%>
                    <%String semana[] = order.orderDate();%>
                    <%for (int i = 0; i < semana.length; i++) {%>
                    <tr>
                        <%--
                            cortar string date, priority, 1name, 2name
                        --%>
                        <% String tabla[]= semana[i].split(", "); %>
                        <td><%=tabla[0] %></td>
                        <td><%=tabla[1] %></td>
                        <td><%=tabla[2] %></td>
                        <td><%=tabla[3] %></td>

                    </tr>
                    <% } %>
                </tbody>
            </table>
                <h3 class="centeredform">Pedidos por prioridad</h3>
            <table border="1">
                <thead>
                    <tr class="centeredform whitetxt">
                        <th>Fecha</th>
                        <th>Prioridad</th>
                        <th>Primer nombre</th>
                        <th>Segundo nombre</th>
                    </tr>
                </thead>
                <tbody>
                    <%String priority[] = order.orderPriority();%>
                    <%for (int i = 0; i < priority.length; i++) {%>
                    <tr>
                        <%--
                            cortar string date, priority, 1name, 2name
                        --%>
                        <% String tabla[]= priority[i].split(", "); %>
                        <td><%=tabla[0] %></td>
                        <td><%=tabla[1] %></td>
                        <td><%=tabla[2] %></td>
                        <td><%=tabla[3] %></td>

                    </tr>
                    <% } %>
                </tbody>
            </table>    
    </form>
  </div>
</html>
