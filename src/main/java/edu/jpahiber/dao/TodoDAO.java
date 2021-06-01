package edu.jpahiber.dao;

import edu.jpahiber.model.Todo;

import java.util.List;
import java.util.Optional;

public interface TodoDAO extends DAO<Todo> {

    List<Todo> getAll();

}
