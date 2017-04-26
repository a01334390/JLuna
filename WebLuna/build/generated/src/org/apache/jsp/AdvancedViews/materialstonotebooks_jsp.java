package org.apache.jsp.AdvancedViews;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import AdvancedElements.NotebookMaterials;

public final class materialstonotebooks_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<html>\n");

    if (session.getAttribute("currentSessionName") == null) {
        response.sendRedirect("/index.jsp");
    }
    if (!session.getAttribute("currentPrivilegeLevel").equals("admin")) {
        response.sendRedirect("/index.jsp");
    }

      out.write("\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <meta charset=\"utf-8\"/>\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\"/>\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://dhbhdrzi4tiry.cloudfront.net/cdn/sites/foundation.min.css\">\n");
      out.write("        <link href=\"https://cdnjs.cloudflare.com/ajax/libs/foundicons/3.0.0/foundation-icons.css\" rel='stylesheet' type='text/css'>\n");
      out.write("        <title>Materiales a cuadernos</title>\n");
      out.write("        <link href=\"newStyling.css\" rel=\"stylesheet\" type=\"text/css\">\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <script src=\"../js/vendor/jquery.js\"></script>\n");
      out.write("        <script src=\"../js/vendor/what-input.js\"></script>\n");
      out.write("        <script src=\"../js/vendor/foundation.js\"></script>\n");
      out.write("        <script src=\"../js/app.js\"></script>\n");
      out.write("         <div class=\"top-bar-container\" data-sticky-container>\n");
      out.write("              <div class=\"sticky sticky-topbar\" data-sticky data-options=\"anchor: page; marginTop: 0; stickyOn: small;\">\n");
      out.write("                  <div class=\"top-bar blackbg\">\n");
      out.write("                      <div class=\"top-bar-left\">\n");
      out.write("                          <ul class=\"dropdown menu blackbg\" data-dropdown-menu>\n");
      out.write("                              <li class=\"menu-text whitetxt\">");
      out.print(session.getAttribute("currentSessionName"));
      out.write("</li>\n");
      out.write("                                   <li><a href=\"#\" class=\"whitetxt whitehover\">Ordenes por prioridad y fecha</a></li>\n");
      out.write("                                      <li><a href=\"#\" class=\"whitetxt whitehover\">Ordenes con mas clientes</a></li>\n");
      out.write("                                      <li><a href=\"#\" class=\"whitetxt whitehover\">Pedidos con mas beneficio</a></li>\n");
      out.write("                                      <li><a href=\"#\" class=\"whitetxt whitehover\">Asignar materiales</a></li>\n");
      out.write("                                      <li><a href=\"#\" class=\"whitetxt whitehover\">Macro vista</a></li>\n");
      out.write("                              <li class=\"whitetxt\"><a href=\"#\" class=\"whitetxt whitehover\">Vistas Basicas</a>\n");
      out.write("                              </li>\n");
      out.write("                      </div>\n");
      out.write("                      <div class=\"top-bar-right\">\n");
      out.write("                      </div>\n");
      out.write("                  </div>\n");
      out.write("              </div>\n");
      out.write("          </div>\n");
      out.write("                              <br>\n");
      out.write("                              <br>\n");
      out.write("                              <div class=\"notebookhd\"><h1>Asign materials to notebooks</h1></div>\n");
      out.write("    </body>\n");
      out.write("    <div class=\"formm\">\n");
      out.write("    <form action=\"MacroView\">\n");
      out.write("                        <table border=\"1\">\n");
      out.write("                            <thead>\n");
      out.write("                                <tr class=\"centeredform whitetxt\">\n");
      out.write("                                    <th>id cuaderno</th>\n");
      out.write("                                    <th>id material</th>\n");
      out.write("                                    <th>cantidad</th>\n");
      out.write("                                </tr>\n");
      out.write("                            </thead>\n");
      out.write("                            <tbody>\n");
      out.write("                                ");
 NotebookMaterials nm= new NotebookMaterials();
      out.write("\n");
      out.write("                                ");
 String id="0" ;
      out.write("\n");
      out.write("                                ");
      out.write("\n");
      out.write("                                ");
String semana[] = nm.getMaterials(id);
      out.write("\n");
      out.write("                                ");
for (int i = 0; i < semana.length; i++) {
      out.write("\n");
      out.write("                                <tr>\n");
      out.write("                                    ");
      out.write("\n");
      out.write("                                    ");
 String tabla[]= semana[i].split(", "); 
      out.write("\n");
      out.write("                                    <td>");
      out.print(tabla[0] );
      out.write("</td>\n");
      out.write("                                    <td>");
      out.print(tabla[1] );
      out.write("</td>\n");
      out.write("                                    <td>");
      out.print(tabla[2] );
      out.write("</td>\n");
      out.write("                                    \n");
      out.write("                                </tr>\n");
      out.write("                                ");
 } 
      out.write("\n");
      out.write("                            </tbody>\n");
      out.write("                        </table>   \n");
      out.write("    </form>\n");
      out.write("    </div>\n");
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
