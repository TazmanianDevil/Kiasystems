package ru.kiasystems.logic.beans;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.PersistenceContext;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import ru.kiasystems.model.entity.Theme;
import java.util.List;
@Stateless
@Local
public class ThemeBean {
    @PersistenceContext
    private EntityManager entityManager;
    public ThemeBean() {
    }

    public List<Theme> getAllThemes() {
      //  entityManager.getTransaction().begin();
        List<Theme> themes =null;
        if (entityManager!=null) {
            TypedQuery<Theme> namedQuery = entityManager.createNamedQuery("Theme.getAllThemes", Theme.class);
            themes = namedQuery.getResultList();
        }
        //entityManager.getTransaction().commit();
        return themes;
    }

    public String getName() {
        return "Tra-ta-ta: " + entityManager;
    }
    public void addTheme(Theme theme) {
      //  entityManager.getTransaction().begin();
        entityManager.persist(theme);
      //  entityManager.getTransaction().commit();
    }

    public Theme getThemeById(int id) {
        Theme theme = null;
        //entityManager.getTransaction().begin();
        theme = entityManager.find(Theme.class, id);
        //entityManager.getTransaction().commit();
        return theme;
    }

    public Theme updateTheme(Theme theme) {
     //   entityManager.getTransaction().begin();
        theme = entityManager.merge(theme);
     //   entityManager.getTransaction().commit();
        return theme;
    }

    public void deleteTheme(Theme theme) {
      //  entityManager.getTransaction().begin();
        entityManager.remove(entityManager.contains(theme)?theme:entityManager.merge(theme));
       // entityManager.getTransaction().commit();
    }
}
