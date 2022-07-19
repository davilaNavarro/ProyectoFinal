<%-- 
    Document   : listaTotalPorRepartidor
    Created on : 23-11-2019, 21:55:33
    Author     : DAvil
--%>

<%@page import="java.sql.PreparedStatement"%>
<%@page import="cl.dao.Conectar"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.ResultSet"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
        <title>LISTA POR TIPO PRODUCTO</title>
    </head>
   <body class="light-green lighten-5">

        <%
            Usuario cliente = (Usuario) session.getAttribute("usuario");
        %>
        <% if (cliente != null) { %>
        <div class="col s12">
            <jsp:include page="nav.jsp" />
        </div>
        <h3 class="left-align text-lighten-5"><b>LISTA POR TIPO DE PRODUCTO</b></h3>
        <p><b>A CONTINUACIÓN, SE DESPLEGARÁ LA TABLA DE LAS VENTAS REALIZADAS POR EL TIPO DE PRODCUTO SELECCIONADO. </b></p>
        <br>
        <div style="text-align-last: right">
        <button class="waves-effect waves-light btn-large light-green darken-4" onclick="fnExcelReport();"  > <i class="material-icons right">border_color</i>EXPORTAR EXCEL</button>
        </div>
   <%
    ResultSet rs = null;
    try {
    String id_tpProd = (String) request.getAttribute("comboTipoProd");
    String consulta = "select * from TIPO_PRODUCTO where ID_TIPO = "+ id_tpProd +";";
    Connection con = Conectar.getConexion();
    PreparedStatement st = con.prepareStatement(consulta);
    rs = st.executeQuery();
    while (rs.next()){
%>
                <div class="row">
                    <div class="input-field col s6">
                        <b><h5>NOMBRE DE TIPO DE PRODUCTO SELECCIONADO: </h5></b>
                        <p><h6><%= rs.getString(2)%></h6></p>
                    </div>
                </div> 
                <table>
                    <thead>
                        <tr>
                          <th>TOTAL DE VENTAS POR TIPO PRODUCTO:</th><td><h5>${requestScope.sumaTipoProd} </h5> </td>
                          <th>CANTIDAD DE VENTAS POR TIPO DE PRODUCTO: </th><td><h5>${requestScope.cantTipoProd} </h5> </td>
                        </tr>
                    </thead> 
                </table>
   <% }
    
    } catch (Exception e) {
    } %>       
        
    <table id="tablaTipoProd" class="responsive-table" >
        <thead>
            <tr class="light-green darken-1" >
              <th>NOMBRE</th>
              <th>MONTO</th>
              <th>FECHA</th>
            </tr>
        </thead>
        <tbody>
        <c:forEach items="${requestScope.lista}" var="c">
                            <tr align ='center' class="light-green accent-1">
                                <td>${c.NOMBRE_PRODUCTO}</td>
                                <td>${c.MONTO_PRODUCTO}</td>
                                <td>${c.FECHA_HORA_COMPRA}</td>
                            </tr>
        </c:forEach>
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
                $('select').formSelect();
                M.updateTextFields();
                $(".dropdown-trigger").dropdown();
                $('select').material_select();
                $(".button-collapse").sideNav();
              
        });       
               function validar()
            {
                
                var campoCombo = document.getElementById('cboRepartidor').value;
                if (campoCombo == null || campoCombo == 0 ) {
                    
                    M.toast({html: 'El campo que indica su rut no puede estar vacío', classes: 'rounded'});
 
                    return false;
                }else{
                  
                  $("#tableRepartidor").show();
                    
                    return true;
 
                }
            }
            
            function fnExcelReport() {
                    var tab_text = "<table border='2px'><tr bgcolor='#87AFC6' >";
                    tab_text = tab_text + '<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">' ; 
                var textRange;
                var j = 0;
                tab = document.getElementById('tablaTipoProd'); // id of table

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
</script>
</html>

