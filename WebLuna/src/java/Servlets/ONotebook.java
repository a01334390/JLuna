/*
 * Built in 2016© By Code Managers in Kraken Tech Ltd.
 * Compiled and Revised by Advisors outside the company
 * Refer to documentation attached for any other reference on code or anything related to this Source Code
 */
package Servlets;

import BasicElements.Cliente;
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
public class ONotebook extends HttpServlet {

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
            out.println("<title>Servlet ONotebook</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ONotebook at " + request.getContextPath() + "</h1>");
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
        if (request.getParameter("action").equalsIgnoreCase("delete")) {
            String orderID = request.getParameter("OrderID");
            String notebookID = request.getParameter("NotebookID");
            Handler.DeleteNotebookOrderInDatabase(orderID, notebookID);
            String userID = request.getParameter("clientID");
            Cliente client = Handler.searchClientByID(userID);
            request.setAttribute("client", client);
            RequestDispatcher req = request.getRequestDispatcher("/BasicViews/order/orderAll.jsp");
            req.forward(request, response);
        }
        if (request.getParameter("action").equalsIgnoreCase("edit")) {
            String orderID = request.getParameter("OrderID");
            String clientID = request.getParameter("clientID");
            String notebookID = request.getParameter("NotebookID");
            Cliente client = Handler.searchClientByID(clientID);
            request.setAttribute("client", client);
            request.setAttribute("on", Handler.getNotebookOrder(orderID, notebookID));
            RequestDispatcher req = request.getRequestDispatcher("/BasicViews/order/newOrderNotebook.jsp");
            req.forward(request, response);

        }
        if (request.getParameter("action").equalsIgnoreCase("add")) {
            String orderID = request.getParameter("OrderID");
            String clientID = request.getParameter("clientID");
            String notebookID = request.getParameter("NotebookID");
            Cliente client = Handler.searchClientByID(clientID);
            request.setAttribute("client", client);
            request.setAttribute("on", Handler.getNotebookOrder(orderID, notebookID));
            RequestDispatcher req = request.getRequestDispatcher("/BasicViews/order/newOrderNotebook.jsp");
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
