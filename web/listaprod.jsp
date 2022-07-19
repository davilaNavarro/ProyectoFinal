<%-- 
    Document   : listaprod
    Created on : 21-may-2019, 4:32:59
    Author     : DAvil
--%>


<%@page import="cl.dao.DAOtipoProducto"%>
<%@page import="cl.model.Usuario"%>
<%@page import="cl.model.Producto"%>
<%@page import="java.util.ArrayList"%>
<%@page import="cl.dao.DAOproducto"%>
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
        <title>LISTA PRODUCTO</title>
    </head>
    <body class="light-green lighten-5">
        <%
            Usuario cliente = (Usuario) session.getAttribute("usuario");
        %>
        <% if (cliente != null) { %>
        <div class="col s12">
            <jsp:include page="nav.jsp" />
         </div>
         <h3 class="left-align text-lighten-5"><b>LISTA  PRODUCTO</b></h3>
          <p><b>A CONTINUACIÓN, SE DESPLEGARA LA TABLA CON LOS PRODUCTOS REGISTRADOS. </b></p>
        <div style="text-align-last: right">
            <button class="waves-effect waves-light btn-large light-green darken-4" onclick="fnExcelReport();"  ><i class="material-icons right">get_app</i>EXPORTAR EXCEL</button>
        </div>
        <p></p>
        <center>
            <table id="tablaProducto" class="responsive-table" >
        <thead>
            <tr class="light-green darken-1"  >
              <th>NOMBRE PRODUCTO</th>
              <th>CANTIDAD </th>
              <th>VALORIZACIÓN </th>
              <th>COSTO</th>
              <th>TIPO</th>
          </tr>
        </thead>
        <tbody>
      <% 
          DAOtipoProducto tP = new DAOtipoProducto();
          DAOproducto prod = new DAOproducto();
          ArrayList<Producto> listaProd = prod.listaProducto();
          for (Producto p : listaProd){
                out.println("<tr align ='center' class='light-green accent-1'>");
                out.println("<td>"+ p.getNombre_producto()+ "</td>");
                out.println("<td>"+ p.getCantidad_producto()+ "</td>");
                out.println("<td>"+ p.getValorizacion_producto()+ "</td>");
                out.println("<td>"+ p.getCosto_producto()+ "</td>");
                out.println("<td>" + tP.obtenerTipoProd(p.getId_tipo()) + "</td>");
                out.println("</tr>");
          }
           
       %> 
        </tbody>
        
      </table>
</center>
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
            function fnExcelReport() {
                var tab_text = "<table border='2px'><tr bgcolor='#87AFC6' >";
                tab_text = tab_text + '<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">' ; 
                var textRange;
                var j = 0;
                tab = document.getElementById('tablaProducto'); // id of table

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
                M.updateTextFields();
                $(".dropdown-trigger").dropdown();
                $('select').material_select();
                $(".button-collapse").sideNav();
            });
        </script>
</html>
