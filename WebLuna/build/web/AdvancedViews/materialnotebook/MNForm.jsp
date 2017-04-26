<%-- 
    Document   : MNForm
    Created on : Apr 25, 2017, 2:55:46 PM
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
        <title>Forma de Materiales y Cuadernos</title>
        <link href="customStyling.css" rel="stylesheet" type="text/css">
        <link rel="stylesheet" href="https://dhbhdrzi4tiry.cloudfront.net/cdn/sites/foundation.min.css">
        <link href="https://cdnjs.cloudflare.com/ajax/libs/foundicons/3.0.0/foundation-icons.css" rel='stylesheet' type='text/css'>
    </head>
    <body>
        <div class="translucent-form-overlay">
            <form action="MTNotebook" method="POST" name="OrderForm" data-abide>
                <h3>Material/Cuaderno</h3>
                <div class="row columns">
                    <label>Clave del Cuaderno
                        <input type="text" readonly="readonly" name="notebookID" value="<c:out value="${idd}"/>"/>
                    </label>
                </div>
                    <div class="row columns">
                    <label>Status
                        <input required type="text" readonly="readonly" name="status" value="<c:out value="${status}"/>"/>
                    </label>
                </div>
                <div class="row columns">
                    <label> Material
                        <select name="materialID" required>
                            <c:forEach var="item" items="${material}">
                                <option value="${item.getId()}" ${mn.getMaterial_id() == item.getId() ? 'selected="selected"' : ''}>${item.getName()}</option>
                            </c:forEach>
                        </select>
                    </label>
                </div>
                <div class="row columns">
                    <label>Cantidad
                        <input required type="text" name="quantity" value="<c:out value="${mn.getAmmount()}"/>"/>
                    </label>
                </div>
                <input type="submit" class="primary button expanded search-button" value="Modificar"/>
            </form>
        </div>
    </body>
</html>
