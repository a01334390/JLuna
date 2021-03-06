<%-- 
    Document   : notebookform
    Created on : Apr 18, 2017, 5:43:26 PM
    Author     : a01334390
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
        <title>Forma de Cuadernos</title>
        <link rel="stylesheet" href="https://dhbhdrzi4tiry.cloudfront.net/cdn/sites/foundation.min.css">
        <link href="https://cdnjs.cloudflare.com/ajax/libs/foundicons/3.0.0/foundation-icons.css" rel='stylesheet' type='text/css'>
        <link href="BasicViews/notebook/notebookStyling.css" rel="stylesheet" type="text/css">
        <link href="BasicViews/notebook/formStyling.css" rel="stylesheet" type="text/css">
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
        <script src="https://code.jquery.com/jquery-2.1.4.min.js"></script>
        <script src="https://dhbhdrzi4tiry.cloudfront.net/cdn/sites/foundation.js"></script>
        <script>$(document).foundation();</script>
        <script type="text/javascript" src="https://intercom.zurb.com/scripts/zcom.js"></script>

        <div class="translucent-form-overlay">
        <form action="Notebook" method="POST" name="formAddNotebook" data-abide>
            <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.css" rel="stylesheet">

            <form>
                <div class="form-icons">
                    <div class="input-group">
                        <span class="input-group-label">
                            <i class="fa fa-user"></i>
                        </span>
                        <input class="input-group-field" type="text" readonly="readonly" name="id" value="<c:out value="${notebook.getId()}"/>"/>
                    </div>

                    <div class="input-group">
                        <span class="input-group-label">
                            <i class="fa fa-clock-o"></i>
                        </span>
                        <input class="input-group-field" required type="text" placeholder="Tiempo Promedio" name="average_time" value="<c:out value="${notebook.getAverage_time()}"/>"/>
                    </div>

                    <div class="input-group">
                        <span class="input-group-label">
                            <i class="fa fa-book"></i>
                        </span>
                        <input class="input-group-field" required type="text" placeholder="Tipo de Cuaderno" name="type" value="<c:out value="${notebook.getType()}"/>"/>
                    </div>

                    <div class="input-group">
                        <span class="input-group-label">
                            <i class="fa fa-money"></i>
                        </span>
                        <input class="input-group-field" required type="text" placeholder="Beneficio Economico" name="benefit" value="<c:out value="${notebook.getBenefit()}"/>"/>
                    </div>
                </div>

                <button id="submitbutton" class="button expanded">Hacer Cambios</button>
            </form>
        </form>
        </div
    </body>
</html>