<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang='en'>
<head>
    <meta charset='UTF-8'>
    <meta name='viewport' content='width=device-width, initial-scale=1.0'>
    <meta http-equiv='X-UA-Compatible' content='ie=edge'>
    <title> Profile Page </title>
</head>
<body>

  <%@ include file="/includes/header.jsp" %>
  
  
        <p>welcome ${sessionScope.user_id} to Home Page</p>
        <p>this username we got from the session created when we registered/logged you in</p>

        
    
  <%@include file="/includes/footer.jsp" %> %>
  
        
</body>
</html>