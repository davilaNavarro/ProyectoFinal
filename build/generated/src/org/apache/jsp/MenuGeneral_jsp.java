package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import cl.model.Usuario;

public final class MenuGeneral_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!--aqui dejamos el codigo para que nos tome la sesion-->\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("          <!--Import Google Icon Font-->\n");
      out.write("        <link href=\"http://fonts.googleapis.com/icon?family=Material+Icons\" rel=\"stylesheet\">\n");
      out.write("        <!--Import materialize.css-->\n");
      out.write("        <link type=\"text/css\" rel=\"stylesheet\" href=\"css/materialize.min.css\"  media=\"screen,projection\"/>\n");
      out.write("\n");
      out.write("        <!--favicon -->\n");
      out.write("        <link rel=\"shortcut icon\" type=\"image/x-icon\" href=\"img/phpThumb_generated_thumbnailico\" />\n");
      out.write("        <!--Let browser know website is optimized for mobile-->\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\"/>\n");
      out.write("        \n");
      out.write("        <title>Menu principal</title>\n");
      out.write("    </head>\n");
      out.write("    <body background=\"img/shutterstock_frutas.jpg\" >\n");
      out.write("          ");

            Usuario cliente = (Usuario) session.getAttribute("usuario");
        
      out.write("\n");
      out.write("        ");
 if (cliente != null) { 
      out.write("\n");
      out.write("        \n");
      out.write("        <div class=\"col s12\">\n");
      out.write("            \n");
      out.write("                    ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "nav.jsp", out, false);
      out.write("\n");
      out.write("         </div>\n");
      out.write("        <div class=\"row\">\n");
      out.write("                \n");
      out.write("            </div>\n");
      out.write("                    <h1 class=\"black-text\"><b>Bienvenida/o: &nbsp;");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${sessionScope.usuario.nombre_usuario}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write(" </b></h1>\n");
      out.write("      ");
 } else { 
      out.write("\n");
      out.write("            <div class=\"row\">\n");
      out.write("                <div class=\"col s12\">\n");
      out.write("                    <h3>Debe iniciar sesión para acceder a los contenidos</h3>\n");
      out.write("                   \n");
      out.write("                    <a href=\"index.jsp\">Ir al login</a>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("            ");
 }
      out.write("\n");
      out.write("        \n");
      out.write("    </body>\n");
      out.write("     <!--Import jQuery before materialize.js-->\n");
      out.write("        <script type=\"text/javascript\" src=\"https://code.jquery.com/jquery-2.1.1.min.js\"></script>\n");
      out.write("        <script type=\"text/javascript\" src=\"js/materialize.min.js\"></script>\n");
      out.write("        <script>\n");
      out.write("            $(document).ready(function() {\n");
      out.write("                M.updateTextFields();\n");
      out.write("                $(\".dropdown-trigger\").dropdown();\n");
      out.write("                $('select').material_select();\n");
      out.write("                $(\".button-collapse\").sideNav();\n");
      out.write("              });\n");
      out.write("        </script>\n");
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
