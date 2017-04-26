package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import DatabaseManager.Handler;
import BasicElements.Material;

public final class home_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\n");
      out.write("<!DOCTYPE html>\n");

    if (session.getAttribute("currentSessionName") == null) {
        response.sendRedirect("/index.jsp");
    }

      out.write("\n");
      out.write("<html class=\"no-js\" lang=\"en\">\n");
      out.write("    <head>\n");
      out.write("        <meta charset=\"utf-8\"/>\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\"/>\n");
      out.write("        <title>Bienvenid@ ");
      out.print(session.getAttribute("currentSessionName"));
      out.write("</title>\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://dhbhdrzi4tiry.cloudfront.net/cdn/sites/foundation.min.css\">\n");
      out.write("        <link href=\"https://cdnjs.cloudflare.com/ajax/libs/foundicons/3.0.0/foundation-icons.css\" rel='stylesheet' type='text/css'>\n");
      out.write("        <link href=\"customStyling\" rel=\"stylesheet\" type=\"text/css\">\n");
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
      out.write("        \n");
      out.write("        <div class=\"off-canvas-wrapper\">\n");
      out.write("            <div class=\"off-canvas-wrapper-inner\" data-off-canvas-wrapper>\n");
      out.write("                <div class=\"off-canvas position-left reveal-for-large\" id=\"my-info\" data-off-canvas data-position=\"left\">\n");
      out.write("                    <div class=\"row column\">\n");
      out.write("                        <br>\n");
      out.write("                        <img class=\"thumbnail\" src=\"https://placehold.it/550x350\">\n");
      out.write("                        <h5>");
      out.print(session.getAttribute("currentSessionName"));
      out.write("</h5>\n");
      out.write("                        <p>Bienvenida a la base de datos</p>\n");
      out.write("                        ");

                            Material [] material = Handler.getShortageOfMaterial();
                        
      out.write("\n");
      out.write("                        ");
 if (material.length > 0 ){
      out.write("\n");
      out.write("                        <h5><strong>Hay escasez de los siguientes materiales:</strong></h5>\n");
      out.write("                            ");
 for (int i = 0; i < material.length; i++){
      out.write("\n");
      out.write("                                <p>");
      out.print(material[i].getQuantity()+" "+material[i].getName());
      out.write("</p>\n");
      out.write("                            ");
}
      out.write("\n");
      out.write("                        ");
}
      out.write("\n");
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
      out.write("                            <h1>");
      out.print(session.getAttribute("currentSessionName"));
      out.write("</h1>\n");
      out.write("                            <p class=\"lead\">Escoge alguna de las siguientes opciones disponibles para ti</p>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("\n");
      out.write("                    <div class=\"row small-up-2 medium-up-3 large-up-4\">\n");
      out.write("                        <div class=\"column\" type=\"left-rightpadd\" type=\"left-rightpadd\">\n");
      out.write("                            <form action=\"login\"  method=\"GET\">\n");
      out.write("                                <input type=\"image\" src=\"images/pedidos.png\" name=\"action\" value=\"order\"/>\n");
      out.write("                            </form>\n");
      out.write("                            <h5 align=\"center\">Ordenes</h5>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"column\" type=\"left-rightpadd\" type=\"left-rightpadd\">\n");
      out.write("                            <form action=\"login\" method=\"GET\">\n");
      out.write("                                <input type=\"image\" src=\"images/inventario.png\" name=\"action\" value=\"inventory\" />\n");
      out.write("                            </form>\n");
      out.write("                            <h5 align=\"center\">Inventario</h5>\n");
      out.write("                        </div>\n");
      out.write("                        ");
if (session.getAttribute("currentPrivilegeLevel").equals("admin") || session.getAttribute("currentPrivilegeLevel").equals("manager")) { 
      out.write("\n");
      out.write("                        <div class=\"column\" type=\"left-rightpadd\" type=\"left-rightpadd\">\n");
      out.write("                            <form action=\"login\" method=\"GET\">\n");
      out.write("                                <input type=\"image\" src=\"images/clientes.png\" name=\"action\" value=\"client\"/>\n");
      out.write("                            </form>\n");
      out.write("                            <h5 align=\"center\">Clientes</h5>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"column\" type=\"left-rightpadd\" value=\"material\" type=\"left-rightpadd\">\n");
      out.write("                            <form action=\"login\" method=\"GET\">\n");
      out.write("                                <input type=\"image\" src=\"images/materiales.png\" name=\"action\" value=\"material\"/>\n");
      out.write("                            </form>\n");
      out.write("                            <h5 align=\"center\">Materiales</h5>\n");
      out.write("                        </div>\n");
      out.write("                        ");
 } 
      out.write("\n");
      out.write("                        ");
if (session.getAttribute("currentPrivilegeLevel").equals("admin")) {
      out.write("\n");
      out.write("                        <div class=\"column\" type=\"left-rightpadd\" value=\"user\" type=\"left-rightpadd\">\n");
      out.write("                            <form action=\"login\" method=\"GET\">\n");
      out.write("                                <input type=\"image\" src=\"images/usuarios.png\" name=\"action\" value=\"user\"/>\n");
      out.write("                            </form>\n");
      out.write("                            <h5 align=\"center\">Usuarios</h5>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"column\" type=\"left-rightpadd\" value=\"advanced\" type=\"left-rightpadd\">\n");
      out.write("                            <form action=\"login\" method=\"GET\">\n");
      out.write("                                <input type=\"image\" src=\"images/avanzadas.png\" name=\"action\" value=\"advanced\"/>\n");
      out.write("                            </form>\n");
      out.write("                            <h5 align=\"center\">Vistas Avanzadas</h5>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"column\" type=\"left-rightpadd\" type=\"left-rightpadd\">\n");
      out.write("                            <form action=\"login\"   method=\"GET\">\n");
      out.write("                                <input type=\"image\" src=\"images/cuadernos.png\" name=\"action\" value=\"notebook\"/>\n");
      out.write("                            </form>\n");
      out.write("                            <h5 align=\"center\">Cuadernos</h5>\n");
      out.write("                        </div>\n");
      out.write("                        ");
 }
      out.write("\n");
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
      out.write("        <footer>\n");
      out.write("            Hey!\n");
      out.write("        </footer>\n");
      out.write("    </body>\n");
      out.write("</html>");
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
