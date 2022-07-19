<%-- 
    Document   : listaTotalesRepar
    Created on : 26-may-2019, 20:16:51
    Author     : DAvil
--%>

<%@page import="cl.model.Usuario"%>
<%@page import="cl.dao.DAOusuario"%>
<%@page import="cl.model.MensualesRepar"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="cl.model.totalesReparto"%>
<%@page import="java.util.ArrayList"%>
<%@page import="cl.dao.DAOtotalReparto"%>
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
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>REPORTE VENTAS POR COMERCIANTE</title>
    </head>
    <body class="light-green lighten-5">
        <%
            Usuario cliente = (Usuario) session.getAttribute("usuario");
        %>
        <% if (cliente != null) { %>
        <div class="col s12">
            <jsp:include page="nav.jsp" />
        </div>  
        <h3 class="left-align text-lighten-5"><b>REPORTE DE VENTAS POR COMERCIANTE</b></h3>
        <p><b>A CONTINUACIÓN, DEBERÁ SELECCIONAR UN COMERCIANTE Y FECHAS PERMITIENDO GENERAR UNA TABLA CON TOTAS LAS VENTAS REALIZADAS POR COMERCIANTE SELECCIONADO.  </b></p>
        <br>
         <form action="ComerciantesPorFechas" method="post" class="col s12 ">
            <div class="red-text center-align">
                    <p class="flow-text">${requestScope.msg}</p>
            </div>
            <div class="row">
                <div class="input-field col s5">
                    <i class="material-icons prefix">find_in_page</i>
                    <select   id="cboComerciante" name="cboComerciante">   
                    <option value="" disabled selected >SELECCIONE COMERCIANTE</option>
                    <% 
                        DAOusuario comer = new DAOusuario();
                        ArrayList <Usuario> listaPorComer = comer.listarUsuarioComerciante();
                        
                        for (Usuario u : listaPorComer) {
                           
                    %>
                        <option value="<%= u.getId_usuario() %>" ><%= u.getRut() %> <%= u.getNombre()%> <%= u.getApellidos() %> </option>
                    <% }%> 
                    </select>
                    <label>COMERCIANTES</label> 
                </div> 
            <div class="input-field col s5">
                 <i class="material-icons prefix">today</i>
                <input id="txtfechaDesde" name="txtfechaDesde" type="date" class="datepicker">
                <label class="active" >FECHAS DESDE</label>
            </div>
            <div class="input-field col s5">
                 <i class="material-icons prefix">today</i>
                <input id="txtfechaHasta" name="txtfechaHasta" type="date" class="datepicker">
                <label class="active" >FECHA HASTA</label>
            </div>
        </div>
            <div class="center-align">    
                <button  name="btnIdusuario" class="btn waves-effect waves-light light-green darken-4" type="submit" name="action" onclick=" return validar(); return validarFecha()">CONSULTAR
                        <i  class="material-icons right">send</i></br>
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
    <!--Import jQuery before materialize.js-->
        <script type="text/javascript" src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
        <script type="text/javascript" src="js/materialize.min.js"></script>
        <script>
            
            $(document).ready(function(){
                $('select').formSelect();
                
                $('.datepicker').datepicker({
                    format: 'yyyy-mm-dd',
                    i18n: {
                        months: ["Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"],
                        monthsShort: ["Ene", "Feb", "Mar", "Abr", "May", "Jun", "Jul", "Ago", "Set", "Oct", "Nov", "Dic"],
                        weekdays: ["Domingo","Lunes", "Martes", "Miércoles", "Jueves", "Viernes", "Sábado"],
                        weekdaysShort: ["Dom","Lun", "Mar", "Mie", "Jue", "Vie", "Sab"],
                        weekdaysAbbrev: ["L", "M", "M", "J", "V", "S","D"]
                    }
                });
                    
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
                    function validarFecha()
            {
                
            var fechDesde = document.getElementById('txtfechaDesde').value;
            var fechHasta = document.getElementById('txtfechaHasta').value;
                if (fechDesde === null) {
                    
                    M.toast({html: 'Fechas incorrectas', classes: 'rounded'});
 
                    return false;
                }else{
                    return true;
                }
                
            }
            
           
            
            
        </script>
</html>
