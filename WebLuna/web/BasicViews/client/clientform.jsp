<%-- 
    Document   : clientform
    Created on : Apr 18, 2017, 1:05:31 PM
    Author     : a01334390
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8"/>
        <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
        <title>Forma de Clientes</title>
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


        <form action="Client" method="POST" name="formAddUser">
            <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.css" rel="stylesheet">

            <form>
                <div class="form-icons">
                    
                    <div class="input-group">
                        <span class="input-group-label">
                            <i class="fa fa-user"></i>
                        </span>
                        <input class="input-group-field" type="text" readonly="readonly" name="idClient" value="<c:out value="${client.getId()}" />"/>
                    </div>

                    <div class="input-group">
                        <span class="input-group-label">
                            <i class="fa fa-user"></i>
                        </span>
                        <input class="input-group-field" type="text" placeholder="Primer Nombre" name="first_name" value="<c:out value="${client.getFirst_name()}" />"/>
                    </div>

                    <div class="input-group">
                        <span class="input-group-label">
                            <i class="fa fa-envelope"></i>
                        </span>
                        <input class="input-group-field" type="text" placeholder="Segundo Nombre" name="second_name" value="<c:out value="${client.getSecond_name()}" />"/>
                    </div>

                    <div class="input-group">
                        <span class="input-group-label">
                            <i class="fa fa-key"></i>
                        </span>
                        <input class="input-group-field" type="text" placeholder="Direccion" name="address" value="<c:out value="${client.getAddress()}" />"/>
                    </div>
                </div>

                <div class="input-group">
                    <fieldset class="large-6 columns">
                         <input type="radio" name="isPhysical" value="1" id="yes" required><label for="pokemonRed">Es Fisico</label>
                          <input type="radio" name="isPhysical" value="0" id="no" required><label for="pokemonRed">No es Fisico</label>
                    </fieldset>
                </div>

                <button class="button expanded">Hacer Cambios</button>
            </form>


        </form>


    </body>
</html>
