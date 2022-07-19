/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.controlador;

import cl.dao.DAOtipoProducto;
import cl.model.listaPorProducto;
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
@WebServlet(name = "listaTipoProd", urlPatterns = {"/listaTipoProd"})
public class TotalTipoProd extends HttpServlet {

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
            out.println("<title>Servlet TotalTipoProd</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet TotalTipoProd at " + request.getContextPath() + "</h1>");
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

        String comboboxTipoProd = request.getParameter("cboTipoProd");
        request.setAttribute("comboTipoProd", comboboxTipoProd);

//        errores = request.getParameter("cboRepartidor");
//        request.setAttribute("msg", errores);
        int suma = 0;
        int cant = 0;
        DAOtipoProducto tp = new  DAOtipoProducto();
        ArrayList <listaPorProducto> listaPorTipoProd = tp.listaPorTipoProducto(comboboxTipoProd);
        //Obtener la cantidad de reparto realizados dentro del rango de fecha definido
        cant = listaPorTipoProd.size();
        request.setAttribute("cantTipoProd", cant);
        //for para obtener el monto total de reparto realizados dentro del rango de fecha definido. 
        for (listaPorProducto tipoPord : listaPorTipoProd) {
        suma = suma + tipoPord.getMONTO_PRODUCTO();
        request.setAttribute("sumaTipoProd", suma);
        
        
        }
        request.setAttribute("lista", listaPorTipoProd);
        request.getRequestDispatcher("tablaTipoProducto.jsp").forward(request, response);
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
