package ru.kiasystems.model.test;

import ru.kiasystems.model.DAO.Impl.Hibernate.ThemeDAOImpl;
import ru.kiasystems.model.DAO.ThemeDAO;
import ru.kiasystems.model.entity.Theme;
import ru.kiasystems.model.utils.HibernateUtils;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.Collection;
import java.util.List;

/**
 * Created by User on 10.03.2016.
 */
public class Main {
    public static void main(String... args) {
        /*EntityManager em = HibernateUtils.getEntityManagerFactory().createEntityManager();
        em.getTransaction().begin();
        Query query = em.createQuery("SELECT c FROM Theme c");
        List<Theme> themes = query.getResultList();
        System.out.println(themes);
        em.getTransaction().commit();
        em.close();
        HibernateUtils.getEntityManagerFactory().close();*/
        ThemeDAO dao = new ThemeDAOImpl();
        Collection<Theme> themes = dao.getAllThemes();
        System.out.println(themes);
    }
}
