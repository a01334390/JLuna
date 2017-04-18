<%-- 
    Document   : userindex
    Created on : Apr 18, 2017, 3:23:48 PM
    Author     : a01334390
--%>

<%@page import="BasicElements.DBUser"%>
<%@page import="DatabaseManager.Handler"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8"/>
        <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
        <title>Usuarios</title>
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

                    <h1>Showing available ones</h1>
                    <p><a href="User?action=add">Añadir Usuario</a></p>
                    <form action="User" method="GET">
                        <table border="1">
                            <thead>
                                <tr>
                                    <th>Nombre de Usuario</th>
                                    <th>Correo Electronico</th>
                                    <th>Clave Secreta</th>
                                    <th>Nivel de privilegio</th>
                                    <th>Primer Nombre</th>
                                    <th>Segundo Nombre</th>
                                    <th>Imagen</th>
                                    <th>Acciones</th>
                                </tr>
                            </thead>
                            <tbody>
                                <%DBUser[] users = Handler.getAllUsers();%>
                                <%for (int i = 0; i < users.length; i++) {%>
                                <tr>
                                    <td><%=users[i].getUsername()%></td>
                                    <td><%=users[i].getEmail()%></td>
                                    <td>[REDACTED]</td>
                                    <%if(users[i].getPrivilege().equals("admin")){%>
                                    <td>Administrador</td>
                                    <% }else if(users[i].getPrivilege().equals("manager")){ %>
                                    <td>Manager</td>
                                    <%}else{%>
                                    <td>Encuadernador</td>
                                    <%}%>
                                    <td><%=users[i].getFirst_name()%></td>
                                    <td><%=users[i].getSecond_name()%></td>
                                    <td><%=users[i].getImage()%></td>
                                    <td><a href="User?action=edit&username=<%=users[i].getUsername()%>">Editar</a> 
                                    <a href="User?action=erase&username=<%=users[i].getUsername()%>">Eliminar</a> </td>
                                </tr>
                                <% } %>
                            </tbody>
                        </table>
                    </form>
                    </body>
                    </html>