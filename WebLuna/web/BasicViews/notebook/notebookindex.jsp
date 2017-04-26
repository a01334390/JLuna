<%-- 
    Document   : notebookindex
    Created on : Apr 18, 2017, 5:43:10 PM
    Author     : a01334390
--%>

<%@page import="BasicElements.Notebook"%>
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
        <title>Cuadernos</title>
        <link rel="stylesheet" href="https://dhbhdrzi4tiry.cloudfront.net/cdn/sites/foundation.min.css">
        <link href="https://cdnjs.cloudflare.com/ajax/libs/foundicons/3.0.0/foundation-icons.css" rel='stylesheet' type='text/css'>
        <link href="notebookStyling.css" rel="stylesheet" type="text/css">
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
        <div class="notebookhd"><h1>notebooks</h1></div>
        <br>
        <p class="centeredform"><a href="Notebook?action=add" class="nonblue"><i class="fa fa-plus adduser"></i>Añadiplusr Cuaderno</a></p>
        <div class="formm">
        <form action="Notebook" method='GET'>
            <table border="1">
                <thead>
                    <tr class="centeredform">
                        <th>ID</th>
                        <th>Tiempo de produccion</th>
                        <th>Tipo de Cuaderno</th>
                        <th>Beneficio economico</th>
                        <th>Acciones</th>
                    </tr>
                </thead>
                <tbody>
                    <%
                        Notebook[] nb = Handler.getAllNotebooks();
                        for(int i=0;i<nb.length;i++){
                    %>
                    <tr class="centeredform">
                        <td><%=nb[i].getId()%></td>
                        <td><%=nb[i].getAverage_time()%></td>
                        <td><%=nb[i].getType()%></td>
                        <td><%=nb[i].getBenefit()%></td>
                        <td>
                            <a href="Notebook?action=edit&notebookID=<%=nb[i].getId()%>"><i class="fa fa-pencil nonblue"></i></a> 
                            <a href="Notebook?action=erase&notebookID=<%=nb[i].getId()%>"><i class="fa fa-trash nonblue"></i></a>
                        </td>
                    </tr>
                    <%}%>
                </tbody>
            </table>
        </form>
    </div>
    </body>
</html>
