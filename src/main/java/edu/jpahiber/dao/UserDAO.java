package edu.jpahiber.dao;


import edu.jpahiber.model.User;

public interface UserDAO extends DAO<User> {

    boolean userVerification(String username, String pass);

}
