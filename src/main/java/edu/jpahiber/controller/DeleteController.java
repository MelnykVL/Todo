package edu.jpahiber.controller;

import edu.jpahiber.model.Todo;
import edu.jpahiber.model.User;
import edu.jpahiber.service.TodoService;
import edu.jpahiber.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "DeleteController", urlPatterns = {"/delete"})
public class DeleteController extends HttpServlet {

    HttpSession session = null;
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

        session = req.getSession();

        id = Integer.parseInt(req.getParameter("id"));

        todo = todoService.getTodo(id);
        user = todo.getUser();
        user.removeTodo(todo);

        userService.updateUser(user);

        session.setAttribute("user", user);

        resp.sendRedirect("main");

    }

}
