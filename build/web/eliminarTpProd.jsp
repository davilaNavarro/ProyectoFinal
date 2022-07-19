<%-- 
    Document   : eliminarTpProd
    Created on : 26-may-2019, 3:51:14
    Author     : DAvil
--%>

<%@page import="cl.model.Usuario"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="cl.dao.Conectar"%>
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
    String idtpProd = request.getParameter("ID_TIPO");
    String consulta = "DELETE FROM TIPO_PRODUCTO WHERE ID_TIPO = '"+ idtpProd+"'";
    Connection con = Conectar.getConexion();
    PreparedStatement st = con.prepareStatement(consulta);
    st.executeUpdate();
    request.getRequestDispatcher("listaTpProd.jsp").forward(request, response);
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
