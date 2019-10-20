package org.apache.jsp.view;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class contact_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<String>(3);
    _jspx_dependants.add("/view/header.jsp");
    _jspx_dependants.add("/view/slide-bar.jsp");
    _jspx_dependants.add("/view/footer.jsp");
  }

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
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Home</title>\n");
      out.write("        <link href=\"css/style.css\" rel=\"stylesheet\" type=\"text/css\"/>\n");
      out.write("        <link href=\"css/contact.css\" rel=\"stylesheet\" type=\"text/css\"/>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <div class=\"container\">\n");
      out.write("            ");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<div id=\"header\">\n");
      out.write("    <div id=\"logo\">\n");
      out.write("        <div class=\"title\">Maria Bagnarelli's Cafe</div>\n");
      out.write("        <div class=\"sub-title\">Welcome to my website</div>\n");
      out.write("    </div>\n");
      out.write("    <div id=\"menu\">\n");
      out.write("        <div class=\"menu-item\">\n");
      out.write("            <a href=\"home\" class=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${active == \"home\"?\"active\":\"\"}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\">Home</a>\n");
      out.write("        </div>\n");
      out.write("        <div class=\"menu-item\">\n");
      out.write("            <a href=\"about-cake\" class=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${active == \"about-cake\"?\"active\":\"\"}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\">About my Cakes</a>\n");
      out.write("        </div>\n");
      out.write("        <div class=\"menu-item\">\n");
      out.write("            <a href=\"contact\" class=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${active == \"contact\"?\"active\":\"\"}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\">Find Maria's Cafe</a>\n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("</div>");
      out.write("\n");
      out.write("            <div id=\"content\">\n");
      out.write("                <div id=\"left-content\">\n");
      out.write("                    <div id=\"banner\" class=\"seperator-bottom-dotted\">\n");
      out.write("                        <p class=\"heading\">Find Maria's Cafe</p>\n");
      out.write("                        <div  id=\"contact-left\">\n");
      out.write("                            <p class=\"title\">Address and contact:</p>\n");
      out.write("                            <p id=\"address\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${contact.address}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</p>\n");
      out.write("                            <p id=\"tel\">Tel: ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${contact.tel}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</p>\n");
      out.write("                            <p id=\"email\">Email: ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${contact.email}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</p>\n");
      out.write("                        </div>\n");
      out.write("                        <div id=\"contact-right\">\n");
      out.write("                            <p class=\"title\">Opening hours:</p>\n");
      out.write("                            <div id=\"hour\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${contact.workingHour}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</div>\n");
      out.write("                        </div>\n");
      out.write("                        <br class=\"clear-fix\"/>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"\" id=\"map\">\n");
      out.write("                        <img src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${contact.mapPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\"/>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("                ");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<div id=\"right-content\">\n");
      out.write("    <div>\n");
      out.write("        <span class=\"heading\">Share this page</span>\n");
      out.write("        <div>\n");
      out.write("            <a href=\"#\"><img id=\"share-facebook\" class=\"logo-icon\"><span>Share on Facebook</span></a>\n");
      out.write("            <a href=\"#\"><img id=\"share-twtter\" class=\"logo-icon\"><span>Share on Twitter</span></a>\n");
      out.write("            <a href=\"#\"><img id=\"share-google\" class=\"logo-icon\"><span>Share on Google+</span></a>\n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("</div>  ");
      out.write("\n");
      out.write("                <br class=\"clear-fix\"/>\n");
      out.write("            </div>\n");
      out.write("            ");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<div id=\"footer\" class=\"seperator-bottom-solid\" >\n");
      out.write("    <a href=\"#\">Created with SimpleSite</a>\n");
      out.write("</div>");
      out.write("\n");
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
