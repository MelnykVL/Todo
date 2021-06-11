package edu.jpahiber.controller;

import edu.jpahiber.model.Todo;
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

@WebServlet(name = "MainController", urlPatterns = {"/main"})
public class MainController extends HttpServlet {

    UserService userService = null;
    User user = null;
    HttpSession session = null;

    @Override
    public void init() throws ServletException {
        userService = new UserService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        session = req.getSession();

        user = (User) session.getAttribute("user");

        req.setAttribute("username", user.getUsername());
        req.setAttribute("todoList", user.getTodoList());

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("main.jsp");
        requestDispatcher.forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try {
            addTask(req, resp);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }



    private void addTask(HttpServletRequest req, HttpServletResponse resp) throws Exception {

        String title = req.getParameter("title");
        String description = req.getParameter("description");

        Todo todo = new Todo(title, description, user);

        user.addTodo(todo);

        userService.updateUser(user);

        resp.sendRedirect("main");

    }

}
