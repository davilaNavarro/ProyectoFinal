<%-- 
    Document   : listaFeria
    Created on : 21-may-2019, 3:30:18
    Author     : DAvil
--%>
<%@page import="cl.model.Usuario"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="cl.model.FeriaLibre"%>
<%@page import="java.util.ArrayList"%>
<%@page import="cl.dao.DAOFeriaLibre"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>       <!--Import Google Icon Font-->
        <link href="http://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
        <!--Import materialize.css-->
        <link type="text/css" rel="stylesheet" href="css/materialize.min.css"  media="screen,projection"/>

        <!--favicon -->
        <link rel="shortcut icon" type="image/x-icon" href="img/phpThumb_generated_thumbnailico" />
        <!--Let browser know website is optimized for mobile-->
        <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>LISTA FERIA</title>
       
    </head>
    <body class="light-green lighten-5">
        <%
            Usuario cliente = (Usuario) session.getAttribute("usuario");
        %>
        <% if (cliente != null) { %>
        <div class="col s12">
            <jsp:include page="nav.jsp" />
        </div>
        <h3 class="left-align text-lighten-5"><b>LISTA FERIA</b></h3>
     
        <p><b>A CONTINUACIÓN, SE DESPLEGARÁ LA TABLA CON LAS FERIAS REGISTRADAS.  </b></p>
        
        <center>
        <table class="responsive-table" >
        <thead>
            <tr class="light-green darken-1" >
              <th>NOMBRE FERIA</th>
              <th>COMUNA</th>
              <th>DIRECCIÓN</th>
              <th class="center-align">ACCIÓN</th>
          </tr>
        </thead>
        <tbody>
      <% 
            DAOFeriaLibre fer = new DAOFeriaLibre();
            ArrayList <FeriaLibre> listaFeria = fer.listarFeria();
            for (FeriaLibre f : listaFeria) {
       %>
         <tr align ='center' class="light-green accent-1">
            <td><%= f.getNombreFeria() %> </td>
            <td><%=  fer.obtenerComuna(f.getComunaFeria()) %> </td>
            <td><%= f.getDireccionFeria() %> </td>
            <td >
                    <a href="editarFer.jsp?ID_FERIA=<%= f.getIdFeria()%>">
                        <i  class="small material-icons" >edit</i>
                    </a>
                    <a href="eliminarFer.jsp?ID_FERIA=<%= f.getIdFeria() %>">
                        <i class="small material-icons">close</i>
                    </a>
            </td>
        </tr>
      <%          
            }
      %> 
        </tbody>
        
    </table>
</center>
        <% } else { %>
            <div class="row">
                <div class="col s12">
                    <h3>DEBE INICIAR SESIÓN PARA ACCEDER A LOS CONTENIDOS. </h3>
                   
                    <a href="index.jsp">IR AL LOGIN</a>
                </div>
            </div>
            <% }%>
         
    </body>
    <script type="text/javascript" src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
        <script type="text/javascript" src="js/materialize.min.js"></script>
        <script>
            $(document).ready(function() {
                M.updateTextFields();
                $(".dropdown-trigger").dropdown();
                $('select').material_select();
                $(".button-collapse").sideNav();
              });
        </script>
</html>
