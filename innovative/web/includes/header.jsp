<%-- 
    Document   : header
    Created on : 21 Apr, 2023, 3:14:07 AM
    Author     : Vaibhav
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

  <!-- ======= Navbar ======= -->
  <nav class="navbar navbar-default navbar-trans navbar-expand-lg fixed-top">
    <div class="container">
      <button class="navbar-toggler collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#navbarDefault"
        aria-controls="navbarDefault" aria-expanded="false" aria-label="Toggle navigation">
        <span></span>
        <span></span>
        <span></span>
      </button>
      <a class="navbar-brand text-brand" href="index.html">Housing<span class="color-b">Agency</span></a>

      <div class="navbar-collapse collapse justify-content-center" id="navbarDefault">
        <ul class="navbar-nav">

          <li class="nav-item">
            <a class="nav-link active" href="index.jsp">Home</a>
          </li>

          <li class="nav-item">
            <a class="nav-link " href="about.jsp">About</a>
          </li>

          <li class="nav-item">
            <a class="nav-link " href="property_grid.jsp">Featured Property</a>
          </li>
          <li class="nav-item">
            <a class="nav-link " href="contact.jsp">Contact</a>
          </li>

          <%
                Boolean logged_in_obj = (Boolean) session.getAttribute("logged_in");
                boolean logged_in = (logged_in_obj != null) ? logged_in_obj : false;
                if(logged_in == true){
          %>
            <li class="nav-item">
              <a class="nav-link " href="logout.jsp" style="margin-left:70px">Logout</a>
            </li>
          <% } else { %>
            <li class="nav-item">
              <a class="nav-link " href="register.html" style="margin-left:70px">Register</a>
            </li>
            <li class="nav-item">
              <a class="nav-link " href="login.jsp">Login</a>
            </li>
          <% } %>
          
          <%
                Boolean admin_obj = (Boolean) getServletContext().getAttribute("is_admin");
                boolean is_admin = (admin_obj != null) ? admin_obj : false;
                if(is_admin){
          %>
            <li class="nav-item">
              <a class="nav-link " href="property_register.jsp">Add Property</a>
            </li>
          <% } %>
          
        </ul>
      </div>
    </div>
  </nav>
  
  <!-- End Header/Navbar -->