package edu.jpahiber.dao;

import java.util.List;
import java.util.Optional;

public interface DAO<T> {

    Optional get(Integer id);
    void save(T model);
    void update(T model);
    void delete(Integer id);

    List<T> getAll();

}
