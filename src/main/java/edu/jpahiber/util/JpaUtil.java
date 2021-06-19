package edu.jpahiber.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JpaUtil {

    private static EntityManagerFactory emf = null;

    public static EntityManager getEntityManager(){
        if (emf == null)
            emf = Persistence.createEntityManagerFactory("my-persistence-unit");
        return emf.createEntityManager();
    }

}
