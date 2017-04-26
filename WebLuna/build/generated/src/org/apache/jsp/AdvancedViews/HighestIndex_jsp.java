package org.apache.jsp.AdvancedViews;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import AdvancedElements.HighestBenefitCC;

public final class HighestIndex_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");

    if (session.getAttribute("currentSessionName") == null) {
        response.sendRedirect("/index.jsp");
    }
    if (!session.getAttribute("currentPrivilegeLevel").equals("admin")) {
        response.sendRedirect("/index.jsp");
    }

      out.write("\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Productos que generaron más beneficio</title>\n");
      out.write("        <link href=\"newStyling.css\" rel=\"stylesheet\" type=\"text/css\">\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <script src=\"js/vendor/jquery.js\"></script>\n");
      out.write("        <script src=\"js/vendor/what-input.js\"></script>\n");
      out.write("        <script src=\"js/vendor/foundation.js\"></script>\n");
      out.write("        <script src=\"js/app.js\"></script>\n");
      out.write("        <div class=\"top-bar-container\" data-sticky-container>\n");
      out.write("            <div class=\"sticky sticky-topbar\" data-sticky data-options=\"anchor: page; marginTop: 0; stickyOn: small;\">\n");
      out.write("                <div class=\"top-bar blackbg\">\n");
      out.write("                    <div class=\"top-bar-left\">\n");
      out.write("                        <ul class=\"dropdown menu blackbg\" data-dropdown-menu>\n");
      out.write("                            <li class=\"menu-text whitetxt\">");
      out.print(session.getAttribute("currentSessionName"));
      out.write("</li>\n");
      out.write("                            <li><a href=\"#\" class=\"whitetxt whitehover\">Ordenes prioridad/fecha</a></li>\n");
      out.write("                            <li><a href=\"#\" class=\"whitetxt whitehover\">Ordenes por clientes</a></li>\n");
      out.write("                            <li><a href=\"#\" class=\"whitetxt whitehover\">Pedidos por beneficio</a></li>\n");
      out.write("                            <li><a href=\"#\" class=\"whitetxt whitehover\">Asignar materiales</a></li>\n");
      out.write("                            <li><a href=\"#\" class=\"whitetxt whitehover\">Macro vista</a></li>\n");
      out.write("                            <li class=\"whitetxt\"><a href=\"#\" class=\"whitetxt whitehover\">Vistas Basicas</a>\n");
      out.write("                            </li>\n");
      out.write("                            </div>\n");
      out.write("                        <div class=\"top-bar-right\">\n");
      out.write("                            <ul class=\"dropdown menu blackbg\" data-dropdown-menu>\n");
      out.write("                            <li><a href=\"#\" class=\"whitetxt whitehover\">Cerrar Sesion</a></li>\n");
      out.write("                            ");
      out.write("\n");
      out.write("                            </ul>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("            <br>\n");
      out.write("            <br>\n");
      out.write("        <table border=\"1\">\n");
      out.write("            <thead>\n");
      out.write("                <tr class=\"centeredform whitetxt\">\n");
      out.write("                    <th>Tipo de Cuaderno</th>\n");
      out.write("                    <th>Beneficio en ventas</th>\n");
      out.write("                </tr>\n");
      out.write("            </thead>\n");
      out.write("            <tbody>\n");
      out.write("                ");
HighestBenefitCC[] order = (HighestBenefitCC[])request.getAttribute("hob");
      out.write("\n");
      out.write("                ");
 for(int i=0;i<order.length;i++){
      out.write("\n");
      out.write("                <tr>\n");
      out.write("                    <td>");
      out.print(order[i].getType());
      out.write("</td>\n");
      out.write("                    <td>");
      out.print(order[i].getMaxBenefit());
      out.write("</td>\n");
      out.write("                </tr>\n");
      out.write("                 ");
 } 
      out.write("\n");
      out.write("            </tbody>\n");
      out.write("        </table>\n");
      out.write("\n");
      out.write("            \n");
      out.write("            <footer>\n");
      out.write("<div class=\"ecommerce-footer\">\n");
      out.write("<div class=\"ecommerce-footer-links row\">\n");
      out.write("<div class=\"small-10 medium-10 large-6 columns\">\n");
      out.write("<div class=\"row ecommerce-footer-links-block\">\n");
      out.write("<div class=\"small-4 medium-4 large-4 columns\">\n");
      out.write("<h5>Ayuda</h5>\n");
      out.write("<ul class=\"lista\">\n");
      out.write("<li><a href=\"#\">Preguntas Frecuentes</a></li>\n");
      out.write("<li><a href=\"#\">Politica de devolucion</a></li>\n");
      out.write("<li><a href=\"#\">Envio y entrega</a></li>\n");
      out.write("</ul>                                  \n");
      out.write("</div>\n");
      out.write("</div>\n");
      out.write("</div>\n");
      out.write("\n");
      out.write("<div class=\"small-12 medium-12 large-6 columns\">\n");
      out.write("<div class=\"row\">\n");
      out.write("<div class=\"small-4 medium-4 large-4 columns\">\n");
      out.write("\n");
      out.write("<h5>Mi cuenta</h5>\n");
      out.write("<ul class=\"lista\">\n");
      out.write("<li><a href=\"#\">Ingresar</a></li>\n");
      out.write("<li><a href=\"#\">Estatus de pedido</a></li>\n");
      out.write("<li><a href=\"#\">Lista de deseos</a></li>\n");
      out.write("</ul>\n");
      out.write("</div>\n");
      out.write("<div class=\"small-4 medium-4 large-4 columns\">\n");
      out.write("<h5>Acerca  </h5>\n");
      out.write("<ul class=\"lista\">\n");
      out.write("<li><a href=\"#\">Compañia</a></li>\n");
      out.write("<li><a href=\"#\">Locacion</a></li>\n");
      out.write("<li><a href=\"#\">Equipo</a></li>\n");
      out.write("<li><a href=\"#\">Soporte</a></li>\n");
      out.write("<li><a href=\"#\">Contacto</a></li>            \n");
      out.write("</ul>\n");
      out.write("</div>\n");
      out.write("<div class=\"small-4 medium-4 large-4 columns\">\n");
      out.write("<h5>Redes sociales  </h5>\n");
      out.write("<ul class=\"lista\">\n");
      out.write("<li><a href=\"#\">Facebook</a></li>\n");
      out.write("<li><a href=\"#\">Twitter</a></li>\n");
      out.write("<li><a href=\"#\">Instagram</a></li>\n");
      out.write("<li><a href=\"#\">Youtube</a></li>\n");
      out.write("</ul>\n");
      out.write("</div>\n");
      out.write("</div> \n");
      out.write("</div>\n");
      out.write("</div>\n");
      out.write("<div class=\"ecommerce-footer-bottom-bar row\">\n");
      out.write("<div class=\"small-12 medium-5 columns\">\n");
      out.write("<ul class=\"bottom-links\">\n");
      out.write("<li><a href=\"#\">Politica de privacidad</a></li>\n");
      out.write("<li><a href=\"#\">Terminos & Condiciones</a></li>\n");
      out.write("</ul>\n");
      out.write("</div>\n");
      out.write("\n");
      out.write("<div class=\"small-12 medium-5 columns\">\n");
      out.write("<div class=\"bottom-copyright\">\n");
      out.write("<span>©2017 imakenootebooks. Todos los derechos reservados.</span>\n");
      out.write("</div>\n");
      out.write("</div>\n");
      out.write("</div>\n");
      out.write("</div>\n");
      out.write("\n");
      out.write("</footer>\n");
      out.write("            \n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
