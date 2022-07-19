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
        <title>LISTA DE VENTAS COMERCIANTE</title>
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
        <p><b>A CONTINUACIÓN, SE DESPLEGARÁ UNA TABLA CON TODAS SUS VENTAS REALIZADAS DENTRO DE LAS FECHAS DEFINIDAS.  </b></p>
        <br>
          <div style="text-align-last: right">
        <button class="waves-effect waves-light btn-large light-green darken-4" onclick="fnExcelReport();"  ><i class="material-icons right">border_color</i>EXPORTAR EXCEL</button>
        </div>
        <p></p>       
        <table class="action">
            <thead>
                <tr align ='center'>
                    <th>MONTO TOTAL DE VENTAS</th><td><h5>${requestScope.sumaMensual}</h5></td>
                    <th>CANTIDAD DE VENTAS: </th><td><h5>${requestScope.cantSumaMensual}</h5> </td>
                </tr>
            </thead>
        </table>
          
    <center>
        <table id="listaComerciante">
           <thead>
            <tr class="card-panel   light-green darken-1" >
              <th>NOMBRE PRODUCTO</th>
              <th>MONTO </th>
              <th>FECHAS</th>
            </tr>
            </thead>
        <tbody>
                <c:forEach items="${requestScope.lista}" var="c">
                             <tr align ='center' class="light-green accent-1">
                                <td>${c.NOMBRE_PRODUCTO}</td>
                                <td>${c.MONTO}</td>
                                <td>${c.FECHA_HORA_COMPRA}</td>
                            </tr>
                </c:forEach>     
        </tbody>
        </table>
    <% } else { %>
            <div class="row">
                <div class="col s12">
                    <h3>DEBE INICIAR SESIÓN PARA ACCEDER A LOS CONTENIDOS. </h3>
                   
                    <a href="index.jsp">IR AL LOGIN</a>
                </div>
    <% }%> 
</center>
    </body>
    <!--Import jQuery before materialize.js-->
        <script type="text/javascript" src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
        <script type="text/javascript" src="js/materialize.min.js"></script>
        <script>
                function fnExcelReport() {
                    var tab_text = "<table border='2px'><tr bgcolor='#87AFC6' >";
                    tab_text = tab_text + '<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">' ; 
                var textRange;
                var j = 0;
                tab = document.getElementById('listaComerciante'); // id of table

                for (j = 0; j < tab.rows.length; j++) {
                    tab_text = tab_text + tab.rows[j].innerHTML + "</tr>";
                    //tab_text=tab_text+"</tr>";
                }

                tab_text = tab_text + "</table>";
                tab_text = tab_text.replace(/<A[^>]*>|<\/A>/g, ""); //remove if u want links in your table
                tab_text = tab_text.replace(/<img[^>]*>/gi, ""); // remove if u want images in your table
                tab_text = tab_text.replace(/<input[^>]*>|<\/input>/gi, ""); // reomves input params

                var ua = window.navigator.userAgent;
                var msie = ua.indexOf("MSIE ");
                if (msie > 0 || !!navigator.userAgent.match(/Trident.*rv\:11\./)) // If Internet Explorer
                {
                    txtArea1.document.open("txt/html", "replace");
                    txtArea1.document.write(tab_text);
                    txtArea1.document.close();
                    txtArea1.focus();
                    sa = txtArea1.document.execCommand("SaveAs", true, "Say Thanks to Sumit.xls");
                } else //other browser not tested on IE 11
                    sa = window.open('data:application/vnd.ms-excel,' + encodeURIComponent(tab_text));

                return (sa);
            };
            $(document).ready(function() {               
                M.updateTextFields(),
                $(".dropdown-trigger").dropdown(),
                $('select').material_select(),
                $(".button-collapse").sideNav(),
                $('.datepicker').datepicker({
                        format: 'yyyy-mm-dd',
                        //Fecha minima
                        minDate: new Date(2019-01-31)
                });
                
            });
        </script>
</html>