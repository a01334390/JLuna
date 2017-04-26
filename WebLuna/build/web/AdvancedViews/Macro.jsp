<%-- 
    Document   : macroView
    Created on : Apr 21, 2017, 11:11:00 AM
    Author     : Arpi
--%>

<%@page import="AdvancedElements.MacroView"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="BasicElements.Cliente"%>
<%@page import="DatabaseManager.Handler"%>
<%@page import="java.time.LocalDate"%>
<%@page import="java.time.format.DateTimeFormatter"%>
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
        <title>Macroview</title>
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
            <div class="notebookhd"><h1 class="whitetxt">Welcome to the macroview </h1></div>
            
                
            
            
    </body>
        <div class="formm">
    <% MacroView macroview = new MacroView();%>
    <%String semana[] = macroview.setSemana();%>
    <%if (semana.length != 0) { %>
    <h3 class="centeredform">Entregas de esta semana</h3>
    <form action="MacroView">
        <table border="1">
            <thead>
                <tr class="centeredform whitetxt">
                    <th>Fecha de entrega</th>
                    <th>Prioridad</th>
                    <th>Primer nombre</th>
                    <th>Segundo nombre</th>
                </tr>
            </thead>
            <tbody>

                <%for (int i = 0; i < semana.length; i++) {%>
                <tr>
                    <%--
                        cortar string
                    --%>
                    <% String tabla[] = semana[i].split(", ");%>
                    <td><%=tabla[0]%></td>
                    <td><%=tabla[1]%></td>
                    <td><%=tabla[2]%></td>
                    <td><%=tabla[3]%></td>

                </tr>
                <% } %>
            </tbody>
        </table> 
        <% } %>
        <h3 class="centeredform">Entregas atrasadas</h3>
        <table border="1">
            <thead>
                <tr class="centeredform whitetxt">
                    <th>id</th>
                    <th>Primer nombre</th>
                    <th>Segundo nombre</th>
                    <th>Status</th>
                </tr>
            </thead>
            <tbody>

                <%String atrasados[] = macroview.setAtrasados();%>
                <%for (int i = 0; i < atrasados.length; i++) {%>
                <tr>
                    <%--
                        cortar string id-1name-2name-status
                    --%>
                    <% String tabla[] = atrasados[i].split(", ");%>
                    <td><%=tabla[0]%></td>
                    <td><%=tabla[1]%></td>
                    <td><%=tabla[2]%></td>
                    <td><%=tabla[3]%></td>

                </tr>
                <% } %>
            </tbody>
        </table> 
        <h3 class="centeredform">Mejores clientes</h3>
        <table border="1">
            <thead>
                <tr class="centeredform whitetxt">
                    <th>ID de la orden</th>
                    <th>Primer nombre</th>
                    <th>Segundo nombre</th>
                    <th>Prioridad</th>
                    <th>cantidad</th>
                </tr>
            </thead>
            <tbody>

                <%String clientes[] = macroview.setClientes();%>
                <%for (int i = 0; i < clientes.length; i++) {%>
                <tr>
                    <%--
                        cortar string idorder, 1name, 2name, status, priority, quantity
                    --%>
                    <% String tabla[] = clientes[i].split(", ");%>
                    <td><%=tabla[0]%></td>
                    <td><%=tabla[1]%></td>
                    <td><%=tabla[2]%></td>
                    <td><%=tabla[4]%></td>
                    <td><%=tabla[5]%></td>
                </tr>
                <% } %>
            </tbody>
        </table>
        <h3 class="centeredform">Materiales que se estan acabando</h3>
        <table border="1">
            <thead>
                <tr class="centeredform whitetxt">
                    <th>Nombre</th>
                    <th>Cantidad</th>
                </tr>
            </thead>
            <tbody>

                <%String material[] = macroview.setMaterial();%>
                <%for (int i = 0; i < material.length; i++) {%>
                <tr>
                    <%--
                        cortar string 1nombre-status-prioridad-cantidad
                    --%>
                    <% String tabla[] = material[i].split(", ");%>
                    <td><%=tabla[0]%></td>
                    <td><%=tabla[1]%></td>

                </tr>
                <% } %>
            </tbody>
        </table> 
        <h3 class="centeredform">Cuadernos que se estan acabando</h3>
        <table border="1">
            <thead>
                <tr class="centeredform whitetxt">
                    <th>Nombre</th>
                    <th>Cantidad</th>
                </tr>
            </thead>
            <tbody>

                <%String notebook[] = macroview.setNotebook();%>
                <%for (int i = 0; i < notebook.length; i++) {%>
                <tr>
                    <%--
                        cortar string 1nombre-status-prioridad-cantidad
                    --%>
                    <% String tabla[] = notebook[i].split(", ");%>
                    <td><%=tabla[0]%></td>
                    <td><%=tabla[1]%></td>

                </tr>
                <% }%>
            </tbody>
        </table>
    </form>
        </div>
            
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
</html>
