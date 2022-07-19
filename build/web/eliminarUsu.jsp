<%-- 
    Document   : eliminarUsu
    Created on : 25-may-2019, 20:33:36
    Author     : DAvil
--%>

<%@page import="cl.dao.DAOusuario"%>
<%@page import="cl.model.Usuario"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="cl.dao.Conectar"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        
                       <%
            Usuario cliente = (Usuario) session.getAttribute("usuario");
        %>
        <% if (cliente != null) { %>
        
  <%
    try {
    String id_usu = request.getParameter("ID_USUARIO");
    String consulta = "DELETE FROM usuario WHERE `ID_USUARIO` = "+id_usu+"";
    Connection con = Conectar.getConexion();
    PreparedStatement st = con.prepareStatement(consulta);
    st.executeUpdate();
    request.getRequestDispatcher("listaUsu.jsp").forward(request, response);
    st.close();
    } catch (Exception e) {
    }
    
%>
<% } else { %>
            <div class="row">
                <div class="col s12">
                    <h3>Debe iniciar sesión para acceder a los contenidos</h3>
                   
                    <a href="index.jsp">Ir al login</a>
                </div>
            </div>
            <% }%>
         
    </body>
</html>
