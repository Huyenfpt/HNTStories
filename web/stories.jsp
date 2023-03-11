<%-- 
    Document   : stories
    Created on : Mar 11, 2023, 4:18:05 PM
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
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.2/css/all.min.css">
    <link rel="stylesheet" href="assets/css/styles.css">
</head>

<body>
<div class="navbar navbar-expand-lg navbar-light bg-light border-bottom">
    <div class="container-fluid">
        <div class="navbar-brand">
            <button class="btn" id="sidebarToggle"><span class="navbar-toggler-icon"></span></button>
            <a href="#" class="text-decoration-none text-black"><i class="fa-solid fa-users"></i> Employee</a>
        </div>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse"
                data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false"
                aria-label="Toggle navigation"><span class="navbar-toggler-icon"></span></button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav ms-auto mt-2 mt-lg-0">
                <li class="nav-item"><a class="nav-link" href="#!"><span class="color-primary">Welcome </span></a></li>
                <li class="nav-item"><a class="nav-link color-primary" href="/logout"><span class="color-primary"><i
                        class="fa-solid fa-arrow-right-from-bracket"></i> Logout</span> </a></li>
            </ul>
        </div>
    </div>
</div>

<div class="d-flex" id="wrapper">
    <div class="border-end bg-white" id="sidebar-wrapper">
        <div class="list-group list-group-flush">
            <a class="list-group-item list-group-item-action p-3 color-primary" href="#"><i
                    class="fa-solid fa-gauge"></i> <span class="ms-1 d-sm-inline ">Dashboard</span></a>
        </div>
    </div>
    <div id="page-content-wrapper">
        <div class="container-fluid">
            <div class="row">
                <div class="col-lg-12">
                    <h3 class="border-bottom p-3">Employee List</h3>
                    <div class="card">
                        <div class="card-body table-responsive">
                            <form>
                                <div class="row justify-content-end">
                                    <div class="col-5 pb-3 row m-0">
                                        <div class="col-6">
                                            <div class="input-group">
                                                <span class="input-group-btn"><button class="btn btn-light disabled"
                                                                                      type="button"><i
                                                        class="fa-duotone fa-magnifying-glass"></i></button></span>
                                                <input type="text" class="form-control" placeholder="Search for...">
                                            </div>
                                        </div>
                                        <div class="col-3">
                                            <div class="input-group"><span class="input-group-btn"><button
                                                    class="btn btn-light" type="button">Filter By</button></span>
                                                <select class="form-control">
                                                    <option>All</option>
                                                    <option>Active</option>
                                                    <option>Inactive</option>
                                                </select>
                                            </div>
                                        </div>
                                        <div class="col-3"><span class="input-group-btn"><button
                                                class="btn btn-light" type="button">Submit</button></span>
                                        </div>
                                    </div>
                                </div>
                            </form>
                            <table class="table table-striped table-bordered">
                                <thead>
                                <tr>
                                    <th>ID</th>
                                    <th>Name</th>
                                    <th>Date of birth</th>
                                    <th>Address</th>
                                    <th>Phone number</th>
                                    <th>Derpartment</th>
                                    <th>Action</th>
                                </tr>
                                </thead>
                                <tbody id="table-content">

                                </tbody>
                            </table>
                        </div>
                        <div class="card-body">
                            <ul class="pagination" id="pagination">
                            </ul>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
<script src="assets/js/app.js"></script>
</body>

</html>