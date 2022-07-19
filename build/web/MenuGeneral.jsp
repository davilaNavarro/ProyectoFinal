<%-- 
    Document   : MenuGeneral
    Created on : 20-may-2019, 2:44:29
    Author     : DAvil
--%>

<%@page import="cl.model.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!--aqui dejamos el codigo para que nos tome la sesion-->

<!DOCTYPE html>
<html>
    <head>
          <!--Import Google Icon Font-->
        <link href="http://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
        <!--Import materialize.css-->
        <link type="text/css" rel="stylesheet" href="css/materialize.min.css"  media="screen,projection"/>

        <!--favicon -->
        <link rel="shortcut icon" type="image/x-icon" href="img/phpThumb_generated_thumbnailico" />
        <!--Let browser know website is optimized for mobile-->
        <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
        
        <title>MENÚ PRINCIPAL</title>
    </head>
    <body background="img/shutterstock_frutas.jpg" >
          <%
            Usuario cliente = (Usuario) session.getAttribute("usuario");
        %>
        <% if (cliente != null) { %>
        
        <div class="col s12">
            
                    <jsp:include page="nav.jsp" />
         </div>
        <div class="row light-green">
                
            </div>
                    <h1 class="black-text "><b>BIENVENIDA/O &nbsp;${sessionScope.usuario.nombre_usuario} </b></h1>
      <% } else { %>
            <div class="row">
                <div class="col s12">
                    <h3>DEBE INICIAR SESIÓN PARA ACCEDER A LOS CONTENIDOS. </h3>
                   
                    <a href="index.jsp">IR AL LOGIN</a>
                </div>
            </div>
            <% }%>
        
    </body>
     <!--Import jQuery before materialize.js-->
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
