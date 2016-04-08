package ru.kiasystems.model.test;

import ru.kiasystems.model.entity.Theme;
import ru.kiasystems.model.utils.HibernateUtils;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.Collection;
import java.util.Date;
import java.util.List;

public class Main {
    public static void main(String... args) {
        EntityManager em = HibernateUtils.getEntityManagerFactory().createEntityManager();
        em.getTransaction().begin();
        Theme t1 = new Theme();
        t1.setTitle("Тема 1");
        t1.setStartDate(new Date());
        em.persist(t1);
        t1 = new Theme();
        t1.setTitle("Тема 2");
        t1.setStartDate(new Date());
        em.persist(t1);
        Query query = em.createQuery("SELECT c FROM Theme c");
        List<Theme> themes = query.getResultList();
        System.out.println(themes);
        em.getTransaction().commit();
        em.close();
        HibernateUtils.getEntityManagerFactory().close();
    }
}
