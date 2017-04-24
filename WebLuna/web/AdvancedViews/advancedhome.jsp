<%-- 
    Document   : advancedhome
    Created on : Apr 18, 2017, 1:02:46 PM
    Author     : a01334390
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
        <title>Vistas Avanzadas</title>
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
        <div class="off-canvas-wrapper">
            <div class="off-canvas-wrapper-inner" data-off-canvas-wrapper>
                <div class="off-canvas position-left reveal-for-large" id="my-info" data-off-canvas data-position="left">
                    <div class="row column">
                        <br>
                        <img class="thumbnail" src="https://placehold.it/550x350">
                        <h5><%=session.getAttribute("currentSessionName")%></h5>
                        <p>Bienvenida a las vistas avanzadas</p>                        
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
                            <p class="lead">Escoge alguna de las vistas avanzadas</p>
                        </div>
                    </div>

                    <div class="row small-up-2 medium-up-3 large-up-4">
                        <div class="column" type="left-rightpadd" type="left-rightpadd">
                            <form action="AdvancedHome"  method='GET'>
                                <input type="image" src="https://placehold.it/300x400" name="action" value="priorityOrders"/>
                            </form>
                            <h5 align="center">Ordenes por prioridad y fecha</h5>
                        </div>
                        <div class="column" type="left-rightpadd" type="left-rightpadd">
                            <form action="AdvancedHome" method='GET'>
                                <input type="image" src="https://placehold.it/300x400" name="action" value="clientsOrders" />
                            </form>
                            <h5 align="center">Clientes con más ordenes</h5>
                        </div>
                        <%if (session.getAttribute("currentPrivilegeLevel").equals("admin") || session.getAttribute("currentPrivilegeLevel").equals("manager")) { %>
                        <div class="column" type="left-rightpadd" type="left-rightpadd">
                            <form action="AdvancedHome" method="GET">
                                <input type="image" src="https://placehold.it/300x400" name="action" value="highestBenefit"/>
                            </form>
                            <h5 align="center">Pedidos con más beneficio</h5>
                        </div>
                        <div class="column" type="left-rightpadd" value="material" type="left-rightpadd">
                            <form action="AdvancedHome" method="GET">
                                <input type="image" src="https://placehold.it/300x400" name="action" value="materialsToNotebooks"/>
                            </form>
                            <h5 align="center">Asignar materiales a cuadernos</h5>
                        </div>
                        <div class="column" type="left-rightpadd" value="macro" type="left-rightpadd">
                            <form action="AdvancedHome" method="GET">
                                <input type="image" src="https://placehold.it/300x400" name="action" value="macro"/>
                            </form>
                            <h5 align="center">Macro Vista</h5>
                        </div>
                        <% } %>                       
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
