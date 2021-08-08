package edu.jpahiber.dao;

import edu.jpahiber.model.Todo;
import edu.jpahiber.util.JpaUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.List;

public class TodoDAOImpl implements TodoDAO{

    @Override
    public Todo get(int id) {
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
        EntityManager em = JpaUtil.getEntityManager();
        EntityTransaction transaction = em.getTransaction();

        transaction.begin();
        em.persist(model);
        em.flush();
        transaction.commit();
        em.close();
    }

    @Override
    public void update(Todo model) {
        EntityManager em = JpaUtil.getEntityManager();
        EntityTransaction transaction = em.getTransaction();

        transaction.begin();
        em.merge(model);
        transaction.commit();
        em.close();
    }

    @Override
    public void delete(Todo model) {
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
