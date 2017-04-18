<%-- 
    Document   : home
    Created on : Apr 17, 2017, 6:29:27 PM
    Author     : a01334390
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    if (session.getAttribute("currentSessionName") == null) {
        response.sendRedirect("/index.jsp");
    }
%>
<html class="no-js" lang="en">
    <head>
        <meta charset="utf-8"/>
        <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
        <title>Bienvenid@ <%=session.getAttribute("currentSessionName")%></title>
        <link rel="stylesheet" href="https://dhbhdrzi4tiry.cloudfront.net/cdn/sites/foundation.min.css">
        <link href="https://cdnjs.cloudflare.com/ajax/libs/foundicons/3.0.0/foundation-icons.css" rel='stylesheet' type='text/css'>

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
        <div class="off-canvas-wrapper">
            <div class="off-canvas-wrapper-inner" data-off-canvas-wrapper>
                <div class="off-canvas position-left reveal-for-large" id="my-info" data-off-canvas data-position="left">
                    <div class="row column">
                        <br>
                        <img class="thumbnail" src="https://placehold.it/550x350">
                        <h5><%=session.getAttribute("currentSessionName")%></h5>
                        <p>Bienvenida a la base de datos</p>
                    </div>
                </div>
                <div class="off-canvas-content" data-off-canvas-content>
                    <div class="title-bar hide-for-large">
                        <div class="title-bar-left">
                            <button class="menu-icon" type="button" data-open="my-info"></button>
                            <span class="title-bar-title"><%=session.getAttribute("currentSessionName")%></span>
                        </div>
                    </div>
                    <div class="callout primary">
                        <div class="row column" >
                            <h1><%=session.getAttribute("currentSessionName")%></h1>
                            <p class="lead">Escoge alguna de las siguientes opciones disponibles para ti</p>
                        </div>
                    </div>

                    <div class="row small-up-2 medium-up-3 large-up-4">
                        <div class="column" type="left-rightpadd" >
                            <form action="login"  method="GET">
                                <input type="image" src="https://placehold.it/300x400" name="action" value="order"/>
                            </form>
                            <h5 align="center">Ordenes</h5>
                        </div>
                        <div class="column" type="left-rightpadd">
                            <form action="login" method="GET">
                                <input type="image" src="https://placehold.it/300x400" name="action" value="inventory" />
                            </form>
                            <h5 align="center">Inventario</h5>
                        </div>
                        <%if (session.getAttribute("currentPrivilegeLevel").equals("admin") || session.getAttribute("currentPrivilegeLevel").equals("manager")) { %>
                        <div class="column" type="left-rightpadd">
                            <form action="login" method="GET">
                                <input type="image" src="https://placehold.it/300x400" name="action" value="client"/>
                            </form>
                            <h5 align="center">Clientes</h5>
                        </div>
                        <div class="column" type="left-rightpadd" value="material">
                            <form action="login" method="GET">
                                <input type="image" src="https://placehold.it/300x400" name="action" value="material"/>
                            </form>
                            <h5 align="center">Materiales</h5>
                        </div>
                        <% } %>
                        <%if (session.getAttribute("currentPrivilegeLevel").equals("admin")) {%>
                        <div class="column" type="left-rightpadd" value="user">
                            <form action="login" method="GET">
                                <input type="image" src="https://placehold.it/300x400" name="action" value="user"/>
                            </form>
                            <h5 align="center">Usuarios</h5>
                        </div>
                        <div class="column" type="left-rightpadd" value="advanced">
                            <form action="login" method="GET">
                                <input type="image" src="https://placehold.it/300x400" name="action" value="advanced"/>
                            </form>
                            <h5 align="center">Vistas Avanzadas</h5>
                        </div>
                        <div class="column" type="left-rightpadd">
                            <form action="login"   method="GET">
                                <input type="image" src="https://placehold.it/300x400" name="action" value="notebook"/>
                            </form>
                            <h5 align="center">Cuadernos</h5>
                        </div>
                        <% }%>
                    </div>
                </div>
            </div>
        </div>               
        <script src="https://code.jquery.com/jquery-2.1.4.min.js"></script>
        <script src="https://dhbhdrzi4tiry.cloudfront.net/cdn/sites/foundation.js"></script>
        <script>
            $(document).foundation();
        </script>
        <script type="text/javascript" src="https://intercom.zurb.com/scripts/zcom.js"></script>
    </body>
</html>
