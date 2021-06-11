package edu.jpahiber.controller;

import edu.jpahiber.model.User;
import edu.jpahiber.service.UserService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "SignupController", urlPatterns = {"/signup"})
public class SignupController extends HttpServlet {

    UserService userService;

    @Override
    public void init() {
        userService = new UserService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("signup.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try {
            createUser(req, resp);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void createUser(HttpServletRequest req, HttpServletResponse resp) throws Exception{
        PrintWriter out = resp.getWriter();

        String firstName = req.getParameter("first-name");
        String lastName = req.getParameter("last-name");
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        if(!userService.userVerification(username, password)){
            User user = new User(firstName, lastName, username, password);
            userService.saveUser(user);
            resp.sendRedirect("login");
        } else {
            out.write("<h2>" + "Користувач з таким іменем вже існує!" + "</h2>");
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("signup.jsp");
            requestDispatcher.include(req, resp);
        }

        out.close();

    }
}
