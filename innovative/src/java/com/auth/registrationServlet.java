package com.auth;

import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;


public class registrationServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet handleRegisterServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            
            String fullname = request.getParameter("fullname");
            String username = request.getParameter("username");
            String email = request.getParameter("email");
            String password = request.getParameter("password");
            
//            Establish connection to database
            try{
                Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3307/project", "root", "");    
                String query = "INSERT INTO users (full_name, username, email, password) VALUES (?, ?, ?, ?)";
                PreparedStatement stmt = con.prepareStatement(query);
                stmt.setString(1, fullname);       // starting from 2nd index because 1st index is reserved for User ID (PK)
                stmt.setString(2, username);
                stmt.setString(3, email);
                stmt.setString(4, password);
                
                stmt.executeUpdate();
                
//                Since Registration is successfull so start user sessoin and redirect to ProfileServlet (HOME PAGE)
                HttpSession session = request.getSession();
                session.setAttribute("user_id", username);
                response.sendRedirect("ProfileServlet");
            }
            catch(Exception e){
                out.println("<h1>Error: Connection Failed to database</h1>");
                System.out.println(e);
            }
            
            

            
            out.println("</body></html>");
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
        processRequest(request, response);
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
