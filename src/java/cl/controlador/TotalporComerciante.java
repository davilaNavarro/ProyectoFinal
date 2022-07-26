/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.controlador;

import cl.dao.DAOtotalComer;
import cl.model.ListaTotalPorComerciante;
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
@WebServlet(name = "TotalporComerciante", urlPatterns = {"/TotalporComerciante"})
public class TotalporComerciante extends HttpServlet {

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
            out.println("<title>Servlet TotalporComerciante</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet TotalporComerciante at " + request.getContextPath() + "</h1>");
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

        String comboboxComerciante = request.getParameter("cboComerciante");
        request.setAttribute("comboComerciante", comboboxComerciante);

//        errores = request.getParameter("cboRepartidor");
//        request.setAttribute("msg", errores);
        int suma = 0;
        int cant = 0;
        
        DAOtotalComer comer = new DAOtotalComer();
        ArrayList <ListaTotalPorComerciante> listaPorComer = comer.listaTotalPorComerciante(comboboxComerciante);
        //Obtener la cantidad de reparto realizados dentro del rango de fecha definido
        cant = listaPorComer.size();
        request.setAttribute("cantComerciante", cant);
        //for para obtener el monto total de reparto realizados dentro del rango de fecha definido. 
        for (ListaTotalPorComerciante c : listaPorComer) {
        suma = suma + c.getMONTO_PRODUCTO();
        request.setAttribute("sumaComerciante", suma);
        }
        request.setAttribute("lista", listaPorComer);
        request.getRequestDispatcher("tablaTotalporComerciante.jsp").forward(request, response);
        

    
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
