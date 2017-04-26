<%-- 
    Document   : userform
    Created on : Apr 18, 2017, 3:23:43 PM
    Author     : a01334390
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
        <title>Forma de Usuarios</title>
        <link rel="stylesheet" href="https://dhbhdrzi4tiry.cloudfront.net/cdn/sites/foundation.min.css">
        <link href="https://cdnjs.cloudflare.com/ajax/libs/foundicons/3.0.0/foundation-icons.css" rel='stylesheet' type='text/css'>
        <link href="customStyling.css" rel="stylesheet" type="text/css">
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

        <div class="translucent-form-overlay">
            <form action="User" method="POST" name="formAddUser">
                <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.css" rel="stylesheet">
                <div class="translucent-form-overlay">

                    <div class="form-icons">
                        <div class="input-group">
                            <span class="input-group-label">
                                <i class="fa fa-user"></i>
                            </span>
                            <input class="input-group-field" type="text"  name="username" value="<c:out value="${user.getUsername()}"/>"/>
                        </div>
                        <div class="input-group">
                            <label>Privilegios</label>
                                <fieldset class="large-6 columns">
                                    <input type="radio" name="privilege" value="admin" id="y1" required><label for="pokemonRed">Administrador</label>
                                    <input type="radio" name="privilege" value="manager" id="n2" required><label for="pokemonRed">Project Manager</label>
                                    <input type="radio" name="privilege" value="worker" id="n3" required><label for="pokemonRed">Encuadernador</label>
                                </fieldset>
                        </div>

                        <div class="input-group">
                            <span class="input-group-label">
                                <i class="fa fa-envelope"></i>
                            </span>
                            <input class="input-group-field" type="text" placeholder="Correo Electronico" name="email" value="<c:out value="${user.getEmail()}"/>"/>
                        </div>

                        <div class="input-group">
                            <span class="input-group-label">
                                <i class="fa fa-key"></i>
                            </span>
                            <input class="input-group-field" type="text" placeholder="Primer Nombre" name="first_name" value="<c:out value="${user.getFirst_name()}"/>"/>
                        </div>

                        <div class="input-group">
                            <span class="input-group-label">
                                <i class="fa fa-key"></i>
                            </span>
                            <input class="input-group-field" type="text" placeholder="Segundo Nombre" name="second_name" value="<c:out value="${user.getSecond_name()}"/>"/>
                        </div>

                        <div class="input-group">
                            <span class="input-group-label">
                                <i class="fa fa-key"></i>
                            </span>
                            <input class="input-group-field" type="text" placeholder="image path" name="image" value="<c:out value="${user.getImage()}"/>"/>
                        </div>

                        <div class="input-group">
                            <span class="input-group-label">
                                <i class="fa fa-key"></i>
                            </span>
                            <input class="input-group-field" type="password" placeholder="Password" name="password" value="<c:out value="${user.getPassword()}"/>"/>
                        </div>
                    </div>

                    <button class="button expanded">Hacer Cambios</button>

            </form>
        </div>
    </body>
</html>
