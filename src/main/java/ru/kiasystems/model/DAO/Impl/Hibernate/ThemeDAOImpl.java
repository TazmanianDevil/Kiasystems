package ru.kiasystems.model.DAO.Impl.Hibernate;

import ru.kiasystems.model.entity.Theme;
import ru.kiasystems.model.DAO.ThemeDAO;
import java.util.Collection;
import ru.kiasystems.model.utils.HibernateUtils;
import javax.persistence.EntityManager;

public class ThemeDAOImpl implements ThemeDAO {
    @Override
    public Collection getAllThemes() {
        EntityManager entityManager = HibernateUtils.getEntityManagerFactory().createEntityManager();
        entityManager.getTransaction().begin();
        Collection<Theme> themes = entityManager.createQuery( "from Theme", Theme.class).getResultList();
        entityManager.getTransaction().commit();
        entityManager.close();
        return themes;
    }

    @Override
    public void addTheme(Theme theme) {
        EntityManager entityManager = HibernateUtils.getEntityManagerFactory().createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(theme);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public void updateTheme(Theme theme) {
        EntityManager entityManager = HibernateUtils.getEntityManagerFactory().createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.merge(theme);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public Theme getThemeById(int id) {
        Theme theme;
        EntityManager entityManager = HibernateUtils.getEntityManagerFactory().createEntityManager();
        entityManager.getTransaction().begin();
        theme = entityManager.find(Theme.class, id);
        entityManager.getTransaction().commit();
        entityManager.close();
        return theme;
    }

    @Override
    public void deleteTheme(Theme theme) {
        EntityManager entityManager = HibernateUtils.getEntityManagerFactory().createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.remove(entityManager.contains(theme)?theme : entityManager.merge(theme));
        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
