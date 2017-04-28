<%-- 
    Document   : materialstonotebooks
    Created on : 21/04/2017, 01:37:12 AM
    Author     : Alex
--%>

<%@page import="BasicElements.NotebookMaterial"%>
<%@page import="DatabaseManager.Handler"%>
<%@page import="BasicElements.Notebook"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<%
    if (session.getAttribute("currentSessionName") == null) {
        response.sendRedirect("/index.jsp");
    }
    if (!session.getAttribute("currentPrivilegeLevel").equals("admin")) {
        response.sendRedirect("/index.jsp");
    }
%>
<head>
    <meta charset="utf-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <title>Cuadernos</title>
    <link rel="stylesheet" href="https://dhbhdrzi4tiry.cloudfront.net/cdn/sites/foundation.min.css">
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.css" rel="stylesheet">
    <link href="newstyling.css" rel="stylesheet" type="text/css">
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
    <div class="notebookhd"><h1 class="whitetxt">Cuadernos</h1></div>
    <br>
    <div class="formm">
        <form action="MTNotebook" method="GET">
            <table border="1">
                <thead>
                    <tr class="centeredform whitetxt">
                        <th>ID</th>
                        <th>Tiempo de produccion</th>
                        <th>Tipo de Cuaderno</th>
                        <th>Beneficio economico</th>
                        <th>Materiales Relacionados</th>
                        <th>Acciones</th>
                    </tr>
                </thead>
                <tbody>
                    <%
                        Notebook[] nb = Handler.getAllNotebooks();
                        for (int i = 0; i < nb.length; i++) {
                    %>
                    <tr class="centeredform">
                        <td><%=nb[i].getId()%></td>
                        <td><%=nb[i].getAverage_time()%></td>
                        <td><%=nb[i].getType()%></td>
                        <td><%=nb[i].getBenefit()%></td>
                        <td>
                            <%
                                NotebookMaterial[] nm = Handler.getMaterialsofNotebook(nb[i].getId());
                            %>
                            <% if(nm!=null){
                                for (int x = 0; x < nm.length; x++) {%>
                            <%=Handler.getMaterialName(nm[x].getMaterial_id())%>
                             <a href="MTNotebook?action=edit&notebookID=<%=nb[i].getId()%>&materialID=<%=nm[x].getMaterial_id()%>"><i class="fa fa-pencil nonblue"></i></a>
                             <a href="MTNotebook?action=delete&notebookID=<%=nb[i].getId()%>&materialID=<%=nm[x].getMaterial_id()%>"><i class="fa fa-trash nonblue"></i></a><br>
                             <%}}%>
                        </td>
                        <td>
                            <a href="MTNotebook?action=add&notebookID=<%=nb[i].getId()%>"><i class="fa fa-plus adduser"></i></a>
                        </td>
                    </tr>
                    <%}%>
                </tbody>
            </table>
        </form>
    </div>
</body>
</html>
