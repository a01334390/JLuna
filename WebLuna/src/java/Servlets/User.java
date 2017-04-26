/*
 * Built in 2016© By Code Managers in Kraken Tech Ltd.
 * Compiled and Revised by Advisors outside the company
 * Refer to documentation attached for any other reference on code or anything related to this Source Code
 */
package Servlets;

import BasicElements.Cliente;
import BasicElements.DBUser;
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
public class User extends HttpServlet {

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
            out.println("<title>Servlet User</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet User at " + request.getContextPath() + "</h1>");
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
    protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        if(request.getParameter("action").equalsIgnoreCase("erase")){
            System.out.println(request.getParameter("erase"));
            String username = request.getParameter("username");
            Handler.deleteUserInDatabase(username);
            RequestDispatcher req = request.getRequestDispatcher("/BasicViews/user/userindex.jsp");
            req.forward(request, response);
        }
        if(request.getParameter("action").equalsIgnoreCase("edit")){
            System.out.println(request.getParameter("edit"));
            String username = request.getParameter("username");
            DBUser user = Handler.getUserData(username);
            request.setAttribute("user", user);
            RequestDispatcher req = request.getRequestDispatcher("/BasicViews/user/userform.jsp");
            req.forward(request, response);
        }
        if(request.getParameter("action").equalsIgnoreCase("add")){
             System.out.println(request.getParameter("add"));
             String username = request.getParameter("username");
             DBUser user = Handler.getUserData(username);
            request.setAttribute("user", user);
             RequestDispatcher req = request.getRequestDispatcher("/BasicViews/user/userform.jsp");
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
        String username=request.getParameter("username");
        if(!Handler.userExists(username)){
            DBUser user = new DBUser(username,request.getParameter("privilege"),request.getParameter("email"),request.getParameter("first_name"),request.getParameter("second_name"),request.getParameter("image"));
            Handler.addUserToDatabase(user);
        }else{
            DBUser user = new DBUser(username,request.getParameter("privilege"),request.getParameter("email"),request.getParameter("first_name"),request.getParameter("second_name"),request.getParameter("image"));
            Handler.editUserInDatase(user);
        }
        RequestDispatcher req = request.getRequestDispatcher("/BasicViews/user/userindex.jsp");
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
