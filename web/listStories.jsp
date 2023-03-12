<%-- 
    Document   : listStories
    Created on : Mar 12, 2023, 3:32:46 PM
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
    <title>Document</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.2/css/all.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}assets/css/styles.css">
</head>

<body>
<jsp:include page="layout/header.jsp"/>

<div class="d-flex" id="wrapper">
    <jsp:include page="layout/sidebar.jsp"/>
    <div id="page-content-wrapper">
        <div class="container-fluid">
            <div class="row">
                <div class="col-lg-12">
                    <h3 class="border-bottom p-3">Stories List</h3>
                    <div class="card">
                        <div class="card-body table-responsive">
                            <form>
                                <div class="row justify-content-end">
                                    <div class="pb-3 row m-0">
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
                                                class="btn btn-primary" type="button">Submit</button></span>
                                        </div>
                                    </div>
                                </div>
                            </form>
                            <table class="table table-striped table-bordered">
                                <thead>
                                <tr>
                                    <th>ID</th>
                                    <th>Title</th>
                                    <th>Category</th>
                                    <th>Create Date</th>
                                    <th>Update Date</th>
                                    <th>Status</th>
                                    <th>Action</th>
                                </tr>
                                </thead>
                                <tbody id="table-content">
                                    <c:forEach items="${stories}" var="s">
                                        <tr>
                                            <td>${s.storiesId}</td>
                                            <td>${s.title}</td>
                                            <td>${s.category.categoryName}</td>
                                            <td>${s.createDate}</td>
                                            <td>${s.updateDate}</td>
                                            <td>${s.status}</td>
                                            <td style="width: 190px; align-items: center">
                                                <button class="btn btn-danger">Delete</button>
                                                <button class="btn btn-primary">Detail</button>
                                            </td>
                                        </tr>
                                    </c:forEach>
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
<script src="${pageContext.request.contextPath}/assets/js/app.js"></script>
</body>

</html>
