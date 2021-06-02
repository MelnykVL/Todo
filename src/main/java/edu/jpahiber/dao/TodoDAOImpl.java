package edu.jpahiber.dao;

import edu.jpahiber.model.Todo;
import edu.jpahiber.model.User;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class TodoDAOImpl implements TodoDAO{

    @Override
    public Todo get(int id) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        Todo todo = session.get(Todo.class, id);
        tx.commit();
        session.close();
        return todo;

    }

    @Override
    public void save(Todo model) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.save(model);
        tx.commit();
        session.close();

    }

    @Override
    public void update(Todo model) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.update(model);
        tx.commit();
        session.close();

    }

    @Override
    public void delete(Todo model) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.delete(model);
        tx.commit();
        session.close();

    }

    @Override
    public List<Todo> getAll() {

        return (List<Todo>) HibernateUtil.getSessionFactory().openSession().createQuery("From Todo").list();

    }
}
