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
        <link href="BasicViews/order/orderStyling.css" rel="stylesheet" type="text/css">
        <link href="BasicViews/order/oaStyling.css" rel="stylesheet" type="text/css">
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
        <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.css" rel="stylesheet">
         <div class="notebookhd"><h1 class="whitetxt">Client orders</h1></div>
        <br>
        <%
            Cliente client = (Cliente) request.getAttribute("client");
            Order[] order = Handler.getOrdersFromClient(client.getId());
        %>
        <% if (session.getAttribute("currentPrivilegeLevel").equals("admin") || session.getAttribute("currentPrivilegeLevel").equals("manager")) {%> 
        <div class="addpedido"><a class="addpedido" href="Order?action=add&clientID=<%=client.getId()%>">A&#241adir un nuevo pedido</a></div>
        <%}%>
        <%for (int i = 0; i < order.length; i++) {%>
        <br>
        <div class="formm">
            <table border="1">
                <thead>
                <tr class="centeredform">
                        <th class="whitetxt">Pedido</th>
                        <th class="whitetxt">Cliente</th>
                        <th class="whitetxt">Fecha de entrega</th>
                        <th class="whitetxt">Prioridad</th>
                        <th class="whitetxt">Acciones</th>
                    </tr>
                </thead>
                <tbody>
                    <tr class="centeredform">
                        <td><%=order[i].getId()%></td>
                        <td><%=client.getFirst_name()%></td>
                        <td><%=order[i].getDate()%></td>
                        <td><%if (order[i].getPriority().equals("HIGH")) {%>
                                    <p>Alta</p>
                                    <%} else if (order[i].getPriority().equals("MEDIUM")) {%>
                                    <p>Media</p>
                                    <%} else {%>
                                    <p>Baja</p>
                                    <% } %></td>
                        <td><a href="Order?action=edit&OrderID=<%=order[i].getId()%>&clientID=<%=client.getId()%>"><i class="fa fa-pencil nonblue"></i></a> 
                            <a href="Order?action=delete&OrderID=<%=order[i].getId()%>&clientID=<%=client.getId()%>"><i class="fa fa-trash nonblue"></i></a>
                        </td>
                    </tr>
                </tbody>
              </table>
        </div>
        <div> 
            <h2 class="product-card-title centeredform"><a id="addcuad" href="ONotebook?action=add&OrderID=<%=order[i].getId()%>&clientID=<%=client.getId()%>">A&#241adir set de cuadernos</a></h2>
        </div>
        <br>
        <div>
            <div class="centeredform">
                                    <%
                                        OrderNotebooks[] on = Handler.getAllNotebooksFromOrders(order[i].getId());
                                    %>
                                    <%if (on != null) {
                                            for (int x = 0; x < on.length; x++) {%>
                                            <div class="centeredform">
                                                <span id="notebooktype" class="centeredform"><%=Handler.searchNotebookByID(on[x].getId_Notebook()).getType()%></span>
                                                <table>
                                                    <tr class="whitetxt centeredform">
                                                      <th>Status</th>
                                                      <th>Cantidad</th>
                                                      <th>Liston</th>
                                                      <th>Elastico</th>
                                                      <th>Imagen</th>
                                                      <th>Hojas</th>
                                                      <th>Acciones</th>
                                                    </tr>
                                                    <tr class="centeredform">
                                                      <td><%=on[x].getStatus()%></td>
                                                      <td><%=on[x].getQuantity()%></td>
                                                      <td><%=on[x].getRibbon()%></td>
                                                      <td><%=on[x].getElastic()%></td>
                                                      <td><%=on[x].getImage()%></td>
                                                      <td><%=on[x].getPageType()%></td>
                                                      <td>  <% if (session.getAttribute("currentPrivilegeLevel").equals("admin") || session.getAttribute("currentPrivilegeLevel").equals("manager")){%>
                                            <a href="ONotebook?action=edit&OrderID=<%=order[i].getId()%>&NotebookID=<%=on[x].getId_Notebook()%>&clientID=<%=client.getId()%>"><i class="fa fa-pencil nonblue"></i></a>
                                            <% } %>
                                            <a href="ONotebook?action=delete&OrderID=<%=order[i].getId()%>&NotebookID=<%=on[x].getId_Notebook()%>&clientID=<%=client.getId()%>"><i class="fa fa-trash nonblue"></i></a>
                                            </tr>
                                                </table>
                                            <br><br>
                                            </div>
                                    </div>
                                    <%}
                                        }%>
                                </div>
                            </div>
        <%}%>
    </body>
</html>
