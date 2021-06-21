package edu.jpahiber.service;

import edu.jpahiber.dao.TodoDAOImpl;
import edu.jpahiber.model.Todo;

import java.util.List;

public class TodoService {

    private final TodoDAOImpl todoDAOImpl = new TodoDAOImpl();

    public TodoService(){}

    public Todo getTodo(int id){
        return todoDAOImpl.get(id);
    }

    public void saveTodo(Todo model){
        todoDAOImpl.save(model);
    }

    public void updateTodo(Todo model){
        todoDAOImpl.update(model);
    }

    public void deleteTodo(Todo model){
        todoDAOImpl.delete(model);
    }

    public List<Todo> getAllTodos(){
        return todoDAOImpl.getAll();
    }

}
