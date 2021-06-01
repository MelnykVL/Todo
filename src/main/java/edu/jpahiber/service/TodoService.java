package edu.jpahiber.service;

import edu.jpahiber.dao.TodoDAO;
import edu.jpahiber.model.Todo;

import java.util.List;

public class TodoService {

    private TodoDAO todoDAO;

    public TodoService(){}

    public void getTodo(Integer id){
        todoDAO.get(id);
    }

    public void addTodo(Todo model){
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
