package edu.jpahiber.controller;


import edu.jpahiber.model.User;
import edu.jpahiber.service.UserService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "LoginController", urlPatterns = {"/login"})
public class LoginController extends HttpServlet {

    UserService userService;

    @Override
    public void init() {
        userService = new UserService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("index.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try {
            identification(req, resp);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void identification(HttpServletRequest req, HttpServletResponse resp) throws Exception{
        PrintWriter out = resp.getWriter();

        String username = req.getParameter("username");
        String pass = req.getParameter("password");
        User user = userService.userVerification(username, pass);

        if (user != null){
            HttpSession session = req.getSession();
            session.setAttribute("user", user);
            resp.sendRedirect("main");
        } else {

            String message = "Username or password is incorrect!";
            req.setAttribute("message", message);
            req.setAttribute("username", username);

            RequestDispatcher requestDispatcher = req.getRequestDispatcher("index.jsp");
            requestDispatcher.include(req, resp);
        }

        out.close();

    }

}
