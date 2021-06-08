package edu.jpahiber.dao;

import edu.jpahiber.model.User;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class UserDAOImpl implements UserDAO{

    @Override
    public User get(int id) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        User user = session.get(User.class, id);
        tx.commit();
        session.close();
        return user;

    }

    @Override
    public void save(User model) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.save(model);
        tx.commit();
        session.close();

    }

    @Override
    public void update(User model) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.update(model);
        tx.commit();
        session.close();

    }

    @Override
    public void delete(User model) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.delete(model);
        tx.commit();
        session.close();

    }

    @Override
    public boolean userVerification(String username, String pass) {

        return false;
    }
}
