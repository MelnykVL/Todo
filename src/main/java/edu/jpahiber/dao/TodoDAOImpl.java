package edu.jpahiber.dao;

import edu.jpahiber.model.Todo;

import java.util.List;
import java.util.Optional;

public class TodoDAOImpl implements TodoDAO{

    @Override
    public Optional get(Integer id) {
        return Optional.empty();
    }

    @Override
    public void save(Todo model) {

    }

    @Override
    public void update(Todo model) {

    }

    @Override
    public void delete(Integer id) {

    }

    @Override
    public List<Todo> getAll() {
        return null;
    }
}
