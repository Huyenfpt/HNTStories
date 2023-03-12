<%-- 
    Document   : sidebar
    Created on : Mar 11, 2023, 4:39:31 PM
    Author     : Huyen Nguyen
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div class="border-end bg-white" id="sidebar-wrapper">
    <div class="list-group list-group-flush">
        <div class="list-group-item list-group-item-action p-3">
            <div class="input-group rounded mb-2">
                <input type="search" class="form-control rounded" placeholder="Search"
                       aria-label="Search" aria-describedby="search-addon" />
                <span class="input-group-text border-0" id="search-addon">
                    <i class="bi bi-search"></i>
                </span>
            </div>
        </div>
        <a class="list-group-item list-group-item-action p-3 color-primary" href="/stories"><i
                class="bi bi-table"></i> <span class="ms-1 d-sm-inline ">View
                contents</span></a>
        <a class="list-group-item list-group-item-action p-3 color-primary" href="/stories/add"><i class="bi bi-pencil-square"></i> <span class="ms-1 d-sm-inline">Form
                content</span></a>
    </div>
</div>
