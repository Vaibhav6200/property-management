package com.auth;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;


public class loginServlet extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet loginServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            
            // authenticate user
            boolean authenticated = authenticate(username, password);
            
            HttpSession session = request.getSession();
            
            if(authenticated){
                // create session
                session.setAttribute("logged_in", true);
                response.sendRedirect("index.jsp");
            } else {
                session.setAttribute("authError", "Invalid username or password");
                request.getRequestDispatcher("login.jsp").forward(request, response);
            }
            
            out.println("</body></html>");
        }
    }

    
    private boolean authenticate(String username, String password) {
        String row = "";
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3307/project", "root", "");
            Statement stmt = con.createStatement();
            String query = "Select * FROM users WHERE username='" + username + "' AND password='" +password + "'";
            ResultSet r = stmt.executeQuery(query);
            
            if(r.next())
                row = r.getString(1);
        }
        catch(Exception e){
            e.printStackTrace();
        }
        
        if(row.length() > 0)
            return true;
        return false;
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
