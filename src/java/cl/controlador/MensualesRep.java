/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.controlador;

import cl.dao.DAOtotalReparto;
import cl.dao.DAOusuario;
import cl.model.ListaTotalPorRepartidor;
import cl.model.MensualesRepar;
import cl.model.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author DAvil
 */
@WebServlet(name = "MensualesRep", urlPatterns = {"/MensualesRep", "/TotalesPorRepartidores"})
public class MensualesRep extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet MensualesRep</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet MensualesRep at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
//        processRequest(request, response);
//errores = "Usuario registrado.";
//            request.setAttribute("msg", errores);
       
           String errores="", msg="";
           int suma = 0;
           int cant = 0;
           //Atributos para obtener informaion de formulario.
           String id_usuario =  request.getParameter("btnIdusuario");
           String fecDesde = request.getParameter("txtfechaDesde");
           String fecHasta = request.getParameter("txtfechaHasta");
           
                if (fecDesde.isEmpty()){
                 errores += "Debe ingresar fecha desde. <br />";
             }
             if (fecHasta.isEmpty()){
                 errores += "Debe ingresar fecha hasta. <br />";
             }
           if (errores.isEmpty()){
           //Comparar que la fecha de finalizacion(fecHasta) es superior a la fecha de inicio(fecDesde).
           if(fecHasta.compareTo(fecDesde)>0){
                DAOtotalReparto MensualRep = new DAOtotalReparto();
                ArrayList <MensualesRepar> listaMenRep = MensualRep.listaMenRep(id_usuario, fecDesde, fecHasta);
                //Obtener la cantidad de reparto realizados dentro del rango de fecha definido
                cant = listaMenRep.size();
                request.setAttribute("cantSumaMensual", cant);
                //for para obtener el monto total de reparto realizados dentro del rango de fecha definido. 
                for (MensualesRepar mr : listaMenRep){
                    suma += mr.getMONTO_REPARTO();
                    request.setAttribute("sumaMensual", suma);
                    
                }
                
                request.setAttribute("lista", listaMenRep);
                request.getRequestDispatcher("pruebaListaRep.jsp").forward(request, response);
           }else{
              errores = "Rango de fecha definido incorrecto";
              request.setAttribute("msg", errores);
              request.getRequestDispatcher("listaMensualesRepar.jsp").forward(request, response);
           }
           
           }else{
             //errores = "Usuario y/o Claveinválidas."; 
               request.setAttribute("msg", errores);
               request.getRequestDispatcher("listaMensualesRepar.jsp").forward(request, response);
        }
           

    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
