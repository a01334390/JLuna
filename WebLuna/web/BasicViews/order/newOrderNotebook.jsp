<%-- 
    Document   : newOrderNotebook
    Created on : Apr 19, 2017, 11:08:20 AM
    Author     : a01334390
--%>


<%@page import="BasicElements.Notebook"%>
<%@page import="DatabaseManager.Handler"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="BasicElements.OrderNotebooks"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8"/>
        <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
        <title>Forma de Cuadernos</title>
        <link href="customStyling.css" rel="stylesheet" type="text/css">
        <link rel="stylesheet" href="https://dhbhdrzi4tiry.cloudfront.net/cdn/sites/foundation.min.css">
        <link href="https://cdnjs.cloudflare.com/ajax/libs/foundicons/3.0.0/foundation-icons.css" rel='stylesheet' type='text/css'>
    </head>
    <body>
        <div class="translucent-form-overlay">
            <form action="ONotebook" method="POST" name="OrderForm">
                <h3>Aunar un nuevo set de cuadernos al pedido</h3>
                <div class="row columns">
                    <label>Clave de la Orden
                        <input type="text" readonly="readonly" name="idOrder" value="<c:out value="${on.getID_Order()}"/>"/>
                    </label>
                </div>
                <div class="row columns">
                    <label> Cuadernos
                    <select name="id_Notebook">
                        <% Notebook[] nb = Handler.getAllNotebooks();
                        for(int i=0;i<nb.length;i++){
                            %>
                            <option value="${nb[i].getId()}" ${on.getId_Notebook() == nb[i].getId() ? 'selected="selected"' : ''}>${nb[i].getType()}<%=nb[i].getType()%></option>
                       <% } %>
                    </select>
                    </label>
                </div>
                <div class="row columns">
                    <label>Cantidad de cuadernos
                        <input type="text"  name="quantity" value="<c:out value="${on.getQuantity()}"/>"/>
                    </label>
                </div>

                <div class="row columns">
                    <label> Status de la orden
                        <select name="priority" type="text">
                            <option value="Diseño" value="Diseño" ${on.getStatus() == "Diseño" ? 'selected="selected"' : ''}> Diseño</option>
                            <option value="Preview" ${on.getStatus() == "Diseño" ? 'selected="selected"' : ''}>Preview</option>
                            <option value="Laminado" ${on.getStatus() == "Laminado" ? 'selected="selected"' : ''}>Laminado</option>
                            <option value="Revision" ${on.getStatus() == "Revision" ? 'selected="selected"' : ''}>Revision</option>
                            <option value="Prensa" ${on.getStatus() == "Prensa" ? 'selected="selected"' : ''}>Prensa</option>
                            <option value="Embalaje" ${on.getStatus() == "Embalaje" ? 'selected="selected"' : ''}>Embalaje</option>
                            <option value="Envio" ${on.getStatus() == "Envio" ? 'selected="selected"' : ''}>Envio</option>
                            <option value="Entregado" ${on.getStatus() == "Entregado" ? 'selected="selected"' : ''}>Entregado</option>
                        </select>
                    </label>
                </div>
                <div class="row columns">
                    <label> Liston
                        <select name="ribbon" type="text">
                            <option value="B" ${on.getRibbon() == "B" ? 'selected="selected"' : ''}>Negro</option>
                            <option value="W"${on.getRibbon() == "W" ? 'selected="selected"' : ''}>Blanco</option>
                            <option value="NONE" ${on.getRibbon() == "NONE" ? 'selected="selected"' : ''}>Ninguno</option>
                        </select>
                    </label>
                </div>
                <div class="row columns">
                    <label> Elastico
                        <select name="elastic" type="text">
                            <option value="Y" ${on.getElastic() == "Y" ? 'selected="selected"' : ''}>Si</option>
                            <option value="N" ${on.getElastic() == "N" ? 'selected="selected"' : ''}>No</option>
                        </select>
                    </label>
                </div>
                <div class="row columns">
                    <label> Tipo de hojas
                        <select name="pageType" type="text">
                            <option value="PLAIN"  ${on.getPageType() == "PLAIN" ? 'selected="selected"' : ''}>Plano</option>
                            <option value="LINED"  ${on.getPageType() == "LINED" ? 'selected="selected"' : ''}>Rayado</option>
                            <option value="AGENDA"  ${on.getPageType() == "AGENDA" ? 'selected="selected"' : ''}>Agenda</option>
                        </select>
                    </label>
                </div>
                <div class="row columns">
                    <label>Link de la imagen
                        <input type="text"  name="image" vvalue="<c:out value="${on.getImage()}"/>"/>
                    </label>
                </div>
                <input type="submit" class="primary button expanded search-button" value="Modificar"/>
            </form>
        </div>
    </body>
</html>
