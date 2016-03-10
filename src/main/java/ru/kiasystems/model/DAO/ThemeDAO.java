package ru.kiasystems.model.DAO;

import ru.kiasystems.model.entity.Theme;
import java.util.Collection;

public interface ThemeDAO {
    Collection getAllThemes();
    void addTheme(Theme theme);
    void updateTheme(Theme theme);
    Theme getThemeById(int id);
    void deleteTheme(Theme theme);


}
