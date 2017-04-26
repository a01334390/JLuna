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
public class Client extends HttpServlet {

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
            out.println("<title>Servlet Client</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Client at " + request.getContextPath() + "</h1>");
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
         if(request.getParameter("action").equalsIgnoreCase("erase")){
            System.out.println(request.getParameter("erase"));
            int clientID = Integer.parseInt(request.getParameter("userID"));
            Handler.deleteClient(clientID);
            RequestDispatcher req = request.getRequestDispatcher("/BasicViews/client/clientindex.jsp");
            req.forward(request, response);
        }
        if(request.getParameter("action").equalsIgnoreCase("edit")){
            String clientID = request.getParameter("userID");
            Cliente client = Handler.searchClientByID(clientID);
            request.setAttribute("client", client);
            RequestDispatcher req = request.getRequestDispatcher("/BasicViews/client/clientform.jsp");
            req.forward(request, response);
        }
        if(request.getParameter("action").equalsIgnoreCase("add")){
             System.out.println(request.getParameter("add"));
             String clientID = request.getParameter("userID");
             Cliente client = Handler.searchClientByID(clientID);
             request.setAttribute("client", client);
             RequestDispatcher req = request.getRequestDispatcher("/BasicViews/client/clientform.jsp");
             req.forward(request, response);
        }
        if(request.getParameter("show")!=null){
            
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
        String id=request.getParameter("idClient");
        if(id==null || id.isEmpty()){
            Cliente user = new Cliente(1000,request.getParameter("first_name"),request.getParameter("second_name"),request.getParameter("address"),Integer.parseInt(request.getParameter("isPhysical")),request.getParameter("email"));
            Handler.addClientToDatabase(user);
        }else{
            Cliente user = new Cliente(Integer.parseInt(request.getParameter("idClient")),request.getParameter("first_name"),request.getParameter("second_name"),request.getParameter("address"),Integer.parseInt(request.getParameter("isPhysical")),request.getParameter("email"));
            Handler.updateClientInDatabase(user);
        }
        RequestDispatcher req = request.getRequestDispatcher("/BasicViews/client/clientindex.jsp");
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
