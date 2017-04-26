<%-- 
    Document   : HighestIndex
    Created on : Apr 25, 2017, 1:52:20 PM
    Author     : a01334390
--%>

<%@page import="AdvancedElements.HighestBenefitCC"%>
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
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Productos que generaron más beneficio</title>
        <link href="newStyling.css" rel="stylesheet" type="text/css">
    </head>
    <body>
        <script src="js/vendor/jquery.js"></script>
        <script src="js/vendor/what-input.js"></script>
        <script src="js/vendor/foundation.js"></script>
        <script src="js/app.js"></script>
        <div class="top-bar-container" data-sticky-container>
            <div class="sticky sticky-topbar" data-sticky data-options="anchor: page; marginTop: 0; stickyOn: small;">
                <div class="top-bar blackbg">
                    <div class="top-bar-left">
                        <ul class="dropdown menu blackbg" data-dropdown-menu>
                            <li class="menu-text whitetxt"><%=session.getAttribute("currentSessionName")%></li>
                            <li><a href="#" class="whitetxt whitehover">Ordenes prioridad/fecha</a></li>
                            <li><a href="#" class="whitetxt whitehover">Ordenes por clientes</a></li>
                            <li><a href="#" class="whitetxt whitehover">Pedidos por beneficio</a></li>
                            <li><a href="#" class="whitetxt whitehover">Asignar materiales</a></li>
                            <li><a href="#" class="whitetxt whitehover">Macro vista</a></li>
                            <li class="whitetxt"><a href="#" class="whitetxt whitehover">Vistas Basicas</a>
                            </li>
                            </div>
                        <div class="top-bar-right">
                            <ul class="dropdown menu blackbg" data-dropdown-menu>
                            <li><a href="#" class="whitetxt whitehover">Cerrar Sesion</a></li>
                            <%-- CHECAR FUNCIONALIDAD BOTON CERRAR SESION--%>
                            </ul>
                        </div>
                    </div>
                </div>
            </div>
            <br>
            <br>
        <table border="1">
            <thead>
                <tr class="centeredform whitetxt">
                    <th>Tipo de Cuaderno</th>
                    <th>Beneficio en ventas</th>
                </tr>
            </thead>
            <tbody>
                <%HighestBenefitCC[] order = (HighestBenefitCC[])request.getAttribute("hob");%>
                <% for(int i=0;i<order.length;i++){%>
                <tr>
                    <td><%=order[i].getType()%></td>
                    <td><%=order[i].getMaxBenefit()%></td>
                </tr>
                 <% } %>
            </tbody>
        </table>

            
            <footer>
<div class="ecommerce-footer">
<div class="ecommerce-footer-links row">
<div class="small-10 medium-10 large-6 columns">
<div class="row ecommerce-footer-links-block">
<div class="small-4 medium-4 large-4 columns">
<h5>Ayuda</h5>
<ul class="lista">
<li><a href="#">Preguntas Frecuentes</a></li>
<li><a href="#">Politica de devolucion</a></li>
<li><a href="#">Envio y entrega</a></li>
</ul>                                  
</div>
</div>
</div>

<div class="small-12 medium-12 large-6 columns">
<div class="row">
<div class="small-4 medium-4 large-4 columns">

<h5>Mi cuenta</h5>
<ul class="lista">
<li><a href="#">Ingresar</a></li>
<li><a href="#">Estatus de pedido</a></li>
<li><a href="#">Lista de deseos</a></li>
</ul>
</div>
<div class="small-4 medium-4 large-4 columns">
<h5>Acerca  </h5>
<ul class="lista">
<li><a href="#">Compañia</a></li>
<li><a href="#">Locacion</a></li>
<li><a href="#">Equipo</a></li>
<li><a href="#">Soporte</a></li>
<li><a href="#">Contacto</a></li>            
</ul>
</div>
<div class="small-4 medium-4 large-4 columns">
<h5>Redes sociales  </h5>
<ul class="lista">
<li><a href="#">Facebook</a></li>
<li><a href="#">Twitter</a></li>
<li><a href="#">Instagram</a></li>
<li><a href="#">Youtube</a></li>
</ul>
</div>
</div> 
</div>
</div>
<div class="ecommerce-footer-bottom-bar row">
<div class="small-12 medium-5 columns">
<ul class="bottom-links">
<li><a href="#">Politica de privacidad</a></li>
<li><a href="#">Terminos & Condiciones</a></li>
</ul>
</div>

<div class="small-12 medium-5 columns">
<div class="bottom-copyright">
<span>©2017 imakenootebooks. Todos los derechos reservados.</span>
</div>
</div>
</div>
</div>

</footer>
            
    </body>
</html>
