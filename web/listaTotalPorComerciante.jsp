<%-- 
    Document   : listaTotalPorRepartidor
    Created on : 23-11-2019, 21:55:33
    Author     : DAvil
--%>

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
        <title>LISTA POR COMERCIANTE</title>
    </head>
    <body class="light-green lighten-5">
        <%
            Usuario cliente = (Usuario) session.getAttribute("usuario");
        %>
        <% if (cliente != null) { %>
        <div class="col s12">
            <jsp:include page="nav.jsp" />
        </div>
        <h3 class="left-align text-lighten-5"><b>LISTA POR COMERCIANTE</b></h3>
        <p><b>A CONTINUACIÓN, DEBERÁ SELECCIONAR UN COMERCIANTE PERMITIENDO GENERAR UNA TABLA CON TODAS LAS VENTAS REALIZADAS POR EL COMERCIANTE SELECCIOANDO.  </b></p>
        <p><b> </b></p>
        <br>
        <form action="TotalporComerciante" method="post" >
            <div  class="input-field col s5" >
                <i class="material-icons prefix">find_in_page</i>
                <select   id="cboComerciante" name="cboComerciante">   
                    <option value="" disabled selected >SELECCIONE COMERCIANTE</option>
                    <% 
                        DAOusuario comer = new DAOusuario();
                        ArrayList <Usuario> listaPorComer = comer.listarUsuarioComerciante();
                        for (Usuario u : listaPorComer) {
                    %>
                    <option value="<%= u.getRut() %>" ><%= u.getRut() %> <%= u.getNombre()%> <%= u.getApellidos() %> </option>
                    <% }%> 
                </select>
                <label>COMERCIANTES</label>  
                <button class="btn waves-effect waves-light light-green darken-4 "  type="submit"  onclick="return validar()">CONSULTAR
                <i class="material-icons right">send</i>
            </button>
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
                
                var campoCombo = document.getElementById('cboComerciante').value;
                if (campoCombo == null || campoCombo == 0 ) {
                    
                    M.toast({html: 'El campo que indica su rut no puede estar vacío', classes: 'rounded'});
 
                    return false;
                }else{
                    return true;
                }
                
            }

        </script>
</html>
