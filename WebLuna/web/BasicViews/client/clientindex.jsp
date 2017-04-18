<%-- 
    Document   : clients
    Created on : Apr 18, 2017, 1:02:22 PM
    Author     : a01334390
--%>

<%@page import="BasicElements.Cliente"%>
<%@page import="DatabaseManager.Handler"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    if (session.getAttribute("currentSessionName") == null) {
        response.sendRedirect("/index.jsp");
    }
%>
<html>
    <head>
        <meta charset="utf-8"/>
        <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
        <title>Clientes</title>
        <link rel="stylesheet" href="https://dhbhdrzi4tiry.cloudfront.net/cdn/sites/foundation.min.css">
        <link href="https://cdnjs.cloudflare.com/ajax/libs/foundicons/3.0.0/foundation-icons.css" rel='stylesheet' type='text/css'>
        <link href="customStyling" rel="stylesheet" type="text/css">
    </head>
    <body>
        <script>
            (function (i, s, o, g, r, a, m) {
                i['GoogleAnalyticsObject'] = r;
                i[r] = i[r] || function () {
                    (i[r].q = i[r].q || []).push(arguments)
                }, i[r].l = 1 * new Date();
                a = s.createElement(o),
                        m = s.getElementsByTagName(o)[0];
                a.async = 1;
                a.src = g;
                m.parentNode.insertBefore(a, m)
            })(window, document, 'script', 'https://www.google-analytics.com/analytics.js', 'ga');

            ga('create', 'UA-2195009-2', 'auto');
            ga('send', 'pageview');

            ga('create', 'UA-2195009-27', 'auto', {name: "foundation"});
            ga('foundation.send', 'pageview');

        </script>

                    <h1>Showing available ones</h1>
                    <p><a href="Client?action=edit&insert">Añadir Usuario</a></p>
                    <form action="Client" method="GET">
                        <table border="1">
                            <thead>
                                <tr>
                                    <th>ID del Cliente</th>
                                    <th>Primer Nombre</th>
                                    <th>Segundo Nombre</th>
                                    <th>Direccion</th>
                                    <th>Es cliente fisico</th>
                                    <th>Acciones</th>
                                </tr>
                            </thead>
                            <tbody>
                                <%Cliente[] clients = Handler.getAllClients();%>
                                <%for (int i = 0; i < clients.length; i++) {%>
                                <tr>
                                    <td><%=clients[i].getId()%></td>
                                    <td><%=clients[i].getFirst_name()%></td>
                                    <td><%=clients[i].getSecond_name()%></td>
                                    <td><%=clients[i].getAddress()%></td>
                                    <%if (clients[i].getIsPhysical() == 1) {%>
                                    <td>Si</td>
                                    <% } else {%>
                                    <td>No</td>
                                    <% }%>
                                    <td><a href="Client?action=edit&userID=<%=clients[i].getId()%>">Editar</a> 
                                        <a href="Client?action=erase&userID=<%=clients[i].getId()%>">Eliminar</a> </td>
                                </tr>
                                <% } %>
                            </tbody>
                        </table>
                    </form>
                    </body>
                    </html>
