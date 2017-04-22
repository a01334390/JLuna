<%-- 
    Document   : macroView
    Created on : Apr 21, 2017, 11:11:00 AM
    Author     : Arpi
--%>

<%@page import="AdvancedElements.MacroView"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="BasicElements.Cliente"%>
<%@page import="DatabaseManager.Handler"%>
<%@page import="java.time.LocalDate"%>
<%@page import="java.time.format.DateTimeFormatter"%>
<!DOCTYPE html>
<html>
    
    <head>
        <meta charset="utf-8"/>
        <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
        <link rel="stylesheet" href="https://dhbhdrzi4tiry.cloudfront.net/cdn/sites/foundation.min.css">
        <link href="https://cdnjs.cloudflare.com/ajax/libs/foundicons/3.0.0/foundation-icons.css" rel='stylesheet' type='text/css'>
        <link href="customStyling" rel="stylesheet" type="text/css">
        <title>Macroview</title>
    </head>
    <body>
        <h1>Welcome to the macroview </h1>
    </body>
    <h3>Entregas de esta semana</h3>
                    <form action="MacroView">
                        <table border="1">
                            <thead>
                                <tr>
                                    <th>Fecha de entrega</th>
                                    <th>Prioridad</th>
                                    <th>Primer nombre</th>
                                    <th>Segundo nombre</th>
                                </tr>
                            </thead>
                            <tbody>
                                <% MacroView macroview= new MacroView();%>
                                <%String semana[] = macroview.setSemana();%>
                                <%for (int i = 0; i < semana.length; i++) {%>
                                <tr>
                                    <%--
                                        cortar string
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
                            <h3>Entregas atrasadas</h3>
                        <table border="1">
                            <thead>
                                <tr>
                                    <th>id</th>
                                    <th>Primer nombre</th>
                                    <th>Segundo nombre</th>
                                    <th>Status</th>
                                </tr>
                            </thead>
                            <tbody>
                                
                                <%String atrasados[] = macroview.setAtrasados();%>
                                <%for (int i = 0; i < atrasados.length; i++) {%>
                                <tr>
                                    <%--
                                        cortar string id-1name-2name-status
                                    --%>
                                    <% String tabla[]= atrasados[i].split(", "); %>
                                    <td><%=tabla[0] %></td>
                                    <td><%=tabla[1] %></td>
                                    <td><%=tabla[2] %></td>
                                    <td><%=tabla[3] %></td>
                                    
                                </tr>
                                <% } %>
                            </tbody>
                        </table> 
                            <h3>Mejores clientes</h3>
                        <table border="1">
                            <thead>
                                <tr>
                                    <th>ID de la orden</th>
                                    <th>Primer nombre</th>
                                    <th>Segundo nombre</th>
                                    <th>Prioridad</th>
                                    <th>cantidad</th>
                                </tr>
                            </thead>
                            <tbody>
                                
                                <%String clientes[] = macroview.setClientes();%>
                                <%for (int i = 0; i < clientes.length; i++) {%>
                                <tr>
                                    <%--
                                        cortar string idorder, 1name, 2name, status, priority, quantity
                                    --%>
                                    <% String tabla[]= clientes[i].split(", "); %>
                                    <td><%=tabla[0] %></td>
                                    <td><%=tabla[1] %></td>
                                    <td><%=tabla[2] %></td>
                                    <td><%=tabla[4] %></td>
                                    <td><%=tabla[5] %></td>
                                </tr>
                                <% } %>
                            </tbody>
                        </table>
                            <h3>Materiales que se estan acabando</h3>
                        <table border="1">
                            <thead>
                                <tr>
                                    <th>Nombre</th>
                                    <th>Cantidad</th>
                                </tr>
                            </thead>
                            <tbody>
                                
                                <%String material[] = macroview.setMaterial();%>
                                <%for (int i = 0; i < material.length; i++) {%>
                                <tr>
                                    <%--
                                        cortar string 1nombre-status-prioridad-cantidad
                                    --%>
                                    <% String tabla[]= material[i].split(", "); %>
                                    <td><%=tabla[0] %></td>
                                    <td><%=tabla[1] %></td>
                                    
                                </tr>
                                <% } %>
                            </tbody>
                        </table> 
                            <h3>Cuadernos que se estan acabando</h3>
                        <table border="1">
                            <thead>
                                <tr>
                                    <th>Nombre</th>
                                    <th>Cantidad</th>
                                </tr>
                            </thead>
                            <tbody>
                                
                                <%String notebook[] = macroview.setNotebook();%>
                                <%for (int i = 0; i < notebook.length; i++) {%>
                                <tr>
                                    <%--
                                        cortar string 1nombre-status-prioridad-cantidad
                                    --%>
                                    <% String tabla[]= notebook[i].split(", "); %>
                                    <td><%=tabla[0] %></td>
                                    <td><%=tabla[1] %></td>
                                    
                                </tr>
                                <% } %>
                            </tbody>
                        </table>
                    </form>
</html>
