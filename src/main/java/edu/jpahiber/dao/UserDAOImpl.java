package edu.jpahiber.dao;

import edu.jpahiber.model.User;
import edu.jpahiber.util.JpaUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class UserDAOImpl implements UserDAO{

    @Override
    public User get(int id) {
        EntityManager em = JpaUtil.getEntityManager();
        EntityTransaction transaction = em.getTransaction();

        transaction.begin();
        User user = em.find(User.class, id);
        transaction.commit();
        em.close();

        return user;
    }

    @Override
    public void save(User model) {
        EntityManager em = JpaUtil.getEntityManager();
        EntityTransaction transaction = em.getTransaction();

        transaction.begin();
        em.persist(model);
        transaction.commit();
        em.close();
    }

    @Override
    public void update(User model) {
        EntityManager em = JpaUtil.getEntityManager();
        EntityTransaction transaction = em.getTransaction();

        transaction.begin();
        em.merge(model);
        em.flush();
        transaction.commit();
        em.close();
    }

    @Override
    public void delete(User model) {
        EntityManager em = JpaUtil.getEntityManager();
        EntityTransaction transaction = em.getTransaction();

        transaction.begin();
        em.remove(model);
        transaction.commit();
        em.close();
    }

    @Override
    public User verification(String username, String pass) {
        User user = null;
        EntityManager em = JpaUtil.getEntityManager();
        EntityTransaction transaction = em.getTransaction();

        transaction.begin();

        try {
            user = (User) em.createQuery("SELECT u FROM User u WHERE u.username = :username")
                    .setParameter("username", username)
                    .getSingleResult();
        } catch (Exception e){
            e.printStackTrace();
        }

        transaction.commit();
        em.close();

        return user != null && user.getPassword().equals(pass) ? user : null;
    }


}
