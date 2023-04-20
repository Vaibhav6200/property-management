package com.auth;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;


public class authServlet extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet authServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            
            String btn = request.getParameter("btn");   
            
            // include navbar
            request.getRequestDispatcher("index.html").include(request, response);
            
            // get session if it exists
            HttpSession session = request.getSession(false);
            
            
            if(btn.equals("register")){
                response.sendRedirect("login.jsp");
            }
            
            else if(btn.equals("login")){
                // include login page (if user is not authticated)
                if(session == null)
                    response.sendRedirect("login.jsp");
                else
                    request.getRequestDispatcher("ProfileServlet").forward(request, response);
            }
            else if(btn.equals("logout")){
                // Break our session
                if (session != null){
                    session.invalidate();
                    out.println("logged out Successfully!");
                }
                else{
                    out.println("User is already logged out");
                }
            }
            else if(btn.equals("profile")){
                // check if user already logged in 
                
                if(session != null){        // means user already logged in so simply redirect to ProfileServlet
                    request.getRequestDispatcher("ProfileServlet").forward(request, response);
                }
                else{
                    // else display appropriate error
                    out.println("Please first Login to access Profile Page");
                    // include loginpage.html
                }
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
