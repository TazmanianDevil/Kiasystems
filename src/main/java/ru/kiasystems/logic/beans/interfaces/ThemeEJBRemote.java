package ru.kiasystems.logic.beans.interfaces;

import javax.ejb.Local;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.PersistenceContext;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import ru.kiasystems.model.entity.Theme;
import java.util.List;
@Remote
public interface ThemeEJBRemote {
    String getName();
    List<Theme> getAllThemes();
    Theme getThemeById(int id);
    Theme updateTheme(Theme theme);
    void deleteTheme(Theme theme);
}
