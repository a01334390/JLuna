<%-- 
    Document   : clientsorders
    Created on : 21/04/2017, 01:19:09 AM
    Author     : Alex
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="AdvancedElements.OrderClients"%>
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
        <link href="newStyling.css" rel="stylesheet" type="text/css">
        <title>JSP Page</title>
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
                            <li><a href="#" class="whitetxt whitehover">Pedidos</a></li>
                            <li><a href="#" class="whitetxt whitehover">Inventario</a></li>
                            <li><a href="#" class="whitetxt whitehover">Clientes</a></li>
                            <li><a href="#" class="whitetxt whitehover">Materiales</a></li>
                            <li><a href="#" class="whitetxt whitehover">Usuarios</a></li>
                            <li><a href="#" class="whitetxt whitehover">Cuadernos</a></li>
                            <li class="has-submenu whitetxt">
                                <a href="#" class="whitetxt whitehover">Vistas Avanzadas</a>
                                <ul class="submenu menu vertical blackbg" data-submenu>
                                    <li><a href="#" class="whitetxt whitehover">Ordenes por prioridad y fecha</a></li>
                                    <li><a href="#" class="whitetxt whitehover">Ordenes con mas clientes</a></li>
                                    <li><a href="#" class="whitetxt whitehover">Pedidos con mas beneficio</a></li>
                                    <li><a href="#" class="whitetxt whitehover">Asignar materiales</a></li>
                                    <li><a href="#" class="whitetxt whitehover">Macro vista</a></li>
                                </ul>
                            </li>
                        </ul>
                    </div>
                    <div class="top-bar-right">
                    </div>
                </div>
            </div>
        </div>
        <br>
        <br>
        <div class="notebookhd"><h1 class="whitetxt">Ordenamiento de clientes</h1></div>
    </body>
    <div class="form">
    <h3 class="centeredform">Clientes por cantidad de cuadernos pedidos</h3>
        <form action="MacroView">
            <table border="1">
                <thead>
                    <tr class="centeredform whitetxt">
                        <th>id</th>
                        <th>Primer nombre</th>
                        <th>Segundo nombre</th>
                        <th>Status</th>
                        <th>Prioridad</th>
                        <th>Cantidad</th>
                    </tr>
                </thead>
                <tbody>
                    <% OrderClients order= new OrderClients();%>
                    <%String semana[] = order.getMostOrderedNotebooks();%>
                    <%for (int i = 0; i < semana.length; i++) {%>
                    <tr>
                        <%--
                            cortar string date, priority,
                        --%>
                        <% String tabla[]= semana[i].split(", "); %>
                        <td><%=tabla[0] %></td>
                        <td><%=tabla[1] %></td>
                        <td><%=tabla[2] %></td>
                        <td><%=tabla[3] %></td>
                        <td><%=tabla[4] %></td>
                        <td><%=tabla[5] %></td>

                    </tr>
                    <% } %>
                </tbody>
            </table>
                <h3 class="centeredform">Clientes por prioridad</h3>
                <table border="1">
                <thead>
                    <tr class="centeredform whitetxt">
                        <th>id</th>
                        <th>Primer nombre</th>
                        <th>Segundo nombre</th>
                        <th>Cantidad</th>
                        <th>Status</th>
                        <th>Prioridad</th>
                    </tr>
                </thead>
                <tbody>
                    <%String prioridad[] = order.getNotebooksByPriority();%>
                    <%for (int i = 0; i < prioridad.length; i++) {%>
                    <tr>
                        <%--
                            cortar string id, 1nombre, 2nombre, cantidad, status, prioridad
                        --%>
                        <% String tabla[]= prioridad[i].split(", "); %>
                        <td><%=tabla[0] %></td>
                        <td><%=tabla[1] %></td>
                        <td><%=tabla[2] %></td>
                        <td><%=tabla[3] %></td>
                        <td><%=tabla[4] %></td>
                        <td><%=tabla[5] %></td>

                    </tr>
                    <% } %>
                </tbody>
            </table>
            <h3 class="centeredform">Clientes por status</h3>
                <table border="1">
                <thead>
                    <tr class="centeredform whitetxt">
                        <th>id</th>
                        <th>Primer nombre</th>
                        <th>Segundo nombre</th>
                        <th>Cantidad</th>
                        <th>Prioridad</th>
                        <th>Status</th>
                    </tr>
                </thead>
                <tbody>
                    <%String status[] = order.getNotebooksByStatus();%>
                    <%for (int i = 0; i < status.length; i++) {%>
                    <tr>
                        <%--
                            cortar string id, 1nombre, 2nombre, cantidad, status, prioridad
                        --%>
                        <% String tabla[]= status[i].split(", "); %>
                        <td><%=tabla[0] %></td>
                        <td><%=tabla[1] %></td>
                        <td><%=tabla[2] %></td>
                        <td><%=tabla[3] %></td>
                        <td><%=tabla[4] %></td>
                        <td><%=tabla[5] %></td>

                    </tr>
                    <% } %>
                </tbody>
            </table>    
        </form>
</html>
