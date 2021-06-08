package edu.jpahiber.service;

import edu.jpahiber.dao.UserDAOImpl;
import edu.jpahiber.model.User;

public class UserService {

    private final UserDAOImpl userDAOImpl = new UserDAOImpl();

    public UserService(){}

    public User getUser(int id){
        return (User) userDAOImpl.get(id);
    }

    public void saveUser(User model){
        userDAOImpl.save(model);
    }

    public void updateUser(User model){
        userDAOImpl.update(model);
    }

    public void deleteUser(User model){
        userDAOImpl.delete(model);
    }

}
