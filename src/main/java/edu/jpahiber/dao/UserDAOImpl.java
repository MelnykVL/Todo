package edu.jpahiber.dao;

import edu.jpahiber.model.User;
import edu.jpahiber.util.JpaUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class UserDAOImpl implements UserDAO{

    @Override
    public User get(int id) {

//        Session session = HibernateUtil.getSessionFactory().openSession();
//        Transaction tx = session.beginTransaction();
//        User user = session.get(User.class, id);
//        tx.commit();
//        session.close();

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

//        Session session = HibernateUtil.getSessionFactory().openSession();
//        Transaction tx = session.beginTransaction();
//        session.save(model);
//        tx.commit();
//        session.close();

        EntityManager em = JpaUtil.getEntityManager();
        EntityTransaction transaction = em.getTransaction();

        transaction.begin();
        em.persist(model);
        transaction.commit();
        em.close();

    }

    @Override
    public void update(User model) {

//        Session session = HibernateUtil.getSessionFactory().openSession();
//        Transaction tx = session.beginTransaction();
//        session.update(model);
//        tx.commit();
//        session.close();

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

//        Session session = HibernateUtil.getSessionFactory().openSession();
//        Transaction tx = session.beginTransaction();
//        session.delete(model);
//        tx.commit();
//        session.close();

        EntityManager em = JpaUtil.getEntityManager();
        EntityTransaction transaction = em.getTransaction();

        transaction.begin();
        em.remove(model);
        transaction.commit();
        em.close();

    }

    @Override
    public User verification(String username, String pass) {

//        User user = null;
//        Session session = HibernateUtil.getSessionFactory().openSession();
//        Transaction tx = session.beginTransaction();
//        user = (User) session.createQuery("From User u WHERE u.username = :username").setParameter("username", username).uniqueResult();
//        tx.commit();
//        session.close();

        User user = null;
        EntityManager em = JpaUtil.getEntityManager();
        EntityTransaction transaction = em.getTransaction();

        transaction.begin();

        try {
            user = (User) em.createQuery("SELECT u FROM User u WHERE u.username = :username")
                    .setParameter("username", username)
                    .getSingleResult();
        } catch (Exception e){
            user = null;
        }

        transaction.commit();
        em.close();

        return user != null && user.getPassword().equals(pass) ? user : null;

    }


}
