package ru.kiasystems.model.utils;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class HibernateUtils {
    private static EntityManagerFactory entityManagerFactory;

    public static EntityManagerFactory getEntityManagerFactory() {
        if (entityManagerFactory == null) {
            synchronized (HibernateUtils.class) {
                if (entityManagerFactory == null)
                    entityManagerFactory = Persistence.createEntityManagerFactory("HibernateJPATest");
            }
        }
        return entityManagerFactory;
    }
}
