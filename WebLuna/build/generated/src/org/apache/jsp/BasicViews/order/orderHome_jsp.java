package org.apache.jsp.BasicViews.order;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import BasicElements.Cliente;
import DatabaseManager.Handler;

public final class orderHome_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta charset=\"utf-8\"/>\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\"/>\n");
      out.write("        <title>Clientes</title>\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://dhbhdrzi4tiry.cloudfront.net/cdn/sites/foundation.min.css\">\n");
      out.write("        <link href=\"https://cdnjs.cloudflare.com/ajax/libs/foundicons/3.0.0/foundation-icons.css\" rel='stylesheet' type='text/css'>\n");
      out.write("        <link href=\"orderStyling.css\" rel=\"stylesheet\" type=\"text/css\">\n");
      out.write("        <link rel=\"shortcut icon\" href=\"/favicon.ico\" type=\"image/x-icon\">\n");
      out.write("        <link rel=\"icon\" href=\"/favicon.ico\" type=\"image/x-icon\">\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("         <link href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.css\" rel=\"stylesheet\">\n");
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
      out.write("                            <li><a href=\"#\" class=\"whitetxt whitehover\">Pedidos</a></li>\n");
      out.write("                            <li><a href=\"#\" class=\"whitetxt whitehover\">Inventario</a></li>\n");
      out.write("                            <li><a href=\"#\" class=\"whitetxt whitehover\">Clientes</a></li>\n");
      out.write("                            <li><a href=\"#\" class=\"whitetxt whitehover\">Materiales</a></li>\n");
      out.write("                            <li><a href=\"#\" class=\"whitetxt whitehover\">Usuarios</a></li>\n");
      out.write("                            <li><a href=\"#\" class=\"whitetxt whitehover\">Cuadernos</a></li>\n");
      out.write("                            <li class=\"has-submenu whitetxt\">\n");
      out.write("                                <a href=\"#\" class=\"whitetxt whitehover\">Vistas Avanzadas</a>\n");
      out.write("                                <ul class=\"submenu menu vertical blackbg\" data-submenu>\n");
      out.write("                                    <li><a href=\"#\" class=\"whitetxt whitehover\">Ordenes por prioridad y fecha</a></li>\n");
      out.write("                                    <li><a href=\"#\" class=\"whitetxt whitehover\">Ordenes con mas clientes</a></li>\n");
      out.write("                                    <li><a href=\"#\" class=\"whitetxt whitehover\">Pedidos con mas beneficio</a></li>\n");
      out.write("                                    <li><a href=\"#\" class=\"whitetxt whitehover\">Asignar materiales</a></li>\n");
      out.write("                                    <li><a href=\"#\" class=\"whitetxt whitehover\">Macro vista</a></li>\n");
      out.write("                                </ul>\n");
      out.write("                            </li>\n");
      out.write("                        </ul>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"top-bar-right\">\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("        <br>\n");
      out.write("        <br>\n");
      out.write("        <div class=\"notebookhd\"><h1 class=\"whitetxt\">orders</h1></div>\n");
      out.write("        <br>\n");
      out.write("        <div class=\"formm\">\n");
      out.write("        <form action=\"Order\" method=\"GET\">\n");
      out.write("            <table border=\"1\">\n");
      out.write("                <thead>\n");
      out.write("                    <tr class=\"whitetxt\">\n");
      out.write("                        <th>ID del Cliente</th>\n");
      out.write("                        <th>Primer Nombre</th>\n");
      out.write("                        <th>Segundo Nombre</th>\n");
      out.write("                        <th>Acciones</th>\n");
      out.write("                    </tr>\n");
      out.write("                </thead>\n");
      out.write("                <tbody>\n");
      out.write("                    ");
Cliente[] clients = Handler.getAllClients();
      out.write("\n");
      out.write("                    ");
for (int i = 0; i < clients.length; i++) {
      out.write("\n");
      out.write("                    <tr>\n");
      out.write("                        <td>");
      out.print(clients[i].getId());
      out.write("</td>\n");
      out.write("                        <td>");
      out.print(clients[i].getFirst_name());
      out.write("</td>\n");
      out.write("                        <td>");
      out.print(clients[i].getSecond_name());
      out.write("</td>\n");
      out.write("                        <td><a href=\"Order?action=see&userID=");
      out.print(clients[i].getId());
      out.write("\" class=\"nonblue\"><i class=\"fa fa-eye\"></i>Ver sus pedidos</a></td>\n");
      out.write("                    </tr>\n");
      out.write("                    ");
 }
      out.write("\n");
      out.write("                </tbody>\n");
      out.write("            </table>\n");
      out.write("        </form>\n");
      out.write("        </div>\n");
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
