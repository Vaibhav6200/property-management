package com.auth;


import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;


public class propertyServlet extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String location = request.getParameter("location");
        String property_type = request.getParameter("property_type");
        String status = request.getParameter("status");
        String area = request.getParameter("area");
        String beds = request.getParameter("beds");
        String balcony = request.getParameter("balcony");
        String baths = request.getParameter("baths");
        String description = request.getParameter("description");
        String price = request.getParameter("price");
        String swimming_pool = request.getParameter("swimming_pool");
        String gym = request.getParameter("gym");
        String garden = request.getParameter("garden");
        String club_house = request.getParameter("club_house");
        String internet = request.getParameter("internet");
        String badminton = request.getParameter("badminton");
        
        Part filePart1 = request.getPart("image1");
        String fileName1 = filePart1.getSubmittedFileName();
        InputStream fileContent1 = filePart1.getInputStream();
        
        Part filePart2 = request.getPart("image2");
        String fileName2 = filePart2.getSubmittedFileName();
        InputStream fileContent2 = filePart2.getInputStream();
    
        Part filePart3 = request.getPart("image3");
        String fileName3 = filePart3.getSubmittedFileName();
        InputStream fileContent3 = filePart3.getInputStream();        
        
        
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3307/project", "root", "");
            String sql = "INSERT INTO property (location, property_type, status, area, beds, balcony, baths, description, price, "
                    + "swimming_pool, gym, garden, club_house, internet, badminton, card_image, image1, image2) "
                    + "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);";
            PreparedStatement stmt = conn.prepareStatement(sql);
            
            stmt.setString(1, location);
            stmt.setString(2, property_type);
            stmt.setString(3, status);
            stmt.setString(4, area);
            stmt.setString(5, beds);
            stmt.setString(6, balcony);
            stmt.setString(7, baths);
            stmt.setString(8, description);
            stmt.setString(9, price);
            stmt.setString(10, swimming_pool);
            stmt.setString(11, gym);
            stmt.setString(12, garden);
            stmt.setString(13, club_house);
            stmt.setString(14, internet);
            stmt.setString(15, badminton);
            stmt.setBinaryStream(16, fileContent1);
            stmt.setBinaryStream(17, fileContent2);
            stmt.setBinaryStream(18, fileContent3);
            
            int result = stmt.executeUpdate();
        }
        catch(Exception e){
            PrintWriter out = response.getWriter();
            out.println("<h1>Got exception in properpty Servlet, Failed to connect to databases</h1>");
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
