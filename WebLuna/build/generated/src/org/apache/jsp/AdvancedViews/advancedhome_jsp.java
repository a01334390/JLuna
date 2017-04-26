package org.apache.jsp.AdvancedViews;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class advancedhome_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("        <meta charset=\"utf-8\"/>\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\"/>\n");
      out.write("        <title>Vistas Avanzadas</title>\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://dhbhdrzi4tiry.cloudfront.net/cdn/sites/foundation.min.css\">\n");
      out.write("        <link href=\"https://cdnjs.cloudflare.com/ajax/libs/foundicons/3.0.0/foundation-icons.css\" rel='stylesheet' type='text/css'>\n");
      out.write("        <link href=\"customStyling.css\" rel=\"stylesheet\" type=\"text/css\">\n");
      out.write("        <link href=\"homeStyle.css\" rel=\"stylesheet\" type=\"text/css\">\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <script>\n");
      out.write("            (function (i, s, o, g, r, a, m) {\n");
      out.write("                i['GoogleAnalyticsObject'] = r;\n");
      out.write("                i[r] = i[r] || function () {\n");
      out.write("                    (i[r].q = i[r].q || []).push(arguments)\n");
      out.write("                }, i[r].l = 1 * new Date();\n");
      out.write("                a = s.createElement(o),\n");
      out.write("                        m = s.getElementsByTagName(o)[0];\n");
      out.write("                a.async = 1;\n");
      out.write("                a.src = g;\n");
      out.write("                m.parentNode.insertBefore(a, m)\n");
      out.write("            })(window, document, 'script', 'https://www.google-analytics.com/analytics.js', 'ga');\n");
      out.write("\n");
      out.write("            ga('create', 'UA-2195009-2', 'auto');\n");
      out.write("            ga('send', 'pageview');\n");
      out.write("\n");
      out.write("            ga('create', 'UA-2195009-27', 'auto', {name: \"foundation\"});\n");
      out.write("            ga('foundation.send', 'pageview');\n");
      out.write("\n");
      out.write("        </script>\n");
      out.write("        <div class=\"off-canvas-wrapper\">\n");
      out.write("            <div class=\"off-canvas-wrapper-inner\" data-off-canvas-wrapper>\n");
      out.write("                <div class=\"off-canvas position-left reveal-for-large\" id=\"my-info\" data-off-canvas data-position=\"left\">\n");
      out.write("                    <div class=\"row column offcanvas\">\n");
      out.write("                        <br>\n");
      out.write("                        <img class=\"thumbnail\" src=\"images/LunaLogo.png\">\n");
      out.write("                        <h5 class=\"whitetxt\">");
      out.print(session.getAttribute("currentSessionName"));
      out.write("</h5>\n");
      out.write("                        <p class=\"whitetxt\">Bienvenida a las vistas avanzadas</p>                        \n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"off-canvas-content\" data-off-canvas-content>\n");
      out.write("                    <div class=\"title-bar hide-for-large\">\n");
      out.write("                        <div class=\"title-bar-left\">\n");
      out.write("                            <button class=\"menu-icon\" type=\"button\" data-open=\"my-info\"></button>\n");
      out.write("                            <span class=\"title-bar-title\">");
      out.print(session.getAttribute("currentSessionName"));
      out.write("</span>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"callout primary\">\n");
      out.write("                        <div class=\"row column\" >\n");
      out.write("                            <h1 class=\"whitetxt\">");
      out.print(session.getAttribute("currentSessionName"));
      out.write("</h1>\n");
      out.write("                            <p class=\"lead whitetxt\">Escoge alguna de las vistas avanzadas</p>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("\n");
      out.write("                    <div class=\"row small-up-2 medium-up-3 large-up-4\">\n");
      out.write("                        <div class=\"column\" type=\"left-rightpadd\" type=\"left-rightpadd\">\n");
      out.write("                            <form action=\"AdvancedHome\"  method='GET'>\n");
      out.write("                                <input type=\"image\" class=\"thumbnail\" src=\"images/RHAorden.png\" name=\"action\" value=\"priorityOrders\"/>\n");
      out.write("                            </form>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"column\" type=\"left-rightpadd\" type=\"left-rightpadd\">\n");
      out.write("                            <form action=\"AdvancedHome\" method='GET'>\n");
      out.write("                                <input type=\"image\" class=\"thumbnail\" src=\"images/RHAmasorden.png\" name=\"action\" value=\"clientsOrders\" />\n");
      out.write("                            </form>\n");
      out.write("                        </div>\n");
      out.write("                        ");
if (session.getAttribute("currentPrivilegeLevel").equals("admin") || session.getAttribute("currentPrivilegeLevel").equals("manager")) { 
      out.write("\n");
      out.write("                        <div class=\"column\" type=\"left-rightpadd\" type=\"left-rightpadd\">\n");
      out.write("                            <form action=\"AdvancedHome\" method=\"GET\">\n");
      out.write("                                <input type=\"image\" class=\"thumbnail\" src=\"images/RHAbeneficio.png\" name=\"action\" value=\"highestBenefit\"/>\n");
      out.write("                            </form>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"column\" type=\"left-rightpadd\" value=\"material\" type=\"left-rightpadd\">\n");
      out.write("                            <form action=\"AdvancedHome\" method=\"GET\">\n");
      out.write("                                <input type=\"image\" class=\"thumbnail\" src=\"images/RHAmateriales.png\" name=\"action\" value=\"materialsToNotebooks\"/>\n");
      out.write("                            </form>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"column\" type=\"left-rightpadd\" value=\"macro\" type=\"left-rightpadd\">\n");
      out.write("                            <form action=\"AdvancedHome\" method=\"GET\">\n");
      out.write("                                <input type=\"image\" class=\"thumbnail\" src=\"images/RHAmacro.png\" name=\"action\" value=\"macro\"/>\n");
      out.write("                            </form>\n");
      out.write("                        </div>\n");
      out.write("                        ");
 } 
      out.write("                       \n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>               \n");
      out.write("        <script src=\"https://code.jquery.com/jquery-2.1.4.min.js\"></script>\n");
      out.write("        <script src=\"https://dhbhdrzi4tiry.cloudfront.net/cdn/sites/foundation.js\"></script>\n");
      out.write("        <script>\n");
      out.write("            $(document).foundation();\n");
      out.write("        </script>\n");
      out.write("        <script type=\"text/javascript\" src=\"https://intercom.zurb.com/scripts/zcom.js\"></script>\n");
      out.write("        \n");
      out.write("        <footer>\n");
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
