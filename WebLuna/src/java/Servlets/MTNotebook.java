/*
 * Built in 2016© By Code Managers in Kraken Tech Ltd.
 * Compiled and Revised by Advisors outside the company
 * Refer to documentation attached for any other reference on code or anything related to this Source Code
 */
package Servlets;

import DatabaseManager.Handler;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author a01334390
 */
public class MTNotebook extends HttpServlet {

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
            out.println("<title>Servlet MTNotebook</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet MTNotebook at " + request.getContextPath() + "</h1>");
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
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getParameter("action").equalsIgnoreCase("edit")) {
            int notebookID = Integer.parseInt(request.getParameter("notebookID"));
            int materialID = Integer.parseInt(request.getParameter("materialID"));
            request.setAttribute("idd", notebookID);
            request.setAttribute("material", Handler.getAllMaterials());
            request.setAttribute("mn", Handler.searchMaterialNotebook(notebookID, materialID));
            request.setAttribute("status", "Editando...");
            RequestDispatcher req = request.getRequestDispatcher("/AdvancedViews/materialnotebook/MNForm.jsp");
            req.forward(request, response);
        }
        if (request.getParameter("action").equalsIgnoreCase("add")) {
            int notebookID = Integer.parseInt(request.getParameter("notebookID"));
            request.setAttribute("idd", notebookID);
            request.setAttribute("material", Handler.getAllMaterials());
            request.setAttribute("status", "Añadiendo...");
            RequestDispatcher req = request.getRequestDispatcher("/AdvancedViews/materialnotebook/MNForm.jsp");
            req.forward(request, response);
        }
        if (request.getParameter("action").equalsIgnoreCase("delete")) {
            int notebookID = Integer.parseInt(request.getParameter("notebookID"));
            int materialID = Integer.parseInt(request.getParameter("materialID"));
            Handler.deleteNotebookMaterial(materialID, notebookID);
            RequestDispatcher req = request.getRequestDispatcher("/AdvancedViews/materialnotebook/materialstonotebooks.jsp");
            req.forward(request, response);
        }
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
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getParameter("status").equalsIgnoreCase("Editando...")) {
            int notebookID = Integer.parseInt(request.getParameter("notebookID"));
            int materialID = Integer.parseInt(request.getParameter("materialID"));
            int quantity = Integer.parseInt(request.getParameter("quantity"));
            Handler.updateNotebookMaterial(notebookID, materialID, quantity);
        } else {
            int notebookID = Integer.parseInt(request.getParameter("notebookID"));
            int materialID = Integer.parseInt(request.getParameter("materialID"));
            int quantity = Integer.parseInt(request.getParameter("quantity"));
            Handler.addNotebookMaterial(notebookID, materialID, quantity);
        }
        RequestDispatcher req = request.getRequestDispatcher("/AdvancedViews/materialnotebook/materialstonotebooks.jsp");
        req.forward(request, response);
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
