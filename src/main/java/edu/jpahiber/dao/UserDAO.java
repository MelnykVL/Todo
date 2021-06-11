package edu.jpahiber.dao;


import edu.jpahiber.model.User;

public interface UserDAO extends DAO<User> {

    User verification(String username, String pass);

}
