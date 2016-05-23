package ru.kiasystems.logic.spring.beans.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.kiasystems.logic.spring.beans.dao.ThemeService;
import ru.kiasystems.model.entity.Theme;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by User on 20.04.2016.
 */
@Service("jpaThemeService")
@Transactional
@Scope(proxyMode = ScopedProxyMode.INTERFACES)
@Repository
public class ThemeServiceImpl implements ThemeService {
    @PersistenceContext
    private EntityManager em;
    @Override
    @Transactional(readOnly = true)
    public List<Theme> findAll() {
        return em.createNamedQuery("Theme.findAll", Theme.class).getResultList();
    }

    @Override
    @Transactional(readOnly = true)
    public Theme findById(Long id) {
        return em.createNamedQuery("Theme.findById", Theme.class).setParameter("id", id).getSingleResult();

    }

    @Override
    public Theme findByTitle(String title) {
        return em.createNamedQuery("Theme.findByTitle", Theme.class).setParameter("title", title).getSingleResult();
    }

    @Override
    public Theme save(Theme theme) {
        if (theme.getId() == null) {
            em.persist(theme);
        } else
            em.merge(theme);
        return theme;
    }

    @Override
    public void delete(Theme theme) {
        em.remove(em.contains(theme)?theme:em.merge(theme));
    }

    @Override
    public void delete(Long id) {
        delete(findById(id));
    }
}
