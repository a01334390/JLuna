<%-- 
    Document   : materialform
    Created on : 20/04/2017, 09:33:18 PM
    Author     : Alex
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8"/>
        <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
        <title>Forma de Materiales</title>
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
        <form action="Material" method="POST" name="formAddMaterial">
            <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.css" rel="stylesheet">
            <div class="form-icons">
                <div class="input-group">
                    <span class="input-group-label">
                        <i class="fa fa-user"></i>
                    </span>
                    <input class="input-group-field" type="text" readonly="readonly" name="id" value="<c:out value="${material.getId()}"/>"/>
                </div>
                
                <div class="input-group">
                    <span class="input-group-label">
                        <i class="fa fa-pencil"></i>
                    </span>
                    <input class="input-group-field" type="text" placeholder="Nombre" name="name" value="<c:out value="${material.getName()}"/>"/>
                </div>
                
                <div class="input-group">
                    <span class="input-group-label">
                        <i class="fa fa-money"></i>
                    </span>
                    <input class="input-group-field" type="text" placeholder="Costo" name="cost" value="<c:out value="${material.getCost()}"/>"/>
                </div>
                
                <div class="input-group">
                    <span class="input-group-label">
                        <i class="fa fa-pencil"></i>
                    </span>
                    <input class="input-group-field" type="text" placeholder="Cantidad" name="quantity" value="<c:out value="${material.getQuantity()}"/>"/>
                </div>
            </div>

            <button class="button expanded">Hacer Cambios</button>
        </form>
        
    </body>
</html>
