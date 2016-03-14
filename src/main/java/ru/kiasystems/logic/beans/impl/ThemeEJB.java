package ru.kiasystems.logic.beans.impl;

import ru.kiasystems.logic.beans.interfaces.ThemeEJBRemote;
import ru.kiasystems.model.entity.Theme;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Stateless
@LocalBean
public class ThemeEJB implements ThemeEJBRemote{
    @PersistenceContext
    private EntityManager entityManager;
    public List<Theme> getAllThemes() {
        List<Theme> themes =null;
        if (entityManager!=null) {
            TypedQuery<Theme> namedQuery = entityManager.createNamedQuery("Theme.getAllThemes", Theme.class);
            themes = namedQuery.getResultList();
        }
        return themes;
    }

    public String getName() {
        return "ThemeBean";
    }

    public void addTheme(Theme theme) {
        entityManager.persist(theme);
    }

    public Theme getThemeById(int id) {
        Theme theme = null;
        theme = entityManager.find(Theme.class, id);
        return theme;
    }

    public Theme updateTheme(Theme theme) {
        theme = entityManager.merge(theme);
        return theme;
    }

    public void deleteTheme(Theme theme) {
        entityManager.remove(entityManager.contains(theme)?theme:entityManager.merge(theme));
    }
}
