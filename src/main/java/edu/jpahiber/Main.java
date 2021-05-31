package edu.jpahiber;

import edu.jpahiber.dao.HibernateUtil;
import edu.jpahiber.model.Todo;
import edu.jpahiber.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        SessionFactory sessionFactory = null;
        Session session = null;
        Transaction tx = null;

        User vlad = new User("Vlad", "Melnyk", "VladkoML", "qwerty");

        Todo todo1 = new Todo("Диплом", "Написати висновки", vlad);
        Todo todo2 = new Todo("Диплом", "Зробити презентацію", vlad);
        Todo todo3 = new Todo("Дім", "Поміняти постіль", vlad);

        vlad.addTodo(todo1);
        vlad.addTodo(todo2);
        vlad.addTodo(todo3);

        vlad.getTodoList().get(1).setDone(true);

        User andrij = new User("Андрій", "Мельник", "Andre", "12345678");

        List<Todo> todoList = new ArrayList<>();
        todoList.add(new Todo("Дім", "Купити продуктів до дому", andrij));
        todoList.add(new Todo("Робота", "13:30 Об'єкт в центрі", andrij));
        todoList.add(new Todo("Робота", "17:00 Об'єкт в два", andrij));

        andrij.setTodoList(todoList);

        sessionFactory = HibernateUtil.getSessionFactory();
        session = sessionFactory.openSession();
        System.out.println("Session created!");

        tx = session.beginTransaction();

        session.save(vlad);

        session.save(todo1);
        session.save(todo2);
        session.save(todo3);

        Integer id = (Integer) session.save(andrij);

        for(Todo todo : todoList)
            session.save(todo);

        User u = session.get(User.class, id);
        System.out.println(u);

        tx.commit();

    }

    private static void jpaExample() {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistence");

        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        User user = new User();
        user.setFirstName("Oleksandr");
        user.setLastName("Ffasdg");
        user.setUsername("ASFSA");
        user.setPassword("12345678");
        em.persist(user);
        System.out.println(user.getUserId());

        em.getTransaction().commit();
        em.close();

        em = emf.createEntityManager();
        List users = em.createQuery("FROM User").getResultList();
        users.forEach(user2 -> System.out.println(user2));

        em.close();

    }

    private static void sessionExample(String firstName, String lastName, String userName, String pass) {
        SessionFactory sf = buildSessionFactory();

        Session session = sf.openSession();

        session.beginTransaction();

        User user = new User();

        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setUsername(userName);
        user.setPassword(pass);

        Integer id = (Integer) session.save(user);
        System.out.println(id);

        session.getTransaction().commit();
        session.close();

        session = sf.openSession();
        User us = session.get(User.class, id);

        System.out.println(us);
        session.close();

        session = sf.openSession();

        List<User> users = session.createQuery("FROM User", User.class).list();

        users.forEach(user1 -> System.out.println(user1));

        session.close();
    }

    private static SessionFactory buildSessionFactory(){

        try {

            StandardServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                    .configure("hibernate.cfg.xml").build();

            Metadata metadata = new MetadataSources(serviceRegistry).getMetadataBuilder().build();

            return metadata.getSessionFactoryBuilder().build();

        }catch (Throwable ex){
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }

    }
}
