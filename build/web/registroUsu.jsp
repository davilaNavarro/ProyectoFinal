<%-- 
    Document   : registroUsu
    Created on : 20-may-2019, 14:40:29
    Author     : DAvil
--%>

<%@page import="cl.model.Usuario"%>
<%@page import="cl.model.ComboComuna"%>
<%@page import="java.util.ArrayList"%>
<%@page import="cl.dao.DAOFeriaLibre"%>
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
        
        <title>REGISTRO USUARIOS</title>
    </head>
    <body class="light-green lighten-5">

        <%
              Usuario cliente = (Usuario) session.getAttribute("usuario");
        %>
        <% if (cliente != null) { %>
        <div class="col s12">
            <jsp:include page="nav.jsp" />
        </div>
        
        <h3 class="left-align text-lighten-5"><b>REGISTRO USUARIOS</b></h3>
  
        <p><b>A CONTINUACIÓN, SE DEBERÁ COMPLETAR DIFERENTES CAMPOS PARA REGISTRAR USUARIO. </b></p>
        
        <div class="responsive-table">
         <form action="nuevoUsuario" method="post" class="col s12 ">
            <div class="red-text center-align">
                    <p class="flow-text">${requestScope.msg}</p>
            </div>
            <div class="row">
              <div class="input-field col s5">
                  <i class="material-icons prefix">person_add</i>
                  <input id="rut" name="txtRut" type="text" class="validate" maxlength="12" max="12" onblur="limpiar_rut(this.value);formato_rut(this.value);"/>
                  <label for="rut" class="active" >RUT</label>
               </div>    
              <div class="input-field col s5">
                <i class="material-icons prefix">perm_identity</i>
                <input name="txtNombre" id="" type="text"/>
                <label class="active" >NOMBRE</label>
              </div>
            </div>
            <div class="row">
                <div class="input-field col s5">
                    <i class="material-icons prefix">perm_identity</i>
                    <input name="txtApellido" id="" type="text"/>
                    <label class="active" >APELLIDO</label>
                </div>
                <div class="input-field col s5">
                     <i class="material-icons prefix">vpn_key</i>
                    <input name="txtClave" id="" type="text"/>
                    <label class="active" >CLAVE</label>
                </div>
            </div>
            <div class="row">
                <div class="input-field col s5">
                    <i class="material-icons prefix">person_pin</i>
                    <input name="txtNombreUsuario" id="" type="text"/>
                    <label class="active" >NOMBRE USUARIO</label>
                </div>
                <div class="input-field col s5">
                    <i class="material-icons prefix">markunread</i>
                    <input name="txtCorreo" id="correo" type="email" onblur="validarEmail(this.value)"/>
                    <label class="active" >CORREO</label>
                </div>
            </div>
            <div class="row">
                <div class="input-field col s5">
                    <i class="material-icons prefix">filter_frames</i>
                    <select name="cboTipoUsu" >   
                        <option value="" disabled selected>SELECCIONE UN TIPO USUARIO</option>
                        <option value="ADMINISTRADOR">ADMINISTRADOR</option>
                        <option value="COMPRADOR">COMPRADOR</option>
                        <option value="COMERCIANTE">COMERCIANTE</option>
                        <option value="REPARTIDOR">REPARTIDOR</option>
                    </select>    
                    <label  >TIPO</label>
                </div>
                <div class="input-field col s5">
                    <i class="material-icons prefix">redeem</i>
                <select name="cboComuna" >   
                    <option value="" disabled selected>SELECCIONE UNA COMUNA</option>
                    <% DAOFeriaLibre fer = new DAOFeriaLibre();
                        ArrayList <ComboComuna> listacomuna= fer.listarComuna();
                        for(ComboComuna com : listacomuna){
                    %>
                    
                    
                    <option value="<%= com.getIdComuna() %>"><%= com.getNomComuna() %> </option>
                <%}%>
                </select>
                <label for="cboComuna">COMUNA</label>   
              </div>
            </div>
            <div class="row">
                <div class="input-field col s5">
                    <i class="material-icons prefix">home</i>
                    <input name="txtDireccion" id="" type="text"/>
                    <label class="active" >DIRECCIÓN</label>
                </div>
                <div class="center-align">    
                    <!--<button style="margin-top: 10px;" class="btn waves-effect blue lighten-1" type="submit" name="action" onclick="return validandoRut();">Registrar</button>-->
                    <button class="btn waves-effect waves-light waves-effect waves-light btn-large light-green darken-4" type="submit" name="action"  onclick="return validandoRut()" ><i class="material-icons right">supervisor_account</i>REGISTRAR</button>
                </div>                              
            </div>
         </form>
        </div>
        <% } else { %>
                <div class="row">
                    <div class="col s12">
                        <h3>DEBE INICIAR SESIÓN PARA ACCEDER A LOS CONTENIDOS.</h3>

                        <a href="index.jsp">IR AL LOGIN</a>
                    </div>
                </div>
        <% }%> 
