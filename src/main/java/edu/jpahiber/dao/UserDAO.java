package edu.jpahiber.dao;


import edu.jpahiber.model.User;

public interface UserDAO extends DAO<User> {

    boolean verification(String username, String pass);

}
