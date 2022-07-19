<%-- 
    Document   : listaUsu
    Created on : 21-may-2019, 0:02:21
    Author     : DAvil
--%>

<%@page import="cl.model.ComboComuna"%>
<%@page import="cl.dao.DAOFeriaLibre"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.ArrayList"%>
<%@page import="cl.model.Usuario"%>
<%@page import="cl.dao.DAOusuario"%>
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
        <title>TABLA USUARIO</title>
    </head>
    <body class="light-green lighten-5">
              <%
            Usuario cliente = (Usuario) session.getAttribute("usuario");
        %>
        <% if (cliente != null) { %>
        <div class="col s12">
            <jsp:include page="nav.jsp" />
        </div>
        <h3 class="left-align text-lighten-5"><b>TABLA USUARIOS</b></h3>
        
        <p><b>A CONTINUACIÓN, SE DESPLEGARÁ LA TABLA CON LOS USUARIOS REGISTRADOS.  </b></p>
        
        <div style="text-align-last: right">
        <button class="waves-effect waves-light light-green darken-4 btn-large" onclick="fnExcelReport();"><i class="material-icons right">get_app</i>EXPORTAR EXCEL</button>
        </div>
        <p></p>
        
        <table id="tablaUsuario" class="responsive-table" >
                <thead>
                    <tr class="light-green darken-1 " >
                      <th>RUT USUARIO</th>
                      <th>NOMBRE</th>
                      <th>APELLIDOS</th>
                      <th>CLAVE</th>
                      <th>NOMBRE USUARIO</th>
                      <th>CORREO ELECTRÓNICO</th>
                      <th>TIPO</th>
                      <th>COMUNA</th>
                      <th>DIRECCIÓN</th>
                      <th>EDITAR</th>
                      <th>ELIMINAR</th>
                     </tr>
                </thead>
        <tbody>
      <% 
            DAOFeriaLibre fer = new DAOFeriaLibre();
                        ArrayList <ComboComuna> listacomuna= fer.listarComuna();
            DAOusuario u = new DAOusuario();
            ArrayList <Usuario> listaUsuario = u.listarUsuario();
            for (Usuario us : listaUsuario){
        %>        
            <tr>
               
                <td><%= us.getRut() %></td>
                <td><%= us.getNombre()%></td>
                <td><%= us.getApellidos() %></td>
                <td><%= us.getClave() %></td>
                <td><%= us.getNombre_usuario() %></td>
                <td><%= us.getCorreo_eletronico()%></td>
                <td><%= us.getTipo() %></td>
                <td><%= fer.obtenerComuna(us.getComuna())  %></td>
                <td><%= us.getDireccion() %></td>
                <td >
                    <a href="editarUsu.jsp?ID_USUARIO=<%= us.getId_usuario() %>">
                        <i  class="small material-icons" >edit</i>
                    </a>
                </td>
                <td >
                    <a href="eliminarUsu.jsp?ID_USUARIO=<%= us.getId_usuario() %>">
                        <i class="small material-icons">close</i>
                    </a>
                </td>
            </tr>
        </tbody>
        <%  } %>
      </table>
        <% } else { %>
            <div class="row">
                <div class="col s12">
                    <h3>DEBE INICIAR SESIÓN PARA ACCEDER A LOS CONTENIDOS.</h3>
                   
                    <a href="index.jsp">IR AL LOGIN</a>
                </div>
            </div>
            <% }%>   
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
                tab = document.getElementById('tablaUsuario'); // id of table

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
