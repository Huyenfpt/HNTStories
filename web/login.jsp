<%-- 
    Document   : login
    Created on : Mar 11, 2023, 1:35:09 PM
    Author     : Huyen Nguyen
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Login</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
        <link rel="stylesheet" href="assets/css/styles.css">
    </head>

    <body>
        
        <div class="container">
            <div class="row">
                <div class="col-md-6 offset-md-3">
                    <div class="card card-login-register mx-auto">
                        <div class="card-header">
                            <h3 class="card-title">Please Sign In</h3>
                        </div>
                        <div class="card-body">
                            <p id="content">${error}</p>
                            <form action="login" method="post">
                                <div class="form-group">
                                    <input type="email" name="email" class="form-control mb-3" value="${email}" placeholder="Enter email"
                                           required>
                                </div>
                                <div class="form-group">
                                    <input type="password" name="password" value="${password}" class="form-control mb-3" placeholder="Password"
                                           required>
                                </div>

                                <button type="submit" class="btn btn-lg btn-success w-100">Login</button>
                            </form>
                        </div>
                        <div class="card-body">
                            <a href="register">Click here to register</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>

</html>