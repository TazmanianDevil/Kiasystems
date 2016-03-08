package ru.kiasystems.model.utils;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class HibernateUtils {
    private static EntityManagerFactory entitytManagerFactory;

    public static EntityManagerFactory getEntitytManagerFactory() {
        if (entitytManagerFactory == null) {
            synchronized (HibernateUtils.class) {
                if (entitytManagerFactory == null)
                    entitytManagerFactory = Persistence.createEntityManagerFactory("HibernateJPA");
            }
        }
        return entitytManagerFactory;
    }
}
