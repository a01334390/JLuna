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
        <link href="customStyling" rel="stylesheet" type="text/css">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Ordenamiento de clietnes</h1>
    </body>
    
    <h3>Clientes por cantidad de cuadernos pedidos</h3>
        <form action="MacroView">
            <table border="1">
                <thead>
                    <tr>
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
                <h3>Clientes por prioridad</h3>
                <table border="1">
                <thead>
                    <tr>
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
            <h3>Clientes por stauts</h3>
                <table border="1">
                <thead>
                    <tr>
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
