package edu.jpahiber.dao;

import edu.jpahiber.model.User;

import java.util.Optional;

public class UserDAOImpl implements UserDAO{

    @Override
    public Optional get(Integer id) {
        return Optional.empty();
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
    public boolean userVerification(String username, String pass) {
        return false;
    }
}
