/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import DatabaseManager.Handler;
import java.io.IOException;
import BasicElements.*;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Alex
 */
public class Material extends HttpServlet {

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
            out.println("<title>Servlet Material</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Material at " + request.getContextPath() + "</h1>");
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
            int materialID = Integer.parseInt(request.getParameter("materialID"));
            Handler.deleteMaterialInDatabase(materialID);
            RequestDispatcher req = request.getRequestDispatcher("/BasicViews/material/materialindex.jsp");
            req.forward(request, response);
        }
        if(request.getParameter("action").equalsIgnoreCase("edit")){
             int materialID = Integer.parseInt(request.getParameter("materialID"));
             BasicElements.Material material = Handler.searchMaterialByID(materialID);
             request.setAttribute("material", material);
             RequestDispatcher req = request.getRequestDispatcher("/BasicViews/material/materialform.jsp");
             req.forward(request, response);
        }
        if(request.getParameter("action").equalsIgnoreCase("add")){
            BasicElements.Material material = null;
            request.setAttribute("material", material);
            RequestDispatcher req = request.getRequestDispatcher("/BasicViews/material/materialform.jsp");
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
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String id=request.getParameter("id");
        if(id==null || id.isEmpty()){
            BasicElements.Material material = new BasicElements.Material(1000,request.getParameter("name"),Integer.parseInt(request.getParameter("quantity")),Float.parseFloat(request.getParameter("cost")));
            Handler.addMaterialToDatabase(material);
        }else{
            BasicElements.Material material = new BasicElements.Material(Integer.parseInt(request.getParameter("id")), request.getParameter("name"),Integer.parseInt(request.getParameter("quantity")),Float.parseFloat(request.getParameter("cost")));
            Handler.editMaterialInDatabase(material);
        }
        RequestDispatcher req = request.getRequestDispatcher("/BasicViews/material/materialindex.jsp");
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
