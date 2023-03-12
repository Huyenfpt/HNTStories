/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dao.AccountDao;
import entities.Account;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.EOFException;
import java.io.IOException;

/**
 *
 * @author Huyen Nguyen
 */
public class LoginController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //Login
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        String error = null;
        try {
            if (!isNotEmpty(email)) {
                throw new EOFException("chua nhap email");
            }
            if (!isNotEmpty(password)) {
                throw new EOFException("chua nhap password");
            }
            AccountDao dao = new AccountDao();
            Account a = dao.findByEmailAndPassword(email, password);

            if (a == null) {
                throw new EOFException("Tai khoan khong ton tai");
            }
            HttpSession s = req.getSession();
            s.setAttribute("account", a);

        } catch (Exception e) {
            error = e.getMessage();
        }
        if (error != null) {
            req.setAttribute("email", email);
            req.setAttribute("password", password);
            req.setAttribute("error", error);
            req.getRequestDispatcher("login.jsp").forward(req, resp);
        } else {
            resp.sendRedirect("/stories");
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("login.jsp").forward(req, resp);
    }

    private boolean isNotEmpty(String value) {
        return value != null && !value.isEmpty();
    }

}
