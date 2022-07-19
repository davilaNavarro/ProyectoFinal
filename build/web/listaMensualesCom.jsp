<%-- 
    Document   : listaTotalesRepar
    Created on : 26-may-2019, 20:16:51
    Author     : DAvil
--%>

<%@page import="cl.model.Usuario"%>
<%@page import="cl.model.MensualesRepar"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="cl.model.totalesReparto"%>
<%@page import="java.util.ArrayList"%>

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
        <title>REPORTE DE VENTAS COMERCIANTE</title>
    </head>
    <body class="light-green lighten-5">
        <%
            Usuario cliente = (Usuario) session.getAttribute("usuario");
        %>
        <% if (cliente != null) { %>
        <div class="col s12">
            <jsp:include page="navComerciante.jsp" />
        </div>  
        <h3 class="left-align text-lighten-5"><b>REPORTE DE VENTAS COMERCIANTE</b></h3>
        <p><b>A CONTINUACIÓN, DEBERÁ SELECCIONAR FECHAS PERMITIENDO GENERAR UNA TABLA CON TODAS LAS VENTAS REALIZADAS DENTOR DEL PLAZO DEFINIDO.    </b></p>
        <br>
        <form action="MensualesCom" method="post" class="col s12 ">
            <div class="red-text center-align">
                    <p class="flow-text">${requestScope.msg}</p>
            </div>
            <div class="row">
            <div class="input-field col s5">
                 <i class="material-icons prefix">find_in_page</i>
                 <input name="txtfechaDesde" type="date" class="datepicker">
                <label class="active" >FECHA DESDE</label>
            </div>
            <div class="input-field col s5">
                 <i class="material-icons prefix">find_in_page</i>
                 <input name="txtfechaHasta" type="date" class="datepicker">
                <label class="active" >FECHA HASTA</label>
            </div>
            </div>
            <div class="center-align">    
                <button  name="btnIdusuario" class="btn waves-effect waves-light light-green darken-4" type="submit" name="action" value="${sessionScope.usuario.id_usuario}">ASIGNAR FECHAS
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
        </script>
</html>