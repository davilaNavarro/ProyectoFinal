<%-- 
    Document   : index
    Created on : 19-may-2019, 21:08:04
    Author     : DAvil
--%>

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
        <title>FERIAS CLICK</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!--        <title>JSP Page</title>-->
        <script src="js/main.js"></script>
<!--    <img   src="img/mercado-europeos-frutas-verduras.jpg">    -->
    </head>
    <body background="img/mercado-europeos-frutas-verduras.jpg" >
        <div class="container" >
            <div class="row">
                <nav>
                    <div class="nav-wrapper center light-green white-text darken-1" >
                         <h2><b class="left">FERIAS CLICK</b></h2>
                         &nbsp;<img   class=" left responsive-img" src="img/icon.png" width="60px" >
                    </div>
                </nav>
            </div>
            <div class="row">
                <div class="col s10 offset-s1">
                    <b class="flow-text white-text s5" align="center ">FERIAS CLICK ES UN APLICATIVO MÓVIL QUE VA ORIENTADO A LA APILIZACIÓN DE LOS PROCESOS DE COMERCIALIZACIÓN DE LAS FERIAS LIBRES. </b>
             </div>
            </div>
            <div class="col s6 offset-s3" >
                <div class="row">
                    <form class="col s8 offset-s2 light-green card-panel z-depth-5 transparent "  
                        action="iniciar" method="post" id="formingresar">
                        <div class="col s12">
                            <h4 class="center-align"><b>INGRESO</b></h4>
                        </div>
                        <div class="row">
                            <div class="input-field col s6 black-text">
                                <i class="material-icons  prefix">account_circle</i>
                                <input id="icon_prefix" type="text" class="validate black-text"
                                       name="txtNom_usuario" id="txtNom_usuario" />
                                <label for="icon_prefix" class="black-text"><h6><b>USUARIO</b></h6></label>
                            </div>
                            <div class="input-field col s6 black-text ">
                                <i class="material-icons  prefix">lock_outline</i>
                                <input id="icon_pass" type="password" class="validate black-text"
                                       name="txtClave" id="txtClave"/>
                                <label for="icon_pass" class="black-text"  ><h6><b>CLAVE</b></h6></label>
                            </div>
                            <div class="center-align">    
                                <button class="btn waves-effect waves-light light-green darken-4" type="submit" name="action" id="btninciar" >ENVIAR
                                    <i class="material-icons right">send</i>
                                </button>
                            </div>    
                        </div>
                    </form>
                </div>
                <div class="red-text center-align">
                    <p class="flow-text">${requestScope.msg}</p>
                </div>
            </div>
            <footer class="page-footer light-green darken-1">
                <div class="container">
                    <div class="row">
                        <div class="col l6 s12">
                            <h5 class="white-text"></h5>
                            <p class="grey-text text-lighten-4"><a href="mailto:contacto@fundacionsol.cl" style="color: #ffff00"></a></p>
                        </div>
                    </div>
                </div>
                <div class="footer-copyright light-green">
                    <div class="container">
                        © 2019 FERIAS CLICK
                        <a class="grey-text text-lighten-4 right">PÁGINA DE ADMINISTRACIÓN FERIAS CLICK</a>
                    </div>
                </div>
            </footer>
        </div>
        <!--Import jQuery before materialize.js-->
        <script type="text/javascript" src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
        <script type="text/javascript" src="js/materialize.min.js"></script>
        <script>
            $(function () {

                $(".button-collapse").sideNav();
            });
        </script>
    </body>
    
</html>
