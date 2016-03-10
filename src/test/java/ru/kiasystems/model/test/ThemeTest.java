package ru.kiasystems.model.test;


import ru.kiasystems.model.entity.Theme;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import junit.framework.TestCase;

import java.util.Date;
import java.util.List;

public class ThemeTest extends TestCase{
    private EntityManagerFactory entityManagerFactory;

    @Override
    protected void setUp() throws Exception {
        // like discussed with regards to SessionFactory, an EntityManagerFactory is set up once for an application
        // 		IMPORTANT: notice how the name here matches the name we gave the persistence-unit in persistence.xml!

        entityManagerFactory = Persistence.createEntityManagerFactory( "HibernateJPATest" );
    }

    @Override
    protected void tearDown() throws Exception {
        entityManagerFactory.close();
    }

    public void testBasicUsage() {
        // create a couple of events...
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist( new Theme( "Our very first event!", new Date() ) );
        entityManager.persist( new Theme( "A follow up event", new Date() ) );
        entityManager.getTransaction().commit();
        entityManager.close();

        // now lets pull events from the database and list them
        entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        List<Theme> result = entityManager.createQuery( "select t from Theme t", Theme.class ).getResultList();

        for ( Theme event : result ) {
            System.out.println( "Theme (" + event.getStartDate() + ") : " + event.getTitle() );
        }
        entityManager.getTransaction().commit();
        entityManager.close();
        System.out.println("ТЕСТЫ");
    }
}
