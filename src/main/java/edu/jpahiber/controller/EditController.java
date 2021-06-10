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

@WebServlet(name = "EditController", urlPatterns = {"/edit"})
public class EditController extends HttpServlet {

    TodoService todoService;
    UserService userService;
    Todo todo = null;
    User user = null;
    int id;

    @Override
    public void init() throws ServletException {
        userService = new UserService();
        todoService = new TodoService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");

        id = Integer.parseInt(req.getParameter("id"));

        user = userService.getUser(10);
        todo = todoService.getTodo(id);

        req.setAttribute("username", user.getUsername());
        req.setAttribute("todo", todo);

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("edit-task.jsp");
        requestDispatcher.forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try {
            editTask(req, resp);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void editTask(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        req.setCharacterEncoding("UTF-8");

        String title = req.getParameter("title");
        String description = req.getParameter("description");
        Boolean status = Boolean.parseBoolean(req.getParameter("status"));

        todo.setTitle(title);
        todo.setDescription(description);
        todo.setDone(status);

        todoService.updateTodo(todo);

        resp.sendRedirect("main");

    }

}
