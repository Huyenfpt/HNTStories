<%-- 
    Document   : addStories
    Created on : Mar 11, 2023, 4:40:26 PM
    Author     : Huyen Nguyen
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Document</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.3.0/font/bootstrap-icons.css">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/styles.css">
        <script type="text/javascript" src="${pageContext.request.contextPath}/ckeditor/ckeditor.js"></script>
    </head>

    <body>
        <jsp:include page="layout/header.jsp"/>
        <div class="d-flex" id="wrapper">
            <jsp:include page="layout/sidebar.jsp"/>
            <div id="page-content-wrapper">
                <div class="container-fluid">
                    <h3 class="border-bottom p-3">Add content</h3>
                    <div class="card">
                        <div class="card-header">
                            <h3 class="card-title fs-6">Content form elements</h3>
                        </div>
                        <div class="card-body">
                            <p id="content"></p>
                            <form action="#" method="post" id="myForm">
                                <div class="form-group">
                                    <label for="Title">Title</label>
                                    <input type="text" name="title" class="form-control mb-3" id="title"
                                           placeholder="Enter the title" required>
                                </div>
                                <div class="form-group">
                                    <label for="Brief">Brief</label>
                                    <textarea class="form-control mb-3" id="brief"></textarea>
                                </div>
                                <div class="form-group">
                                    <label for="Content">Content</label>
                                    <textarea style="height: 200px;" id="describe" name="describe" ></textarea>
                                </div>
                                <button type="button" class="btn btn-success" onclick="checkContent()">Submit button</button>
                                <button type="button" class="btn btn-success" onclick="clearForm()">Reset button</button>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
        <script>
            var editor = '';
            $(document).ready(function () {
                editor = CKEDITOR.replace('describe');
            });
        </script>

        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
        <script src="${pageContext.request.contextPath}/assets/js/app.js"></script>
    </body>

</html>
