<%
    //Se procede a cerrar la sesi�n
    session.invalidate();
    //Se redirecciona a login.jsp
    response.sendRedirect("index.jsp");
%>