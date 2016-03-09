package ru.kiasystems.model.DAO.Impl.Hibernate;

import ru.kiasystems.model.entity.Theme;
import ru.kiasystems.model.DAO.ThemeDAO;
import java.util.Collection;
import ru.kiasystems.model.utils.HibernateUtils;
import javax.persistence.EntityManager;

public class ThemeDAOImpl implements ThemeDAO {
    @Override
    public Collection getAllThemes() {
        EntityManager entityManager = HibernateUtils.getEntitytManagerFactory().createEntityManager();
        entityManager.getTransaction().begin();
        Collection<Theme> themes = entityManager.createQuery( "from Theme", Theme.class).getResultList();

        entityManager.getTransaction().commit();
        entityManager.close();
        return themes;
    }

    @Override
    public void addTheme(Theme theme) {

    }

    @Override
    public void updateTheme(Theme theme) {

    }

    @Override
    public Theme getThemeById(int id) {
        return null;
    }

    @Override
    public void deleteTheme() {

    }
}
