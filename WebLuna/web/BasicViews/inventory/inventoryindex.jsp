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
<html>
    <head>
        <meta charset="utf-8"/>
        <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
        <title>Inventario</title>
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
        <h1>Inventario</h1>
        <form action="Inventory" method='GET'>
            <table border="1">
                <thead>
                    <tr>
                        <th>ID</th>                    
                        <th>Name</th>
                        <th>Quantity</th>    
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
                    <tr>
                        <td><%=nb[i].getId()%></td>
                        <td><%=nb[i].getType()%></td>
                        <td><%=inventory[i].getAmmount()%></td>
                        <td>
                            <a href="Inventory?action=edit&id_Notebook=<%=inventory[i].getId_Notebook()%>">Editar</a>                             
                        </td>
                    </tr>
                    <%}%>
                </tbody>
            </table>
        </form>        
    </body>
</html>
