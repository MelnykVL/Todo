package edu.jpahiber.dao;

import edu.jpahiber.model.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;
import java.util.Optional;

public class UserDAO implements DAO<User> {

    private EntityManagerFactory emf;
    private EntityManager entityManager;

    public UserDAO(EntityManagerFactory emf) {
        if(emf != null)
            this.emf = emf;
    }

    @Override
    public Optional<User> get(Integer id) {

        return Optional.ofNullable(entityManager.find(User.class, id));
    }

    @Override
    public void save(User model) {

    }

    @Override
    public void update(User model) {

    }

    @Override
    public void delete(Integer id) {

    }

    @Override
    public List<User> getAll() {
        return null;
    }
}
