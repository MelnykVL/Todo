package edu.jpahiber.dao;


import edu.jpahiber.model.Todo;
import edu.jpahiber.model.User;

import java.util.List;

public interface UserDAO extends DAO<User> {

    boolean userVerification(String username, String pass);

}
