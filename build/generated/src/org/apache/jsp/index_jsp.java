package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

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
      out.write("         <!--Import Google Icon Font-->\n");
      out.write("        <link href=\"http://fonts.googleapis.com/icon?family=Material+Icons\" rel=\"stylesheet\">\n");
      out.write("        <!--Import materialize.css-->\n");
      out.write("        <link type=\"text/css\" rel=\"stylesheet\" href=\"css/materialize.min.css\"  media=\"screen,projection\"/>\n");
      out.write("\n");
      out.write("        <!--favicon -->\n");
      out.write("        <link rel=\"shortcut icon\" type=\"image/x-icon\" href=\"img/phpThumb_generated_thumbnailico\" />\n");
      out.write("        <!--Let browser know website is optimized for mobile-->\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\"/>\n");
      out.write("        <title>Ferias Click</title>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("<!--        <title>JSP Page</title>-->\n");
      out.write("        <script src=\"js/main.js\"></script>\n");
      out.write("<!--    <img   src=\"img/mercado-europeos-frutas-verduras.jpg\">    -->\n");
      out.write("    </head>\n");
      out.write("    <body background=\"img/mercado-europeos-frutas-verduras.jpg\" >\n");
      out.write("           \n");
      out.write("       \n");
      out.write("      <div class=\"container\" >\n");
      out.write("          \n");
      out.write("            <div class=\"row\">\n");
      out.write("                <nav>\n");
      out.write("                    <div class=\"nav-wrapper center blue-grey white-text darken-1\" style=\"color: #99CC00\">\n");
      out.write("                        <h2><b>Ferias Click</b></h2>\n");
      out.write("<!--                        <a href=\"index.jsp\" class=\"brand-logo\">&nbsp;<img class=\"responsive-img\" src=\"img/LOGO BLANCO SOL Y PORTUARIOS.png\" width=\"120px\" style=\"margin-top: 15px\"></a>-->\n");
      out.write("                    </div>\n");
      out.write("                </nav>\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("            <div class=\"row\">\n");
      out.write("                <div class=\"col s10 offset-s1\">\n");
      out.write("<!--                    <h2><b>Feria Click</b></h2>-->\n");
      out.write("                    <b class=\"flow-text white-text s5\" align=\"justify\">Ferias Click es un aplicativo móvil que va orientado a la agilización de los procesos de comercialización de las ferias libres.</b>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("<!--            <div class=\"col s12\">\n");
      out.write("                <h4 class=\"center-align\"><b>Ingreso</b></h4>\n");
      out.write("            </div>-->\n");
      out.write("            <div class=\"col s6 offset-s3\">\n");
      out.write("                <div class=\"row\">\n");
      out.write("                    <form class=\"col s8 offset-s2 card-panel z-depth-5 transparent\"\n");
      out.write("                          action=\"iniciar\" method=\"post\" id=\"formingresar\">\n");
      out.write("                        <div class=\"col s12\">\n");
      out.write("                            <h4 class=\"center-align\"><b>Ingreso</b></h4>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"row\">\n");
      out.write("                            <div class=\"input-field col s6 black-text\">\n");
      out.write("                                <i class=\"material-icons  prefix\">account_circle</i>\n");
      out.write("                                <input id=\"icon_prefix\" type=\"text\" class=\"validate black-text\"\n");
      out.write("                                       name=\"txtNom_usuario\" id=\"txtNom_usuario\" />\n");
      out.write("                                <label for=\"icon_prefix\" class=\"black-text\"><h6><b>Usuario</b></h6></label>\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"input-field col s6 black-text \">\n");
      out.write("                                <i class=\"material-icons  prefix\">lock_outline</i>\n");
      out.write("                                <input id=\"icon_pass\" type=\"password\" class=\"validate black-text\"\n");
      out.write("                                       name=\"txtClave\" id=\"txtClave\"/>\n");
      out.write("                                <label for=\"icon_pass\" class=\"black-text\"  ><h6><b>Clave</b></h6></label>\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"center-align\">    \n");
      out.write("                                <button class=\"btn waves-effect waves-light\" type=\"submit\" name=\"action\" id=\"btninciar\" >Enviar\n");
      out.write("                                    <i class=\"material-icons right\">send</i>\n");
      out.write("                                </button>\n");
      out.write("                            </div>    \n");
      out.write("                        </div>\n");
      out.write("                    </form>\n");
      out.write("\n");
      out.write("                </div>\n");
      out.write("                <div class=\"red-text center-align\">\n");
      out.write("                    <p class=\"flow-text\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${requestScope.msg}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</p>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("            <footer class=\"page-footer blue-grey darken-1\">\n");
      out.write("                <div class=\"container\">\n");
      out.write("                    <div class=\"row\">\n");
      out.write("                        <div class=\"col l6 s12\">\n");
      out.write("                            <h5 class=\"white-text\"></h5>\n");
      out.write("                            <p class=\"grey-text text-lighten-4\"><a href=\"mailto:contacto@fundacionsol.cl\" style=\"color: #ffff00\"></a></p>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"footer-copyright\">\n");
      out.write("                    <div class=\"container\">\n");
      out.write("                        © 2019 FERIAS CLICK\n");
      out.write("                        <a class=\"grey-text text-lighten-4 right\">Página de administración Ferias Click</a>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </footer>\n");
      out.write("        </div>\n");
      out.write("        <!--Import jQuery before materialize.js-->\n");
      out.write("        <script type=\"text/javascript\" src=\"https://code.jquery.com/jquery-2.1.1.min.js\"></script>\n");
      out.write("        <script type=\"text/javascript\" src=\"js/materialize.min.js\"></script>\n");
      out.write("        <script>\n");
      out.write("            $(function () {\n");
      out.write("\n");
      out.write("                $(\".button-collapse\").sideNav();\n");
      out.write("            });\n");
      out.write("        </script>\n");
      out.write("    </body>\n");
      out.write("    \n");
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
