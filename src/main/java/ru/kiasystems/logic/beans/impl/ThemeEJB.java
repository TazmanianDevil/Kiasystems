package ru.kiasystems.logic.beans.impl;

import ru.kiasystems.logic.beans.interfaces.ThemeEJBRemote;
import ru.kiasystems.model.entity.Theme;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Stateless
@LocalBean
public class ThemeEJB implements ThemeEJBRemote {
    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public List<Theme> getAllThemes() {
        List<Theme> themes =null;
        if (entityManager!=null) {
            TypedQuery<Theme> namedQuery = entityManager.createNamedQuery("Theme.getAllThemes", Theme.class);
            themes = namedQuery.getResultList();
        }
        return themes;
    }
    @Override
    public String getName() {
        return this.getClass().getName();
    }
    @Override
    public void addTheme(Theme theme) {
        entityManager.persist(theme);
    }
    @Override
    public Theme getThemeById(Long id) {
        return entityManager.find(Theme.class, id);
    }
    @Override
    public Theme updateTheme(Theme theme) {
        theme = entityManager.merge(theme);
        return theme;
    }
    @Override
    public void deleteTheme(Theme theme) {
        entityManager.remove(entityManager.contains(theme)?theme:entityManager.merge(theme));
    }
}
