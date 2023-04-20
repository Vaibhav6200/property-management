<%-- 
    Document   : login
    Created on : 20 Apr, 2023, 8:30:29 PM
    Author     : Vaibhav
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Login</title>
    <link rel="stylesheet" href="assets/fonts/material-icon/css/material-design-iconic-font.min.css">
    <link rel="stylesheet" href="assets/css/login.css">
</head>
<body>

    <div class="main">
        <section class="sign-in">
            <div class="container">
                <div class="signin-content">
                    <div class="signin-image">
                        <figure> <img src="assets/img/login_image.png" alt="sing up image" height="100px"> </figure>
                        <span class="signup-image-link"><b>Create a New Account</b></span>
                        <a href="register.html" class="signup-image-link" style="color:#924747;">Register HERE !!</a>
                    </div>
                    
                    <div class="signin-form">
                        <h2 class="form-title">LOGIN</h2>
                        <form method="post" action="loginServlet" class="register-form" id="login-form">
                            <div class="form-group">
                                <label for="username"><i class="zmdi zmdi-account material-icons-name"></i></label> 
                                <input type="text" name="username" id="username" placeholder="USERNAME" />
                            </div>
                            <div class="form-group">
                                <label for="password"><i class="zmdi zmdi-lock"></i></label> 
                                <input type="password" name="password" id="password" placeholder="PASSWORD" />
                            </div>

                            <div class="form-group form-button">
                                <input type="submit" name="signin" id="signin" class="form-submit" value="LOGIN" />
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </section>
    </div>

	<!-- JS -->
	<script src="assets/vendor/jquery/jquery.min.js"></script>
	<script src="assets/js/main.js"></script>
</body>
</html>