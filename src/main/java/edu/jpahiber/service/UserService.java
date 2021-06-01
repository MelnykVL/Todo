package edu.jpahiber.service;

import edu.jpahiber.dao.UserDAO;
import edu.jpahiber.dao.UserDAOImpl;
import edu.jpahiber.model.User;

public class UserService {

    private  UserDAO userDAO;

    public UserService(){}

    public User getUser(int id){
        return userDAO.get(id);
    }

    public void saveUser(User model){
        userDAO.save(model);
    }

    public void updateUser(User model){
        userDAO.update(model);
    }

    public void deleteUser(User model){
        userDAO.delete(model);
    }

}
