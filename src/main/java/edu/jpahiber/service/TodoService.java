package edu.jpahiber.service;

import edu.jpahiber.dao.TodoDAO;
import edu.jpahiber.dao.TodoDAOImpl;
import edu.jpahiber.model.Todo;

import java.util.List;

public class TodoService {

    private TodoDAO todoDAO = new TodoDAOImpl();

    public TodoService(){}

    public void getTodo(int id){
        todoDAO.get(id);
    }

    public void saveTodo(Todo model){
        todoDAO.save(model);
    }

    public void updateTodo(Todo model){
        todoDAO.update(model);
    }

    public void deleteTodo(Todo model){
        todoDAO.delete(model);
    }

    public List<Todo> getAllTodos(){
        return todoDAO.getAll();
    }

}
