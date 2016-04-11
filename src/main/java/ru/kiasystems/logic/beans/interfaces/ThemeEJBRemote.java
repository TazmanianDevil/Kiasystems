package ru.kiasystems.logic.beans.interfaces;

import ru.kiasystems.model.entity.Theme;

import java.util.List;

/**
 * Created by User on 15.03.2016.
 */
public interface ThemeEJBRemote {
    String getName();
    List<Theme> getAllThemes();
    void addTheme(Theme theme);
    Theme getThemeById(Long id);
    Theme updateTheme(Theme theme);
    void deleteTheme(Theme theme);
}
