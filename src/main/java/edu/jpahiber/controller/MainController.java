package edu.jpahiber.controller;

import edu.jpahiber.model.Todo;
import edu.jpahiber.model.User;
import edu.jpahiber.service.TodoService;
import edu.jpahiber.service.UserService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "MainController", urlPatterns = {"/main"})
public class MainController extends HttpServlet {

    UserService userService;
    TodoService todoService;
    User user = null;

    @Override
    public void init() throws ServletException {
        userService = new UserService();
        todoService = new TodoService();
        user = userService.getUser(9);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("main.jsp");
        requestDispatcher.include(req, resp);
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
        resp.setContentType("text/html; charset=UTF-8");
        PrintWriter out = resp.getWriter();

        String title = req.getParameter("title");
        String description = req.getParameter("description");

        out.write("<script type=\"text/javascript\">\n" +
                "console.log(" + user + ")" +
                "</script>");

        Todo todo = new Todo(title, description, user);
        user.addTodo(todo);

        out.write("<script type=\"text/javascript\">\n" +
                "console.log(" + todo + ")" +
                "</script>");

        userService.updateUser(user);

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("main.jsp");
        requestDispatcher.include(req, resp);

    }

}
