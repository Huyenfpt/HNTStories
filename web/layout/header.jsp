<%-- 
    Document   : header.jsp
    Created on : Mar 11, 2023, 4:38:37 PM
    Author     : Huyen Nguyen
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div class="navbar navbar-light bg-light static-top border-bottom">
    <div class="container-fluid">
        <div class="navbar-brand">
            <button class="btn btn-light" id="sidebarToggle"><span class="navbar-toggler-icon"></span></button>
            <a href="#" class="text-decoration-none text-black">HNTStories</a>
        </div>
        <li class="list-inline-item mb-0 ms-1">
            <div class="dropdown dropdown-primary">
                <button type="button" class="btn btn-pills btn-soft-primary dropdown-toggle color-primary p-0"
                        data-bs-toggle="dropdown" aria-haspopup="true" aria-expanded="false"><i
                        class="bi bi-person-fill"></i></button>
                <div class="dropdown-menu dd-menu dropdown-menu-end bg-white shadow border-0 mt-3 py-3"
                     style="min-width: 200px;">
                    <a class="dropdown-item text-dark" href="edit-profile.html"><span
                            class="mb-0 d-inline-block me-1"><i class="bi bi-person-fill"></i></span> User
                        profile</a>
                    <div class="dropdown-divider border-top"></div>
                    <a class="dropdown-item text-dark" href="login.html"><span
                            class="mb-0 d-inline-block me-1"><i class="bi bi-box-arrow-right"></i></span>
                        Logout</a>
                </div>
            </div>
        </li>
    </div>
</div>
