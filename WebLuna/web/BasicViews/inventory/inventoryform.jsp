<%-- 
    Document   : inventoryform
    Created on : 20/04/2017, 11:46:35 PM
    Author     : Alex
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8"/>
        <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
        <title>Forma de Inventario</title>
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
            <form action="Inventory" method="POST" name="formAddInventory">
                <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.css" rel="stylesheet">
                <div class="form-icons">
                    <div class="input-group">
                        <label>
                            ID de cuaderno
                            <input class="input-group-field" type="text" readonly="readonly" name="id_Notebook" value="<c:out value="${inventory.getId_Notebook()}"/>"/>
                        </label>
                        
                        
                    </div>

                    <div class="input-group">
                        <span class="input-group-label">
                            <i class="fa fa-pencil"></i>
                        </span>
                        <input class="input-group-field" type="text" placeholder="Cantidad" name="ammount" value="<c:out value="${inventory.getAmmount()}"/>"/>
                    </div>

                </div>

                <button class="button expanded">Hacer Cambios</button>

            </form>
        </div>

    </body>
</html>
