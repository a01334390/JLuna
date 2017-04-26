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
        <link href="clientStyling.css" rel="stylesheet" type="text/css">
    </head>
    <body>
        <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.css" rel="stylesheet">
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

        <br>
        <br>
        <div class="notebookhd"><h1>clientes</h1></div>
        <br>
        <p class="centeredform"><a href="Client?action=add" class="nonblue"><i class="fa fa-plus adduser"></i>Añadir Cliente</a></p>

        <div class="formm">
            <form action="Client" method="GET">
                <table border="1">
                    <thead>
                        <tr>
                            <th class="centeredform">ID del Cliente</th>
                            <th class="centeredform">Primer Nombre</th>
                            <th class="centeredform">Segundo Nombre</th>
                            <th class="centeredform">Direccion</th>
                            <th class="centeredform">Es cliente fisico</th>
                            <th class="centeredform">Correo Electronico</th>
                            <th class="centeredform">Acciones</th>
                        </tr>
                    </thead>
                    <tbody>
                        <%Cliente[] clients = Handler.getAllClients();%>
                        <%for (int i = 0; i < clients.length; i++) {%>
                        <tr>
                            <td class="centeredform"><%=clients[i].getId()%></td>
                            <td class="centeredform"><%=clients[i].getFirst_name()%></td>
                            <td class="centeredform"><%=clients[i].getSecond_name()%></td>
                            <td><%=clients[i].getAddress()%></td>
                            <%if (clients[i].getIsPhysical() == 1) {%>
                            <td class="centeredform">Si</td>
                            <% } else {%>
                            <td class="centeredform">No</td>
                            <% }%>
                            <td><%=clients[i].getEmail()%></td>
                            <td class="centeredform"><a href="Client?action=edit&userID=<%=clients[i].getId()%>"><i class="fa fa-pencil nonblue"></i></a>  
                                    <% if (session.getAttribute("currentPrivilegeLevel").equals("admin")) {%>
                                <a href="Client?action=erase&userID=<%=clients[i].getId()%>"><i class="fa fa-trash nonblue"></i></a> </td>
                                    <%}%>
                        </tr>
                        <% }%>
                    </tbody>
                </table>
            </form>
        </div>
    </body>
</html>
