/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dao.CategoryDao;
import dao.StoriesDao;
import entities.Account;
import entities.Category;
import entities.Stories;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.EOFException;
import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import java.util.List;

/**
 *
 * @author Huyen Nguyen
 */
public class AddStoriesController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String title = req.getParameter("title");
        String category = req.getParameter("category");
        String status = req.getParameter("status");
        String createDate = req.getParameter("createDate");
        String description = req.getParameter("description");
        HttpSession session = req.getSession();
        Account account = (Account) session.getAttribute("account");
        CategoryDao cdao = new CategoryDao();
        List<Category> listCategory = cdao.findCategoryByAccount(account.getId());
        String error = null;
        try {
            if (!isNotEmpty(title)) {
                throw new EOFException("Chua nhap Title");
            }
            if (!isNotEmpty(category)) {
                throw new EOFException("Chua chon category");
            }
            if (!isNotEmpty(status)) {
                throw new EOFException("Chua chon status");
            }
            if (!isNotEmpty(createDate)) {
                throw new EOFException("Chua chon ngay");
            }
            if (!isNotEmpty(description)) {
                throw new EOFException("Chua nhap description");
            }

            StoriesDao dao = new StoriesDao();
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate date = LocalDate.parse(createDate, dtf);
            Stories s = new Stories();
            s.setTitle(title);
            s.setAccountId(account.getId());
            s.setCategoryId(Integer.parseInt(category));
            s.setCreateDate(Date.valueOf(date));
            s.setStatus(status);
            s.setDescription(description);

            dao.addStoriesByAccount(s);

        } catch (Exception e) {
            error = e.getMessage();
        }
        if (error != null) {
            req.setAttribute("title", title);
            req.setAttribute("category", category);
            req.setAttribute("status", status);
            req.setAttribute("createDate", createDate);
            req.setAttribute("description", description);
            req.setAttribute("category", listCategory);
            req.setAttribute("error", error);
            req.getRequestDispatcher("/addStories.jsp").forward(req, resp);
        } else {
            resp.sendRedirect("/stories/add");
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //chổ ni là lấy account để list ra category của account đó
        HttpSession s = req.getSession();
        Account acc = (Account) s.getAttribute("account");
        CategoryDao dao = new CategoryDao();
        List<Category> listCategory = dao.findCategoryByAccount(acc.getId());
        req.setAttribute("category", listCategory);
        req.getRequestDispatcher("/addStories.jsp").forward(req, resp);
    }

    private boolean isNotEmpty(String value) {
        return value != null && !value.isEmpty();
    }

}
