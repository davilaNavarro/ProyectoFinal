<%-- 
    Document   : nav
    Created on : 20-may-2019, 15:56:37
    Author     : DAvil
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<nav class="light-green darken-1" >
    <div class="nav-wrapper light-green" >
         <a class="brand-logo  left light-green">FERIAS CLICK  </a> <a class="right">USUARIO:  &nbsp;${sessionScope.usuario.nombre_usuario} DE TIPO: &nbsp;${sessionScope.usuario.tipo}</a>
        &nbsp;<img   class=" left responsive-img" src="img/icon.png" width="60px" >
        
<!--    Este es para definir las paginas-->
    <ul id="nav-mobile" class=" right light-green hide-on-med-and-down">
      <li><a class="dropdown-trigger" data-target="dropdown1">LISTA DE DESPACHOS<i class="material-icons right">arrow_drop_down</i></a></li>
      <li><a class="right-align" href="cerrar.jsp"><b>SALIR</b></a></li>
    </ul>
   
<!--    Para poner las opciones del menu, para que conecten depende de la ID-->
    <ul id="dropdown1" class="dropdown-content">
        <li><a href="listaTotalesRepar.jsp?RUT=${sessionScope.usuario.rut}">DESPACHOS TOTALES</a></li>
        <li><a href="listaMensualesRepar.jsp?ID_USUARIO=${sessionScope.usuario.id_usuario}">DESPACHOS POR FECHAS</a></li>
    </ul>
    </div>
</nav>