<%-- 
    Document   : listaTotalPorRepartidor
    Created on : 23-11-2019, 21:55:33
    Author     : DAvil
--%>

<%@page import="cl.model.FeriaLibre"%>
<%@page import="cl.dao.DAOFeriaLibre"%>
<%@page import="cl.model.TipoProducto"%>
<%@page import="cl.dao.DAOtipoProducto"%>
<%@page import="com.sun.org.apache.bcel.internal.generic.Select"%>
<%@page import="cl.dao.DAOusuario"%>
<%@page import="cl.model.Usuario"%>

<%@page import="cl.model.ListaTotalPorRepartidor"%>
<%@page import="java.util.ArrayList"%>
<%@page import="cl.dao.DAOtotalReparto"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link href="http://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
        <!--Import materialize.css-->
        <link type="text/css" rel="stylesheet" href="css/materialize.min.css"  media="screen,projection"/>

        <!--favicon -->
        <link rel="shortcut icon" type="image/x-icon" href="img/phpThumb_generated_thumbnailico" />
        <!--Let browser know website is optimized for mobile-->
        <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>LISTA POR FERIA</title>
    </head>
    <body class="light-green lighten-5">
        <%
            Usuario cliente = (Usuario) session.getAttribute("usuario");
        %>
        <% if (cliente != null) { %>
        
        <div class="col s12">
            <jsp:include page="nav.jsp" />
         </div>
         <h3 class="left-align text-lighten-5"><b>LISTA POR FERIA</b></h3>
        <p><b>A CONTINUACIÓN, DEBERÁ SELECCIONAR UNA FERIA PARA GENERAR UNA TABLA CON TODAS LAS VENTAS REALIZADAS POR ESA FERIA SELECCIONADA. </b></p>
        <br>
         
         <form action="TotalFeria" method="post" >
            <div  class="input-field col s5" >
                <i class="material-icons prefix">add_location</i>
                <select   id="cboFeria" name="cboFeria"> 
                    <option value="" disabled selected >SELECCIONE FERIA</option>
                    <% 
                        DAOFeriaLibre feria = new DAOFeriaLibre();
                        ArrayList <FeriaLibre> listaFeria = feria.listarFeria();
                        for (FeriaLibre f : listaFeria){
                        
                           
                    %>
                    <option value="<%= f.getIdFeria() %>" ><%= f.getNombreFeria() %> <%= f.getComunaFeria() %> </option>
                <% }%> 
                </select>
                <label  >FERIA</label> 
                <button class="btn waves-effect waves-light light-green darken-4"  type="submit" value="cboFeria" onclick="return validar()">CONSULTAR
                <i class="material-icons right">send</i>
            </button>
            </div>
        </form>
        <% } else { %>
            <div class="row">
                <div class="col s12">
                    <h3>DEBE INICIAR SESIÓN PARA ACCEDER A LOS CONTENIDOS.</h3>
                   
                    <a href="index.jsp">IR AL LOGIN</a>
                </div>
            </div>
        <% }%>                            
</body>
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
               function validar()
            {
                
                var campoCombo = document.getElementById('cboFeria').value;
                if (campoCombo == null || campoCombo == 0 ) {
                    
                    M.toast({html: 'Debe seleccionar una feria', classes: 'rounded'});
 
                    return false;
                }else{
                    return true;
                }
            }
              

        </script>
</html>
