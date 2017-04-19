<%-- 
    Document   : orderHome
    Created on : Apr 18, 2017, 6:28:12 PM
    Author     : a01334390
--%>

<%@page import="BasicElements.Cliente"%>
<%@page import="DatabaseManager.Handler"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8"/>
        <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
        <title>Clientes</title>
        <link rel="stylesheet" href="https://dhbhdrzi4tiry.cloudfront.net/cdn/sites/foundation.min.css">
        <link href="https://cdnjs.cloudflare.com/ajax/libs/foundicons/3.0.0/foundation-icons.css" rel='stylesheet' type='text/css'>
        <link href="customStyling.css" rel="stylesheet" type="text/css">
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
        <form action="Order" method="GET">
            <table border="1">
                <thead>
                    <tr>
                        <th>ID del Cliente</th>
                        <th>Primer Nombre</th>
                        <th>Segundo Nombre</th>
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
                        <td><a href="Order?action=see&userID=<%=clients[i].getId()%>">Ver sus pedidos</a></td>
                    </tr>
                    <% }%>
                </tbody>
            </table>
        </form>
    </body>
</html>