<%-- 
    Document   : orderHome
    Created on : Apr 18, 2017, 6:28:12 PM
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
        <link href="BasicViews/order/orderStyling.css" rel="stylesheet" type="text/css">
        <link rel="stylesheet" href="https://dhbhdrzi4tiry.cloudfront.net/cdn/sites/foundation.min.css">
        <link href="https://cdnjs.cloudflare.com/ajax/libs/foundicons/3.0.0/foundation-icons.css" rel='stylesheet' type='text/css'>
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
        <div class="notebookhd"><h1 class="whitetxt">orders</h1></div>
        <br>
        <div class="formm">
        <form action="Order" method="GET">
            <table border="1">
                <thead>
                    <tr class="whitetxt">
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
                        <td><a href="Order?action=see&userID=<%=clients[i].getId()%>" class="nonblue"><i class="fa fa-eye"></i>Ver sus pedidos</a></td>
                    </tr>
                    <% }%>
                </tbody>
            </table>
        </form>
        </div>
    </body>
</html>