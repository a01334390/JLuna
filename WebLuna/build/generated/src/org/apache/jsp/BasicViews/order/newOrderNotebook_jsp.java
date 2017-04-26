package org.apache.jsp.BasicViews.order;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import BasicElements.Notebook;
import DatabaseManager.Handler;
import BasicElements.OrderNotebooks;

public final class newOrderNotebook_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_forEach_var_items;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_out_value_nobody;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _jspx_tagPool_c_forEach_var_items = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_c_out_value_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _jspx_tagPool_c_forEach_var_items.release();
    _jspx_tagPool_c_out_value_nobody.release();
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
      out.write("        <title>Forma de Cuadernos</title>\n");
      out.write("        <link href=\"customStyling.css\" rel=\"stylesheet\" type=\"text/css\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://dhbhdrzi4tiry.cloudfront.net/cdn/sites/foundation.min.css\">\n");
      out.write("        <link href=\"https://cdnjs.cloudflare.com/ajax/libs/foundicons/3.0.0/foundation-icons.css\" rel='stylesheet' type='text/css'>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <div class=\"translucent-form-overlay\">\n");
      out.write("            <form action=\"ONotebook\" method=\"POST\" name=\"OrderForm\" data-abide>\n");
      out.write("                <h3>A&#241adir un nuevo set de cuadernos al pedido</h3>\n");
      out.write("                <div class=\"row columns\">\n");
      out.write("                        <input type=\"text\" readonly=\"readonly\" name=\"action\" value=\"");
      if (_jspx_meth_c_out_0(_jspx_page_context))
        return;
      out.write("\"/>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"row columns\">\n");
      out.write("                        <input type=\"text\" readonly=\"readonly\" name=\"clientID\" value=\"");
      if (_jspx_meth_c_out_1(_jspx_page_context))
        return;
      out.write("\"/>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"row columns\">\n");
      out.write("                    <label>Clave de la Orden\n");
      out.write("                        <input type=\"text\" readonly=\"readonly\" name=\"idOrder\" value=\"");
      if (_jspx_meth_c_out_2(_jspx_page_context))
        return;
      out.write("\"/>\n");
      out.write("                    </label>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"row columns\">\n");
      out.write("                    <label> Cuadernos\n");
      out.write("                            <select name=\"id_Notebook\" required>                               \n");
      out.write("                                ");
      if (_jspx_meth_c_forEach_0(_jspx_page_context))
        return;
      out.write("\n");
      out.write("                            </select>\n");
      out.write("                    </label>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"row columns\">\n");
      out.write("                    <label>Cantidad de cuadernos\n");
      out.write("                        <input type=\"text\" required name=\"quantity\" value=\"");
      if (_jspx_meth_c_out_3(_jspx_page_context))
        return;
      out.write("\"/>\n");
      out.write("                    </label>\n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("                <div class=\"row columns\">\n");
      out.write("                    <label> Status de la orden\n");
      out.write("                        <select name=\"status\" type=\"text\" required>\n");
      out.write("                            <option value=\"Design\" ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${on.getStatus() == \"Design\" ? 'selected=\"selected\"' : ''}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("> Diseño</option>\n");
      out.write("                            <option value=\"Preview\" ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${on.getStatus() == \"Preview\" ? 'selected=\"selected\"' : ''}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write(">Preview</option>\n");
      out.write("                            <option value=\"Laminado\" ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${on.getStatus() == \"Laminado\" ? 'selected=\"selected\"' : ''}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write(">Laminado</option>\n");
      out.write("                            <option value=\"Revision\" ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${on.getStatus() == \"Revision\" ? 'selected=\"selected\"' : ''}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write(">Revision</option>\n");
      out.write("                            <option value=\"Prensa\" ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${on.getStatus() == \"Prensa\" ? 'selected=\"selected\"' : ''}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write(">Prensa</option>\n");
      out.write("                            <option value=\"Embalaje\" ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${on.getStatus() == \"Embalaje\" ? 'selected=\"selected\"' : ''}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write(">Embalaje</option>\n");
      out.write("                            <option value=\"Envio\" ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${on.getStatus() == \"Envio\" ? 'selected=\"selected\"' : ''}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write(">Envio</option>\n");
      out.write("                            <option value=\"Entregado\" ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${on.getStatus() == \"Entregado\" ? 'selected=\"selected\"' : ''}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write(">Entregado</option>\n");
      out.write("                        </select>\n");
      out.write("                    </label>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"row columns\">\n");
      out.write("                    <label> Liston\n");
      out.write("                        <select name=\"ribbon\" type=\"text\" required>\n");
      out.write("                            <option value=\"B\" ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${on.getRibbon() == \"B\" ? 'selected=\"selected\"' : ''}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write(">Negro</option>\n");
      out.write("                            <option value=\"W\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${on.getRibbon() == \"W\" ? 'selected=\"selected\"' : ''}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write(">Blanco</option>\n");
      out.write("                             <option value=\"RED\" ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${on.getRibbon() == \"RED\" ? 'selected=\"selected\"' : ''}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write(">Rojo</option>\n");
      out.write("                            <option value=\"BLUE\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${on.getRibbon() == \"BLUE\" ? 'selected=\"selected\"' : ''}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write(">Azul</option>\n");
      out.write("                             <option value=\"GREEN\" ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${on.getRibbon() == \"GREEN\" ? 'selected=\"selected\"' : ''}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write(">Verde</option>\n");
      out.write("                            <option value=\"PURPLE\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${on.getRibbon() == \"PURPLE\" ? 'selected=\"selected\"' : ''}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write(">Morado</option>\n");
      out.write("                             <option value=\"ORANGE\" ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${on.getRibbon() == \"ORANGE\" ? 'selected=\"selected\"' : ''}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write(">Naranja</option>\n");
      out.write("                            <option value=\"NONE\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${on.getRibbon() == \"NONE\" ? 'selected=\"selected\"' : ''}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write(">Ninguno</option>\n");
      out.write("                        </select>\n");
      out.write("                    </label>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"row columns\">\n");
      out.write("                    <label> Elastico\n");
      out.write("                        <select name=\"elastic\" type=\"text\" required>\n");
      out.write("                            <option value=\"Y\" ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${on.getElastic() == \"Y\" ? 'selected=\"selected\"' : ''}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write(">Si</option>\n");
      out.write("                            <option value=\"N\" ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${on.getElastic() == \"N\" ? 'selected=\"selected\"' : ''}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write(">No</option>\n");
      out.write("                        </select>\n");
      out.write("                    </label>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"row columns\">\n");
      out.write("                    <label> Tipo de hojas\n");
      out.write("                        <select name=\"pageType\" type=\"text\" required>\n");
      out.write("                            <option value=\"PLAIN\"  ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${on.getPageType() == \"PLAIN\" ? 'selected=\"selected\"' : ''}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write(">Plano</option>\n");
      out.write("                            <option value=\"LINED\"  ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${on.getPageType() == \"LINED\" ? 'selected=\"selected\"' : ''}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write(">Rayado</option>\n");
      out.write("                            <option value=\"DOTTED\"  ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${on.getPageType() == \"LINED\" ? 'selected=\"selected\"' : ''}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write(">Punteado</option>\n");
      out.write("                            <option value=\"AGENDA\"  ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${on.getPageType() == \"AGENDA\" ? 'selected=\"selected\"' : ''}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write(">Agenda</option>\n");
      out.write("                        </select>\n");
      out.write("                    </label>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"row columns\">\n");
      out.write("                    <label>Link de la imagen\n");
      out.write("                        <input placeholder=\"http://www.imgur.com/img/something\" required type=\"text\"  name=\"image\" value=\"");
      if (_jspx_meth_c_out_4(_jspx_page_context))
        return;
      out.write("\"/>\n");
      out.write("                    </label>\n");
      out.write("                </div>\n");
      out.write("                <input type=\"submit\" class=\"primary button expanded search-button\" value=\"Modificar\"/>\n");
      out.write("            </form>\n");
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

  private boolean _jspx_meth_c_out_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:out
    org.apache.taglibs.standard.tag.rt.core.OutTag _jspx_th_c_out_0 = (org.apache.taglibs.standard.tag.rt.core.OutTag) _jspx_tagPool_c_out_value_nobody.get(org.apache.taglibs.standard.tag.rt.core.OutTag.class);
    _jspx_th_c_out_0.setPageContext(_jspx_page_context);
    _jspx_th_c_out_0.setParent(null);
    _jspx_th_c_out_0.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${action}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    int _jspx_eval_c_out_0 = _jspx_th_c_out_0.doStartTag();
    if (_jspx_th_c_out_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_out_value_nobody.reuse(_jspx_th_c_out_0);
      return true;
    }
    _jspx_tagPool_c_out_value_nobody.reuse(_jspx_th_c_out_0);
    return false;
  }

  private boolean _jspx_meth_c_out_1(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:out
    org.apache.taglibs.standard.tag.rt.core.OutTag _jspx_th_c_out_1 = (org.apache.taglibs.standard.tag.rt.core.OutTag) _jspx_tagPool_c_out_value_nobody.get(org.apache.taglibs.standard.tag.rt.core.OutTag.class);
    _jspx_th_c_out_1.setPageContext(_jspx_page_context);
    _jspx_th_c_out_1.setParent(null);
    _jspx_th_c_out_1.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${client}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    int _jspx_eval_c_out_1 = _jspx_th_c_out_1.doStartTag();
    if (_jspx_th_c_out_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_out_value_nobody.reuse(_jspx_th_c_out_1);
      return true;
    }
    _jspx_tagPool_c_out_value_nobody.reuse(_jspx_th_c_out_1);
    return false;
  }

  private boolean _jspx_meth_c_out_2(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:out
    org.apache.taglibs.standard.tag.rt.core.OutTag _jspx_th_c_out_2 = (org.apache.taglibs.standard.tag.rt.core.OutTag) _jspx_tagPool_c_out_value_nobody.get(org.apache.taglibs.standard.tag.rt.core.OutTag.class);
    _jspx_th_c_out_2.setPageContext(_jspx_page_context);
    _jspx_th_c_out_2.setParent(null);
    _jspx_th_c_out_2.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${orderNumber}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    int _jspx_eval_c_out_2 = _jspx_th_c_out_2.doStartTag();
    if (_jspx_th_c_out_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_out_value_nobody.reuse(_jspx_th_c_out_2);
      return true;
    }
    _jspx_tagPool_c_out_value_nobody.reuse(_jspx_th_c_out_2);
    return false;
  }

  private boolean _jspx_meth_c_forEach_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_forEach_0 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _jspx_tagPool_c_forEach_var_items.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    _jspx_th_c_forEach_0.setPageContext(_jspx_page_context);
    _jspx_th_c_forEach_0.setParent(null);
    _jspx_th_c_forEach_0.setVar("item");
    _jspx_th_c_forEach_0.setItems((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${nb}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    int[] _jspx_push_body_count_c_forEach_0 = new int[] { 0 };
    try {
      int _jspx_eval_c_forEach_0 = _jspx_th_c_forEach_0.doStartTag();
      if (_jspx_eval_c_forEach_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\n");
          out.write("                                    <option value=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${item.getId()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write('"');
          out.write(' ');
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${item.getId() == on.getId_Notebook() ? 'selected=\"selected\"' : ''}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write('>');
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${item.getType()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</option>\n");
          out.write("                                ");
          int evalDoAfterBody = _jspx_th_c_forEach_0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_forEach_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_c_forEach_0[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_c_forEach_0.doCatch(_jspx_exception);
    } finally {
      _jspx_th_c_forEach_0.doFinally();
      _jspx_tagPool_c_forEach_var_items.reuse(_jspx_th_c_forEach_0);
    }
    return false;
  }

  private boolean _jspx_meth_c_out_3(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:out
    org.apache.taglibs.standard.tag.rt.core.OutTag _jspx_th_c_out_3 = (org.apache.taglibs.standard.tag.rt.core.OutTag) _jspx_tagPool_c_out_value_nobody.get(org.apache.taglibs.standard.tag.rt.core.OutTag.class);
    _jspx_th_c_out_3.setPageContext(_jspx_page_context);
    _jspx_th_c_out_3.setParent(null);
    _jspx_th_c_out_3.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${on.getQuantity()}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    int _jspx_eval_c_out_3 = _jspx_th_c_out_3.doStartTag();
    if (_jspx_th_c_out_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_out_value_nobody.reuse(_jspx_th_c_out_3);
      return true;
    }
    _jspx_tagPool_c_out_value_nobody.reuse(_jspx_th_c_out_3);
    return false;
  }

  private boolean _jspx_meth_c_out_4(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:out
    org.apache.taglibs.standard.tag.rt.core.OutTag _jspx_th_c_out_4 = (org.apache.taglibs.standard.tag.rt.core.OutTag) _jspx_tagPool_c_out_value_nobody.get(org.apache.taglibs.standard.tag.rt.core.OutTag.class);
    _jspx_th_c_out_4.setPageContext(_jspx_page_context);
    _jspx_th_c_out_4.setParent(null);
    _jspx_th_c_out_4.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${on.getImage()}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    int _jspx_eval_c_out_4 = _jspx_th_c_out_4.doStartTag();
    if (_jspx_th_c_out_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_out_value_nobody.reuse(_jspx_th_c_out_4);
      return true;
    }
    _jspx_tagPool_c_out_value_nobody.reuse(_jspx_th_c_out_4);
    return false;
  }
}
