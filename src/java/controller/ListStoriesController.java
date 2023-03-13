/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dao.StoriesDao;
import entities.Account;
import entities.Stories;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Huyen Nguyen
 */
public class ListStoriesController extends HttpServlet{

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       
    
    }

    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            HttpSession s = req.getSession();
            Account acc = (Account) s.getAttribute("account");
            StoriesDao dao = new StoriesDao();
            List<Stories> list = dao.listAllStories(acc.getId());
            
            req.setAttribute("stories", list);
            req.getRequestDispatcher("listStories.jsp").forward(req, resp);
        } catch (Exception ex) {
            Logger.getLogger(ListStoriesController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
