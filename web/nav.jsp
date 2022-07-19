<%-- 
    Document   : nav
    Created on : 20-may-2019, 15:56:37
    Author     : DAvil
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<nav class="blue-grey" >
     <div class="nav-wrapper light-green" >
         <a class="brand-logo  left light-green">Ferias Click  </a> <a class="right">Usuario:  &nbsp;${sessionScope.usuario.nombre_usuario} de tipo: &nbsp;${sessionScope.usuario.tipo}</a>
        &nbsp;<img   class=" left responsive-img" src="img/icon.png" width="60px" >
<!--    Este es para definir las paginas-->
    <ul id="nav-mobile" class=" right light-green hide-on-med-and-down">
      <li><a class="dropdown-trigger" data-target="dropdown1">USUARIOS<i class="material-icons right">arrow_drop_down</i></a></li>
      <li><a class="dropdown-trigger" data-target="dropdown2">FERIA<i class="material-icons right">arrow_drop_down</i></a></li>
      <li><a class="dropdown-trigger" data-target="dropdown4">PRODUCTO<i class="material-icons right">arrow_drop_down</i></a></li>
      <li><a class="dropdown-trigger" data-target="dropdown3">RECURSO<i class="material-icons right">arrow_drop_down</i></a></li>
      <li><a class="dropdown-trigger" data-target="dropdown5">LISTA ESTRATÉGICAS<i class="material-icons right">arrow_drop_down</i></a></li>
      <li><a class="right-align" href="cerrar.jsp"><b>SALIR</b></a></li>
    </ul>

<!--    Para poner las opciones del menu, para que conecten depende de la ID-->
    <ul id="dropdown1" class="dropdown-content">
        <li><a href="registroUsu.jsp">REGISTRAR USUARIO</a></li>
        <li><a href="listaUsu.jsp">LISTA USUARIO</a></li>
        <li class="divider"></li>
    </ul>
    <ul id="dropdown2" class="dropdown-content">
        <li><a href="RegistrarFeria.jsp">INGRESAR FERIA</a></li>
        <li><a href="listaFeria.jsp">LISTA FERIA</a></li>
    </ul>
    <ul id="dropdown3" class="dropdown-content">
        <li><a href="listaTransp.jsp">LISTA TRANSPORTE</a></li>
    </ul>
    <ul id="dropdown4" class="dropdown-content">
        <li><a href="ingTipoProd.jsp">INGRESAR TIPO PRODUCTO</a></li>
        <li><a href="listaTpProd.jsp">LISTA TIPO PRODUCTO</a></li>
        <li><a href="listaprod.jsp">LISTA PRODUCTO</a></li>
    </ul>
     <ul id="dropdown5" class="dropdown-content">
        <li><a href="listaTotalPorRepartidor.jsp">LISTA POR REPARTIDOR</a></li>
        <li><a href="listaTotalPorComerciante.jsp">LISTA POR COMERCIANTE</a></li>
        <li><a href="listaPorTipoProd.jsp">LISTA POR TIPO PRODUCTO</a></li>
        <li><a href="listaPorFeria.jsp">LISTA POR FERIA</a></li>
        <li><a href="listaporRepartidorFecha.jsp">LISTA REPARTIDOR POR FECHA</a></li>
        <li><a href="listaporComercianteFecha.jsp">LISYA COMERCIANTE POR FECHA</a></li>
    </ul>
  </div>
</nav>
      
      
