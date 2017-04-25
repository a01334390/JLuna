<%-- 
    Document   : home
    Created on : Apr 17, 2017, 6:29:27 PM
    Author     : a01334390
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="DatabaseManager.Handler"%>
<%@page import="BasicElements.Material"%>
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
        <link href="customStyling.css" rel="stylesheet" type="text/css">
        <link href="homeStyle.css" rel="stylesheet" type="text/css">
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
                    <div class="row column offcanvas">
                        <br>
                        <img class="thumbnail" src="images/LunaLogo.png">
                        <h5 class="whitetxt"><%=session.getAttribute("currentSessionName")%></h5>
                        <p class="whitetxt">Bienvenida a la base de datos</p>
                        <%
                            Material [] material = Handler.getShortageOfMaterial();
                        %>
                        <% if (material.length > 0 ){%>
                        <h5 class="whitetxt"><strong>Hay escasez de los siguientes materiales:</strong></h5>
                            <% for (int i = 0; i < material.length; i++){%>
                                <p class="whitetxt"><%=material[i].getQuantity()+" "+material[i].getName()%></p>
                            <%}%>
                        <%}%>
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
                            <h1 class="whitetxt"><%=session.getAttribute("currentSessionName")%></h1>
                            <p class="lead whitetxt">Escoge alguna de las siguientes opciones disponibles para ti</p>
                        </div>
                    </div>

                    <div class="row small-up-2 medium-up-3 large-up-4">
                        <div class="column">
                            <form action="login"  method="GET">
                                <input type="image" class="thumbnail" src="images/RHpedidos.png" name="action" value="order"/>
                            </form>
                        </div>
                        <div class="column" type="left-rightpadd" type="left-rightpadd">
                            <form action="login" method="GET">
                                <input type="image"  class="thumbnail"  src="images/RHinventario.png" name="action" value="inventory" />
                            </form>
                        </div>
                        <%if (session.getAttribute("currentPrivilegeLevel").equals("admin") || session.getAttribute("currentPrivilegeLevel").equals("manager")) { %>
                        <div class="column" type="left-rightpadd" type="left-rightpadd">
                            <form action="login" method="GET">
                                <input type="image" class="thumbnail" src="images/RHclientes.png" name="action" value="client"/>
                            </form>
                        </div>
                        <div class="column" type="left-rightpadd" value="material" type="left-rightpadd">
                            <form action="login" method="GET">
                                <input type="image" class="thumbnail" src="images/RHmateriales.png" name="action" value="material"/>
                            </form>
                        </div>
                        <% } %>
                        <%if (session.getAttribute("currentPrivilegeLevel").equals("admin")) {%>
                        <div class="column" type="left-rightpadd" value="user" type="left-rightpadd">
                            <form action="login" method="GET">
                                <input type="image" class="thumbnail" src="images/RHusuarios.png" name="action" value="user"/>
                            </form>
                        </div>
                        <div class="column" type="left-rightpadd" type="left-rightpadd">
                            <form action="login"   method="GET">
                                <input type="image" class="thumbnail" src="images/RHcuadernos.png" name="action" value="notebook"/>
                            </form>
                        </div>
                        <div class="column" type="left-rightpadd" value="advanced" type="left-rightpadd">
                            <form action="login" method="GET">
                                <input type="image" class="thumbnail" src="images/RHavanzadas.png" name="action" value="advanced"/>
                            </form>
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
        <footer>
           
        </footer>
    </body>
</html>