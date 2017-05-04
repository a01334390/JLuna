<%-- 
    Document   : materialindex
    Created on : 20/04/2017, 08:34:36 PM
    Author     : Alex
--%>

<%@page import="BasicElements.Material"%>
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
        <title>Material</title>
        <link rel="stylesheet" href="https://dhbhdrzi4tiry.cloudfront.net/cdn/sites/foundation.min.css">
        <link href="https://cdnjs.cloudflare.com/ajax/libs/foundicons/3.0.0/foundation-icons.css" rel='stylesheet' type='text/css'>
        <link href="BasicViews/material/materialStyling.css" rel="stylesheet" type="text/css">
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
                            <li><a href="http://localhost:8080/WebLuna/login?action.x=157&action.y=242&action=order" class="whitetxt whitehover">Pedidos</a></li>
                            <li><a href="http://localhost:8080/WebLuna/login?action.x=157&action.y=192&action=inventory" class="whitetxt whitehover">Inventario</a></li>
                            <li><a href="http://localhost:8080/WebLuna/login?action.x=174&action.y=233&action=client" class="whitetxt whitehover">Clientes</a></li>
                            <li><a href="http://localhost:8080/WebLuna/login?action.x=64&action.y=249&action=material" class="whitetxt whitehover">Materiales</a></li>
                            <li><a href="http://localhost:8080/WebLuna/login?action.x=173&action.y=143&action=user" class="whitetxt whitehover">Usuarios</a></li>
                            <li><a href="http://localhost:8080/WebLuna/login?action.x=160&action.y=140&action=notebook" class="whitetxt whitehover">Cuadernos</a></li>
                            <li><a href="http://localhost:8080/WebLuna/login?action.x=17&action.y=129&action=advanced" class="whitetxt whitehover">Vistas Avanzadas</a></li>
                        </ul>
                    </div>
                    <div class="top-bar-right">
                        <ul class="dropdown menu blackbg" data-dropdown-menu>
                            <li><a href="#" class="whitetxt whitehover">Logout</a></li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>        <br>
        <br>
        <div class="notebookhd"><h1 class="whitetxt">material</h1></div>
        <br>
        <p class="centeredform"><a href="Material?action=add" class="nonblue"><i class="fa fa-plus adduser"></i>Agregar Material</a></p>
        <div class="formm">
        <form action="Material" method='GET'>
            <table border="1">
                <thead>
                    <tr class="centeredform whitetxt">
                        <th>ID</th>                    
                        <th>Nombre</th>
                        <th>Costo</th>
                        <th>Cantidad</th> 
                        <th>Acciones</th>
                    </tr>                    
                </thead>
                <tbody>
                    <% 
                        Material [] material = Handler.getAllMaterials();
                        for (int i = 0; i < material.length; i++){                           
                    %>
                    <tr class="centeredform">
                        <td><%=material[i].getId()%></td>
                        <td><%=material[i].getName()%></td>
                        <td><%=material[i].getCost()%></td>
                        <td><%=material[i].getQuantity()%></td>
                        <td>
                            
                            <a href="Material?action=edit&materialID=<%=material[i].getId()%>"><i class="fa fa-pencil nonblue"></i></a>
                            <%if (session.getAttribute("currentPrivilegeLevel").equals("admin") || session.getAttribute("currentPrivilegeLevel").equals("manager")) { %>
                            <a href="Material?action=erase&materialID=<%=material[i].getId()%>"><i class="fa fa-trash nonblue"></i></a>
                            <% } %>
                        </td>
                    </tr>
                    <%}%>
                </tbody>
            </table>
        </form>
        </div>
    </body>
</html>
