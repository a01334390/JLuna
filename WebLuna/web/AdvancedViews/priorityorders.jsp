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
    <head>
        <meta charset="utf-8"/>
        <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
        <link rel="stylesheet" href="https://dhbhdrzi4tiry.cloudfront.net/cdn/sites/foundation.min.css">
        <link href="https://cdnjs.cloudflare.com/ajax/libs/foundicons/3.0.0/foundation-icons.css" rel='stylesheet' type='text/css'>
        <link href="customStyling" rel="stylesheet" type="text/css">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Priority orders</h1>
    </body>
    
    <h3>Pedidos por fecha</h3>
    <form>
    <table border="1">
                <thead>
                    <tr>
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
                <h3>Pedidos por prioridad</h3>
            <table border="1">
                <thead>
                    <tr>
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
        
</html>
