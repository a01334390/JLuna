<%-- 
    Document   : newOrderForm
    Created on : Apr 18, 2017, 9:38:34 PM
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
        <title>Forma de Ordenes</title>
        <link href="customStyling.css" rel="stylesheet" type="text/css">
        <link rel="stylesheet" href="https://dhbhdrzi4tiry.cloudfront.net/cdn/sites/foundation.min.css">
        <link href="https://cdnjs.cloudflare.com/ajax/libs/foundicons/3.0.0/foundation-icons.css" rel='stylesheet' type='text/css'>
    </head>
    <body>
        <div class="translucent-form-overlay">
            <form action="Order" method="POST" name="OrderForm" data-abide>
                <h3>A&#241adir un nuevo pedido</h3>
                <div class="row columns">
                    <label>Clave del Cliente
                        <input type="text" readonly="readonly" name="idClient" value="<c:out value="${client.getId()}"/>"/>
                    </label>
                </div>
                <div class="row columns">
                    <label>Clave de la Orden
                        <input type="text" readonly="readonly" name="idOrder" value="<c:out value="${order.getId()}"/>"/>
                    </label>
                </div>
                <div class="row columns">
                    <label>Fecha de la Orden
                        <input type="text" required name="date" value="<c:out value="${order.getDate()}"/>"/>
                    </label>
                </div>
                <div class="row columns">
                    <label>Fecha de creacion
                        <input type="text" name="create_time" value="<c:out value="${order.getCreate_time()}"/>"/>
                    </label>
                </div>
                <div class="row columns">
                    <label> Prioridad
                        <select name="priority" type="text" required>
                            <option value="LOW">Baja</option>
                            <option value="MEDIUM">Media</option>
                            <option value="HIGH">Alta</option>
                        </select>
                    </label>
                </div>
                    <input type="submit" class="primary button expanded search-button" value="Modificar"/>
            </form>
        </div>
    </body>
</html>
