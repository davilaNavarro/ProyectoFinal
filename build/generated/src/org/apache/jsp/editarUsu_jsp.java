package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.Connection;
import cl.dao.Conectar;
import cl.model.ComboComuna;
import java.util.ArrayList;
import cl.dao.DAOFeriaLibre;
import cl.dao.DAOusuario;
import cl.model.Usuario;

public final class editarUsu_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<!--Obtenemos el rut-->\n");
      out.write("\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("             <!--Import Google Icon Font-->\n");
      out.write("        <link href=\"http://fonts.googleapis.com/icon?family=Material+Icons\" rel=\"stylesheet\">\n");
      out.write("        <!--Import materialize.css-->\n");
      out.write("        <link type=\"text/css\" rel=\"stylesheet\" href=\"css/materialize.min.css\"  media=\"screen,projection\"/>\n");
      out.write("\n");
      out.write("        <!--favicon -->\n");
      out.write("        <link rel=\"shortcut icon\" type=\"image/x-icon\" href=\"img/phpThumb_generated_thumbnailico\" />\n");
      out.write("        <!--Let browser know website is optimized for mobile-->\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\"/>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Modificar usuario</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("            ");

            Usuario cliente = (Usuario) session.getAttribute("usuario");
        
      out.write("\n");
      out.write("        ");
 if (cliente != null) { 
      out.write("\n");
      out.write("        \n");
      out.write("        \n");
      out.write("        \n");
      out.write("        \n");
      out.write("        ");

           
//    String rut = request.getParameter("ID_USUARIO");
    ResultSet rs = null;
     try {
    
    String id_usu = request.getParameter("ID_USUARIO");
    String consulta = "select * from usuario where ID_USUARIO = '"+ id_usu +"'";
    Connection con = Conectar.getConexion();
    PreparedStatement st = con.prepareStatement(consulta);
    rs = st.executeQuery();
    while (rs.next()){
        
    

      out.write("\n");
      out.write("         \n");
      out.write("             <div class=\"col s12\">\n");
      out.write("            \n");
      out.write("                    ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "nav.jsp", out, false);
      out.write("\n");
      out.write("         </div>\n");
      out.write("                    \n");
      out.write("         \n");
      out.write("         <h3>Editar usuarios</h3>\n");
      out.write("         <form  action=\"\" >\n");
      out.write("            <table>\n");
      out.write("<!--                <div class=\"red-text center-align\">\n");
      out.write("                    <p class=\"flow-text\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${requestScope.msg}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</p>\n");
      out.write("                </div>-->\n");
      out.write("                <tr>\n");
      out.write("                    <td>Rut:</td>\n");
      out.write("                    <td><input name=\"txtRut\" id=\"\" type=\"text\" value=\"");
      out.print( rs.getString(2) );
      out.write("\" readonly=\"readonly\"/></td>\n");
      out.write("                </tr>\n");
      out.write("                <tr>\n");
      out.write("                    <td>Nombre:</td>\n");
      out.write("                    <td><input name=\"txtNombre\" id=\"\" type=\"text\" value=\"");
      out.print( rs.getString(3) );
      out.write("\" /></td>\n");
      out.write("                </tr>\n");
      out.write("                <tr>\n");
      out.write("                    <td>Apellido:</td>\n");
      out.write("                    <td><input name=\"txtApellido\" id=\"\" type=\"text\" value=\"");
      out.print( rs.getString(4) );
      out.write("\" /></td>\n");
      out.write("                </tr>\n");
      out.write("                <tr>\n");
      out.write("                    <td>Clave:</td>\n");
      out.write("                    <td><input name=\"txtClave\" id=\"\" type=\"text\" value=\"");
      out.print( rs.getString(5) );
      out.write("\"/></td>\n");
      out.write("                </tr>\n");
      out.write("                <tr>\n");
      out.write("                    <td>Nombre usuario:</td>\n");
      out.write("                    <td><input name=\"txtNombreUsuario\" id=\"\" type=\"text\" value=\"");
      out.print( rs.getString(6) );
      out.write("\"/></td>\n");
      out.write("                </tr>\n");
      out.write("                <tr>\n");
      out.write("                    <td>Correo:</td>\n");
      out.write("                    <td><input name=\"txtCorreo\" id=\"\" type=\"text\" value=\"");
      out.print( rs.getString(7) );
      out.write("\"/></td>\n");
      out.write("                </tr>\n");
      out.write("                <tr>\n");
      out.write("                    <td>Tipo:</td>\n");
      out.write("                    <td>\n");
      out.write("                    <select name=\"cboTipoUsu\"  value=\"");
      out.print( rs.getString(8) );
      out.write("\">   \n");
      out.write("                        <option value=\"\" disabled selected>Seleccione un tipo de usuario</option>\n");
      out.write("                        <option value=\"ADMINISTRADOR\">ADMINISTRADOR</option>\n");
      out.write("                        <option value=\"COMPRADOR\">COMPRADOR</option>\n");
      out.write("                        <option value=\"COMERCIANTE\">COMERCIANTE</option>\n");
      out.write("                        <option value=\"REPARTIDOR\">REPARTIDOR</option>\n");
      out.write("                    </select> \n");
      out.write("                    </td>\n");
      out.write("                </tr>\n");
      out.write("                <tr>\n");
      out.write("                    <td>Comuna:</td>\n");
      out.write("                    <td>\n");
      out.write("                        <select name=\"cboComuna\"  value=\"");
      out.print( rs.getString(9) );
      out.write("\">   \n");
      out.write("                    <option value=\"\" disabled selected>Seleccione una comuna</option>\n");
      out.write("                    ");
 DAOFeriaLibre fer = new DAOFeriaLibre();
                        ArrayList <ComboComuna> listacomuna= fer.listarComuna();
                        for(ComboComuna com : listacomuna){ 
      out.write("\n");
      out.write("                    \n");
      out.write("                    \n");
      out.write("                    <option value=\"");
      out.print( com.getIdComuna() );
      out.write('"');
      out.write('>');
      out.print( com.getNomComuna() );
      out.write(" </option>\n");
      out.write("                    ");
}
      out.write("\n");
      out.write("                </select>\n");
      out.write("                     </td>\n");
      out.write("                     <tr>\n");
      out.write("                    <td>Direccion:</td>\n");
      out.write("                    <td><input name=\"txtDireccion\" id=\"\" type=\"text\" value=\"");
      out.print( rs.getString(10) );
      out.write("\"/></td>\n");
      out.write("                    </tr>\n");
      out.write("                     \n");
      out.write("                        <div>\n");
      out.write("                    <button class=\"btn waves-effect waves-light\" type=\"submit\" name=\"btnModificar\" >Modificar\n");
      out.write("                        <i class=\"material-icons right\">send</i></br>\n");
      out.write("                    </button>\n");
      out.write("<!--<input type=\"submit\" name=\"btnModificar\" value=\"Editar usuario\">-->\n");
      out.write("            </div>\n");
      out.write("               \n");
      out.write("            </table>\n");
      out.write("\n");
      out.write("      ");

        
    }
//    request.getRequestDispatcher("listaUsu.jsp").forward(request, response);
    
    } catch (Exception e) {
    }
    
    if(request.getParameter("btnModificar") !=null){
   
        
    try {  
     
      
        String rutt = request.getParameter("txtRut");
        String nombre = request.getParameter("txtNombre").toUpperCase();
        String apellido = request.getParameter("txtApellido").toUpperCase();
        String clave = request.getParameter("txtClave");
        String nombre_usuario = request.getParameter("txtNombreUsuario");
        String correo = request.getParameter("txtCorreo").toUpperCase();
        String tipo = request.getParameter("cboTipoUsu");
        String comuna = request.getParameter("cboComuna");
        String direccion = request.getParameter("txtDireccion").toUpperCase();
    
    String consulta = "update usuario set NOMBRE='"+nombre+"', APELLIDOS='"+apellido+"', CLAVE='"+clave+"'  , NOMBRE_USUARIO='"+nombre_usuario+"', CORREO_ELECTRONICO='"+correo+"', TIPO ='"+tipo+"', ID_COMUNA ='"+comuna+"', DIRECCION='"+direccion+"' where RUT='"+rutt+"'";
    Connection con = Conectar.getConexion();
    PreparedStatement st = con.prepareStatement(consulta);
    st.executeUpdate(consulta);
    request.getRequestDispatcher("listaUsu.jsp").forward(request, response);
    
    
    }catch (Exception e) {
    }
}
    
      
      
      out.write("          \n");
      out.write("    ");
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
      out.write("         \n");
      out.write("         \n");
      out.write("         \n");
      out.write("         </body>\n");
      out.write("      <script type=\"text/javascript\" src=\"https://code.jquery.com/jquery-2.1.1.min.js\"></script>\n");
      out.write("        <script type=\"text/javascript\" src=\"js/materialize.min.js\"></script>\n");
      out.write("        <script>\n");
      out.write("            $(document).ready(function() {\n");
      out.write("                $('select').formSelect();\n");
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
