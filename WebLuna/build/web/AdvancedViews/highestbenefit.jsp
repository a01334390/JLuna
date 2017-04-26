<%-- 
    Document   : highestbenefit
    Created on : 21/04/2017, 01:32:24 AM
    Author     : Alex
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="AdvancedElements.HighestBenefitCC"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
        <link rel="stylesheet" href="https://dhbhdrzi4tiry.cloudfront.net/cdn/sites/foundation.min.css">
        <link href="https://cdnjs.cloudflare.com/ajax/libs/foundicons/3.0.0/foundation-icons.css" rel='stylesheet' type='text/css'>
        <link href="newStyling.css" rel="stylesheet" type="text/css">
        <title>Beneficio alto</title>
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
            <div class="notebookhd"><h1 class="whitetxt">Orders with highest benefits</h1></div>
            
            
            <br>
            <br>
            <form action="HighestBenefit" method="POST" name="formGetByCalendar" data-abide>
        Fecha uno: <input type="text" value="1990-01-01" name="date1" required><br>
        Fecha dos: <input type="text" value="2200-01-01" name="date2" required>
        <input type="submit" value="Submit" />
    </form>
            
            
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
