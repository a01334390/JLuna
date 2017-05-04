package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta charset=\"utf-8\"/>\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\"/>\n");
      out.write("        <title>imakenotebooks | Welcome</title>\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://dhbhdrzi4tiry.cloudfront.net/cdn/sites/foundation.min.css\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"homeStyle.css\" rel='stylesheet' type='text/css'>\n");
      out.write("        <link href=\"https://cdnjs.cloudflare.com/ajax/libs/foundicons/3.0.0/foundation-icons.css\" rel='stylesheet' type='text/css'>\n");
      out.write("        <link rel=\"shortcut icon\" href=\"/favicon.ico\" type=\"image/x-icon\">\n");
      out.write("        <link rel=\"icon\" href=\"/favicon.ico\" type=\"image/x-icon\">\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <link href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.css\" rel=\"stylesheet\">\n");
      out.write("        <div class=\"full-width-testimonial\">\n");
      out.write("            <div class=\"full-width-testimonial-section\">\n");
      out.write("                <div class=\"full-width-testimonial-icon text-center\">\n");
      out.write("                    <svg version=\"1.1\" id=\"Layer_1\" xmlns=\"http://www.w3.org/2000/svg\" xmlns:xlink=\"http://www.w3.org/1999/xlink\" x=\"0px\" y=\"0px\"\n");
      out.write("                         width=\"41px\" height=\"34px\" viewBox=\"-235 240 41 34\" style=\"enable-background:new -235 240 41 34;\" xml:space=\"preserve\">\n");
      out.write("                    <path class=\"quote-path\" d=\"M-231.3,260.4c0-5,1.3-8.8,3.7-11.7c2.4-2.8,6-4.6,10.5-5.5v5c-3.5,1-6,2.8-7.1,5.5c-0.7,1.4-0.9,2.8-0.8,4\n");
      out.write("                          h8.1v12.8h-14.4V260.4z\"/>\n");
      out.write("                    <path class=\"quote-path\" d=\"M-212,260.4c0-5,1.3-8.8,3.7-11.7c2.4-2.8,6-4.6,10.5-5.5v5c-3.5,1-6,2.8-7.1,5.5c-0.7,1.4-0.9,2.8-0.8,4h8.1\n");
      out.write("                          v12.8H-212V260.4z\"/>\n");
      out.write("                    </svg>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"full-width-testimonial-content\">\n");
      out.write("                    <h5 class=\"full-width-testimonial-text\">Not made in China, made one by one by listening to good music\n");
      out.write("                    </h5>\n");
      out.write("                    <p class=\"full-width-testimonial-source\">Made in Mexico</p>\n");
      out.write("                    <span class=\"full-width-testimonial-source-context\">imakenotebooks</span>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("        <br>\n");
      out.write("        <br>\n");
      out.write("        <div class =\"row\">\n");
      out.write("            <div class =\"small-6 large-4 columns center-form\">\n");
      out.write("                <form data-abide name=\"login\" action=\"login\" method=\"POST\">\n");
      out.write("                    <div data-abide-error class=\"alert callout\" style=\"display: none;\">\n");
      out.write("                        <p><i class=\"fi-alert\"></i> There are some errors in your form.</p>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"form-icons\">\n");
      out.write("                        <h4>Iniciar Sesion</h4>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"input-group input-wrapper\">\n");
      out.write("                        <span class=\"input-group-label\">\n");
      out.write("                            <i class=\"fa fa-user\"></i>\n");
      out.write("                        </span>\n");
      out.write("                        <input class=\"input-group-field inputsi\" type=\"text\" placeholder=\"Nombre de usuario\" name=\"username\" required>\n");
      out.write("                        <span class=\"form-error\">\n");
      out.write("                            Yo, you had better fill this out, it's required.\n");
      out.write("                        </span>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"input-group\">\n");
      out.write("                        <span class=\"input-group-label\">\n");
      out.write("                            <i class=\"fa fa-unlock-alt\"></i>\n");
      out.write("                        </span>\n");
      out.write("                        <input class=\"input-group-field inputsi\" type=\"password\" placeholder=\"Password\" name=\"password\" required>\n");
      out.write("                        <span class=\"form-error\">Ingrese una contraseña</span>\n");
      out.write("                    </div>\n");
      out.write("                    <button class=\"button expanded\">Iniciar Sesion\n");
      out.write("                    </button><span class=\"forgot\"><a href=\".#\">¿Olvidaste tu contraseña?</a></span>\n");
      out.write("                </form>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
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
