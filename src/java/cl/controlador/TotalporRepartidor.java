/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.controlador;

import cl.dao.DAOtotalReparto;
import cl.model.ListaTotalPorRepartidor;
import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet(name = "TotalporRepartidor", urlPatterns = {"/TotalporRepartidor"})
public class TotalporRepartidor extends HttpServlet {

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
            out.println("<title>Servlet TotalporRepartidor</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet TotalporRepartidor at " + request.getContextPath() + "</h1>");
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
String errores="", msg="";

        String comboxRepartidor = request.getParameter("cboRepartidor");
        request.setAttribute("cobRepartidor", comboxRepartidor);

//        errores = request.getParameter("cboRepartidor");
//        request.setAttribute("msg", errores);
        int suma = 0;
        int cant = 0;
        
        DAOtotalReparto rep = new DAOtotalReparto();
        ArrayList <ListaTotalPorRepartidor> listaPorRepartidor = rep.listaTotalPorRepartidor(comboxRepartidor);
        //Obtener la cantidad de reparto realizados dentro del rango de fecha definido

        cant = listaPorRepartidor.size();
        request.setAttribute("cantRepartidor", cant);
        //for para obtener el monto total de reparto realizados dentro del rango de fecha definido. 
        for (ListaTotalPorRepartidor r : listaPorRepartidor) {
        suma = suma + r.getMONTO_REPARTO();
        request.setAttribute("sumaRepartidor", suma);
        

        }
        request.setAttribute("lista", listaPorRepartidor);
        request.getRequestDispatcher("tablaTotalporRepartidor.jsp").forward(request, response);
        

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
