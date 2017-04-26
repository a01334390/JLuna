/*
 * Built in 2016© By Code Managers in Kraken Tech Ltd.
 * Compiled and Revised by Advisors outside the company
 * Refer to documentation attached for any other reference on code or anything related to this Source Code
 */
package Servlets;

import BasicElements.Cliente;
import BasicElements.OrderNotebooks;
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
            request.setAttribute("client", clientID);
            request.setAttribute("orderNumber", orderID);
            request.setAttribute("nb", Handler.getAllNotebooks());
            request.setAttribute("on", Handler.getNotebookOrder(orderID, notebookID));
            request.setAttribute("action", "Editando");
            RequestDispatcher req = request.getRequestDispatcher("/BasicViews/order/newOrderNotebook.jsp");
            req.forward(request, response);

        }
        if (request.getParameter("action").equalsIgnoreCase("add")) {
            String orderID = request.getParameter("OrderID");
            String clientID = request.getParameter("clientID");
            String notebookID = request.getParameter("NotebookID");
            request.setAttribute("client", clientID);
            request.setAttribute("on", Handler.getNotebookOrder(orderID, notebookID));
            request.setAttribute("orderNumber", orderID);
            request.setAttribute("nb", Handler.getAllNotebooks());
            request.setAttribute("action", "Aunando");
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
        String action = request.getParameter("action");
        String idOrder = request.getParameter("idOrder");
        String id_Notebook = request.getParameter("id_Notebook");
        String quantity = request.getParameter("quantity");
        String status = request.getParameter("status");
        String ribbon = request.getParameter("ribbon");
        String elastic = request.getParameter("elastic");
        String pageType = request.getParameter("pageType");
        String image = request.getParameter("image");
        String clientID = request.getParameter("clientID");
        if (action.equalsIgnoreCase("Editando")) {
           Handler.editNotebookOrder(new OrderNotebooks(Integer.parseInt(id_Notebook),Integer.parseInt(idOrder),Integer.parseInt(quantity),status,ribbon,image,elastic,pageType));
        } else {
           Handler.addNotebookOrder(new OrderNotebooks(Integer.parseInt(id_Notebook),Integer.parseInt(idOrder),Integer.parseInt(quantity),status,ribbon,image,elastic,pageType));
           Handler.substractAllRelatedMaterials(id_Notebook);
           Handler.substractAllRelatedNotebooks(id_Notebook,quantity);
        }
        Cliente client = Handler.searchClientByID(clientID);
        request.setAttribute("client", client);
        RequestDispatcher req = request.getRequestDispatcher("/BasicViews/order/orderAll.jsp");
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
