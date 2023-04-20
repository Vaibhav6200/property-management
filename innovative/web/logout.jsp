<%-- 
    Document   : logout
    Created on : 21 Apr, 2023, 3:59:39 AM
    Author     : Vaibhav
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    session.setAttribute("logged_in", false);
    response.sendRedirect("index.jsp");
%>
        

