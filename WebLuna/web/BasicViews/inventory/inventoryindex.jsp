<%-- 
    Document   : inventarioindex
    Created on : 20/04/2017, 11:04:40 PM
    Author     : Alex
--%>

<%@page import="BasicElements.Notebook"%>
<%@page import="BasicElements.Inventory"%>
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
        <title>Inventario</title>
        <link rel="stylesheet" href="https://dhbhdrzi4tiry.cloudfront.net/cdn/sites/foundation.min.css">
        <link href="https://cdnjs.cloudflare.com/ajax/libs/foundicons/3.0.0/foundation-icons.css" rel='stylesheet' type='text/css'>
        <link href="inventoryStyling.css" rel="stylesheet" type="text/css">
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
        <div class="notebookhd"><h1>inventario</h1></div>
        <br>
        <br>
        <div class="formm">
        <form action="Inventory" method='GET'>
            <table border="1">
                <thead>
                    <tr>
                        <th class="centeredform">ID</th>                    
                        <th class="centeredform">Nombre</th>
                        <th class="centeredform">Cantidad</th>
                        <th class="centeredform">Acciones</th>
                    </tr>                    
                </thead>
                <tbody>
                    <% 
                        Notebook [] nb = Handler.getAllNotebooks();
                        Inventory [] inventory = new Inventory [nb.length];
                        for(int i = 0; i < nb.length; i++){
                            inventory[i] = Handler.getInventoryByNotebookID(nb[i].getId());
                        }
                        for(int i = 0; i < nb.length; i++){
                    %>
                    <tr class="centeredform">
                        <td><%=nb[i].getId()%></td>
                        <td><%=nb[i].getType()%></td>
                        <td><%=inventory[i].getAmmount()%></td>
                        <td>
                            <a href="Inventory?action=edit&id_Notebook=<%=inventory[i].getId_Notebook()%>" class="nonblue"> <i class="fa fa-edit "></i>Editar</a>                             
                        </td>
                    </tr>
                    <%}%>
                </tbody>
            </table>
        </form>
        </div>
    </body>
</html>
