<%-- 
    Document   : RegistrarFeria
    Created on : 21-may-2019, 15:19:22
    Author     : DAvil
--%>

<%@page import="cl.model.Usuario"%>
<%@page import="java.util.ArrayList"%>
<%@page import="cl.model.ComboComuna"%>

<%@page import="cl.dao.DAOFeriaLibre"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
        
        <title>REGISTRAS FERIAS</title>
        
    </head>
    <body class="light-green lighten-5">
        <%
            Usuario cliente = (Usuario) session.getAttribute("usuario");
        %>
        <% if (cliente != null) { %>
        <div class="col s12">
            <jsp:include page="nav.jsp" />
        </div>
        <h3 class="left-align text-lighten-5"><b>REGISTRAR FERIA</b></h3>
        <p><b>A CONTINUACIÓN, SE DEBERÁ COMPLETAR DIFERENTES CAMPOS PARA PODER REGISTRAR FERIAS. </b></p>
        <form action="ingresarFeria" method="post" class="col s12">
            <div class="red-text center-align">
                    <p class="flow-text">${requestScope.msg}</p>
            </div>
            <div class="row">
              <div class="input-field col s5">
                <i class="material-icons prefix">filter_frames</i>
                <input name="txtNomFeria" id="" type="text"/>
                <label class="active" >NOMBRE FERIA</label>
            </div> 
            <div class="input-field col s5">
                <i class="material-icons prefix">description</i>
                <select name="cboComuna" >   
                    <option value="" disabled selected>SELECCIONE UNA COMUNA</option>
                    <% DAOFeriaLibre fer = new DAOFeriaLibre();
                        ArrayList <ComboComuna> listacomuna= fer.listarComuna();
                        for(ComboComuna com : listacomuna){ %>
                    <option value="<%= com.getIdComuna() %>"><%= com.getNomComuna() %> </option>
                <%}%>
                </select>
                <label for="cboComuna">COMUNA</label>   
            </div>
            </div>
            <div class="row">
                <div class="input-field col s5">
                    <i class="material-icons prefix">arrow_forward</i>
                    <input name="txtDireccion" id="" type="text"/>
                    <label class="active" >DIRECCIÓN</label>
                </div>
                <div class="center-align">    
                    <button class="btn waves-effect waves-light light-green darken-4" type="submit" name="action" value="registrar">REGISTRAR
                        <i class="material-icons right">send</i></br>
                    </button>
                </div>
            </div>
        </form>
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
                $('select').formSelect();
                M.updateTextFields();
                $(".dropdown-trigger").dropdown();
                $('select').material_select();
                $(".button-collapse").sideNav();
                
              });
   
        </script>
</html>
