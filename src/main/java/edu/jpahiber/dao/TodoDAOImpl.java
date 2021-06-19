package edu.jpahiber.dao;

import edu.jpahiber.model.Todo;
import edu.jpahiber.util.JpaUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.List;

public class TodoDAOImpl implements TodoDAO{

    @Override
    public Todo get(int id) {

//        Session session = HibernateUtil.getSessionFactory().openSession();
//        Transaction tx = session.beginTransaction();
//        Todo todo = session.get(Todo.class, id);
//        tx.commit();
//        session.close();

        EntityManager em = JpaUtil.getEntityManager();
        EntityTransaction transaction = em.getTransaction();

        transaction.begin();
        Todo todo = em.find(Todo.class, id);
        transaction.commit();
        em.close();

        return todo;

    }

    @Override
    public void save(Todo model) {

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
    public void update(Todo model) {

//        Session session = HibernateUtil.getSessionFactory().openSession();
//        Transaction tx = session.beginTransaction();
//        session.update(model);
//        tx.commit();
//        session.close();

        EntityManager em = JpaUtil.getEntityManager();
        EntityTransaction transaction = em.getTransaction();

        transaction.begin();
        em.merge(model);
        transaction.commit();
        em.close();

    }

    @Override
    public void delete(Todo model) {

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
    public List<Todo> getAll() {

        EntityManager em = JpaUtil.getEntityManager();
        EntityTransaction transaction = em.getTransaction();

        transaction.begin();
        List<Todo> list = em.createQuery("SELECT t FROM Todo t").getResultList();
        transaction.commit();
        em.close();

        return list;

    }
}
