/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dao.AccountDao;
import entities.Account;
import entities.Role;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.EOFException;
import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;

/**
 *
 * @author Huyen Nguyen
 */
public class RegisterController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        String confirmPassword = req.getParameter("confirmPassword");
        String error = null;

        try {
            if (!isNotEmpty(email)) {
                throw new EOFException("chua nhap email");
            }
            if (!isNotEmpty(password)) {
                throw new EOFException("chua nhap password");
            }
            if (!isNotEmpty(confirmPassword)) {
                throw new EOFException("chua nhap confirmPassword");
            }
            if (!confirmPassword.equals(password)) {
                throw new EOFException("confirmPassword va password khong giong nhau");
            }
            AccountDao accountDao = new AccountDao();
            if(accountDao.checkEmail(email)){
                throw  new EOFException("Email da dang ky");
            }
            Account a = new Account();
            Role r = new Role();
            r.setId(2);// vì mày chỉ được là người đăng ký thôi nỏ phải admin
            a.setRole(r);
            a.setEmail(email);
            a.setPassword(password);
            a.setCreateAt(Date.valueOf(LocalDate.now()));
            a.setUpdateAt(Date.valueOf(LocalDate.now()));
            accountDao.addAccount(a);
        } catch (Exception e) {
            error = e.getMessage();
        }
        if (error != null) {
            req.setAttribute("email", email);
            req.setAttribute("password", password);
            req.setAttribute("confirmPassword", confirmPassword);
            req.setAttribute("error", error);
            req.getRequestDispatcher("register.jsp").forward(req, resp);
        } else {
            resp.sendRedirect("login");
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("register.jsp").forward(req, resp);
    }

    private boolean isNotEmpty(String value) {
        return value != null && !value.isEmpty();
    }

}