</body>
<!--     <!--Import jQuery before materialize.js-->
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
        function limpiar_rut(rut) {
                var rutLimpio = rut;
                //Definimos los caracteres a eliminar
                var eliminar = ".-";
                //Los eliminamos
                for (var i = 0; i < eliminar.length; i++) {
                    rutLimpio = rutLimpio.replace(new RegExp("\\" + eliminar[i], 'gi'), '');
                }
                //Pasamos al campo el valor limpio
                document.getElementById("rut").value = rutLimpio.toUpperCase();
            }

	function formato_rut(rut) {
                var sRut1 = rut; //Contador de posición
                var nPos = 0; //Guarda el rut invertido con los puntos y el guión agregado
                var sInvertido = ""; //Guarda el resultado final del rut como debe ser
                var sRut = "";
                for (var i = sRut1.length - 1; i >= 0; i--) {
                    sInvertido += sRut1.charAt(i);
                    if (i == sRut1.length - 1) {
                        sInvertido += "-";
                    } else if (nPos == 3) {
                        sInvertido += ".";
                        nPos = 0;
                    }
                    nPos++;
                }
                for (var j = sInvertido.length - 1; j >= 0; j--) {
                    if (sInvertido.charAt(sInvertido.length - 1) != ".") {
                        sRut += sInvertido.charAt(j);
                    } else if (j != sInvertido.length - 1) {
                        sRut += sInvertido.charAt(j);
                    }
                }
                //Pasamos al campo el valor formateado
                document.getElementById("rut").value = sRut.toUpperCase();
            }
        function validandoRut()
            {
                var campoRut = document.getElementById("rut").value;

                if (campoRut == null || campoRut.length == 0 || /^\s+$/.test(campoRut)) {
                    
                    M.toast({html: 'El campo que indica su rut no puede estar vacío', classes: 'rounded'});
 
                    return false;
                } else if (campoRut.length < 11) {
                    M.toast({html: 'El campo que indica su rut no puede tener menos de 11 caracteres', classes: 'rounded'});

                 
                    
                    return false;
                } else if (campoRut.length > 12) {
                    M.toast({html: 'El campo que indica su rut no puede tener más de 12 caracteres', classes: 'rounded'});

                    return false;
                } else if (valrut(campoRut) == false) {
                    M.toast({html: 'El rut ingresado no es válido', classes: 'rounded'});

                    
                    return false;
                }
                return true;
            }

        function valrut(campoRut) {

                var rut = campoRut;
                var crut;
                //limpieza
                var eliminar = ".-";
                //Los eliminamos
                for (var i = 0; i < eliminar.length; i++) {
                    rut = rut.replace(new RegExp("\\" + eliminar[i], 'gi'), '');
                }

                var tmpstr = "";
                var intlargo = rut;
                if (intlargo.length > 0)
                {
                    crut = rut;
                    var largo = crut.length;
                    if (largo < 2)
                    {
                        return false;
                    }
                    for (i = 0; i < crut.length; i++)
                        if (crut.charAt(i) != ' ' && crut.charAt(i) != '.' && crut.charAt(i) != '-')
                        {
                            tmpstr = tmpstr + crut.charAt(i);
                        }
                    var rutSuma = tmpstr;
                    crut = tmpstr;
                    largo = crut.length;
                    if (largo > 2)
                        rutSuma = crut.substring(0, largo - 1);
                    else
                        rutSuma = crut.charAt(0);
                    var dv = crut.charAt(largo - 1);
                    if (rutSuma == null || dv == null)
                        return false;
                    var dvr = '0';
                    var suma = 0;
                    var mul = 2;
                    for (i = rutSuma.length - 1; i >= 0; i--)
                    {
                        suma = suma + rutSuma.charAt(i) * mul;
                        if (mul == 7)
                            mul = 2;
                        else
                            mul++;
                    }

                    var res = suma % 11;
                    if (res == 1)
                        dvr = 'k';
                    else if (res == 0)
                        dvr = '0';
                    else
                    {
                        var dvi = 11 - res;
                        dvr = dvi + "";
                    }

                    if (dvr != dv.toLowerCase())
                    {
                        return false;
                    }
                    return true;
                }
            }
            
            
            

        function validarEmail(elemento){

                var texto = document.getElementById("correo").value;
                var regex = /^[-\w.%+]{1,64}@(?:[A-Z0-9-]{1,63}\.){1,125}[A-Z]{2,63}$/i;

                if (!regex.test(texto)) {
                      M.toast({html: 'Correo invalido', classes: 'rounded'});


                } else {
                  M.toast({html: 'Correo valido', classes: 'rounded'});
                }

            }
    </script>
</html>
