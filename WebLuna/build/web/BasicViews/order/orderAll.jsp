<%-- 
    Document   : orderAll
    Created on : Apr 18, 2017, 6:34:48 PM
    Author     : a01334390
--%>

<%@page import="BasicElements.Order"%>
<%@page import="DatabaseManager.Handler"%>
<%@page import="BasicElements.Cliente"%>
<%@page import="BasicElements.OrderNotebooks"%>
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
        <title>Ordenes del cliente</title>
        <link href="customStyling.css" rel="stylesheet" type="text/css">
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
        <%
            Cliente client = (Cliente) request.getAttribute("client");
            Order[] order = Handler.getOrdersFromClient(client.getId());
        %>
        <% if (session.getAttribute("currentPrivilegeLevel").equals("admin") || session.getAttribute("currentPrivilegeLevel").equals("manager")) {%> 
        <a href="Order?action=add&clientID=<%=client.getId()%>">A&#241adir un nuevo pedido</a>
        <%}%>
        <%for (int i = 0; i < order.length; i++) {%>
        <div>
            <div class="travel-feature-card">
                <div class="travel-feature-card-header">
                    <div class="row">
                        <div class="medium-12 columns">
                            <h5 class="travel-feature-card-subtitle">Pedido numero: <%=order[i].getId()%></h5>
                            <div class="travel-feature-card-header-controls">
                                <span><a href="#"><i class="fa fa-edit"></i></a></span>
                                <span><a href="#"><i class="fa fa-remove"></i></a></span>
                            </div>
                        </div>
                    </div>  
                </div>
                <div class="travel-feature-card-details">

                    <h6 class="travel-feature-card-date-range"><p>Fecha de entrega <%=order[i].getDate()%></p></h6>
                    <h6 class="travel-feature-card-date-range"><p>Orden hecha por: <%=client.getFirst_name()%></p></h6>

                    <div class="row">
                        <div class="small-12 medium-9 columns travel-feature-card-content">
                            <div class="row">
                                <div class="small-4 medium-2 columns">
                                    <img class="travel-feature-card-image" src="https://unsplash.it/600/600/?image=1081" alt="">
                                </div>
                                <div class="small-8 medium-10 columns">
                                    <h6 class="travel-feature-card-title">Caracteristicas del pedido</h6>
                                    <%if (order[i].getPriority().equals("HIGH")) {%>
                                    <p>Prioridad del pedido: Alta</p>
                                    <%} else if (order[i].getPriority().equals("MEDIUM")) {%>
                                    <p>Prioridad del pedido: Media</p>
                                    <%} else {%>
                                    <p>Prioridad del pedido: Baja</p>
                                    <% } %>
                                </div>
                                <div class="small-8 medium-10 columns">
                                    <%
                                        OrderNotebooks[] on = Handler.getAllNotebooksFromOrders(order[i].getId());
                                    %>
                                    <div class="product-card">
                                        <div class="product-card-thumbnail">
                                            <a href="ONotebook?action=add&OrderID=<%=order[i].getId()%>&clientID=<%=client.getId()%>"><img src="http://placehold.it/180x180"/></a>
                                        </div>
                                        <h2 class="product-card-title"><a href="ONotebook?action=add&OrderID=<%=order[i].getId()%>&clientID=<%=client.getId()%>">A&#241adir set de cuadernos</a></h2>
                                        <div class="product-card-colors">

                                        </div>
                                    </div>
                                    <%if (on != null) {
                                            for (int x = 0; x < on.length; x++) {%>
                                    <div class="product-card">
                                        <div class="product-card-thumbnail">
                                            <a href="#"><img src="http://placehold.it/180x180"/></a>
                                        </div>
                                        <h2 class="product-card-title"><a href="#"><%=Handler.searchNotebookByID(on[x].getId_Notebook()).getType()%></a></h2>
                                        <p><span class="product-card-desc">Status: <%=on[x].getStatus()%></span></p>
                                        <p><span class="product-card-price">Cantidad:<%=on[x].getQuantity()%></span></p>
                                        <div class="product-card-colors">
                                            <p>Liston: <%=on[x].getRibbon()%></p>
                                            <p>Elastico: <%=on[x].getElastic()%></p>
                                            <p>Imagen: <%=on[x].getImage()%></p>
                                            <p>Tipo de Hojas: <%=on[x].getPageType()%></p>
                                            <% if (session.getAttribute("currentPrivilegeLevel").equals("admin") || session.getAttribute("currentPrivilegeLevel").equals("manager")){%>
                                            <a href="ONotebook?action=delete&OrderID=<%=order[i].getId()%>&NotebookID=<%=on[x].getId_Notebook()%>&clientID=<%=client.getId()%>">Eliminar</a>
                                            <% } %>
                                            <a href="ONotebook?action=edit&OrderID=<%=order[i].getId()%>&NotebookID=<%=on[x].getId_Notebook()%>&clientID=<%=client.getId()%>">Editar</a>
                                        </div>
                                    </div>
                                    <%}
                                        }%>
                                </div>
                            </div> 
                        </div>

                        <div class="small-12 medium-3 columns travel-feature-card-price">
                            <h6>Acciones</h6>
                            <% if (session.getAttribute("currentPrivilegeLevel").equals("admin") || session.getAttribute("currentPrivilegeLevel").equals("manager")){%>
                            <a href="Order?action=delete&OrderID=<%=order[i].getId()%>&clientID=<%=client.getId()%>">Eliminar</a>
                            <% } %>
                            <a href="Order?action=edit&OrderID=<%=order[i].getId()%>&clientID=<%=client.getId()%>">Editar la orden
                        </div>
                    </div> 
                </div>
            </div>
        </div>
        <%}%>
    </body>
</html>
