/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.controlador;

import cl.dao.DAOFeriaLibre;
import cl.model.ListaTotalFeria;
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
@WebServlet(name = "TotalFeria", urlPatterns = {"/TotalFeria"})
public class TotalFeria extends HttpServlet {

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
            out.println("<title>Servlet TotalFeria</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet TotalFeria at " + request.getContextPath() + "</h1>");
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

        String comboboxFeria = request.getParameter("cboFeria");
        request.setAttribute("comboFeria", comboboxFeria);

//        errores = request.getParameter("cboRepartidor");
//        request.setAttribute("msg", errores);
        int suma = 0;
        int cant = 0;
        DAOFeriaLibre feria = new DAOFeriaLibre();
        ArrayList <ListaTotalFeria> listaPorFeria = feria.listaTotalPorFeria(comboboxFeria);
        //Obtener la cantidad de reparto realizados dentro del rango de fecha definido
        cant = listaPorFeria.size();
        request.setAttribute("cantFeria", cant);
        //for para obtener el monto total de reparto realizados dentro del rango de fecha definido. 
        for (ListaTotalFeria f : listaPorFeria) {
        suma = suma + f.getMONTO_PRODUCTO();
        request.setAttribute("sumaFeria", suma);
        }
        request.setAttribute("lista", listaPorFeria);
        request.getRequestDispatcher("tablaTotalporFeria.jsp").forward(request, response);

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
