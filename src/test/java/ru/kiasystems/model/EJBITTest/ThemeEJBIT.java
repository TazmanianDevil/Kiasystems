package ru.kiasystems.model.EJBITTest;

import org.hibernate.annotations.SourceType;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import ru.kiasystems.logic.beans.impl.ThemeEJB;
import ru.kiasystems.model.entity.Theme;

import javax.ejb.embeddable.EJBContainer;
import javax.naming.Context;
import java.io.File;
import java.util.*;


public class ThemeEJBIT {
    ThemeEJB themeEJB;
    @Test
    public void shouldCreate() throws Exception {
        try (EJBContainer ec = EJBContainer.createEJBContainer()) {
            Context ctx = ec.getContext();
            ThemeEJB themeEJB = (ThemeEJB)ctx.lookup("java:global/ejb-app/classes/ThemeEJB!ru.kiasystems.logic.beans.impl.ThemeEJB");
            List<Theme> themes = themeEJB.getAllThemes();
            assertNotNull("Theme list cannot be null for test DB", themes);
            Theme theme = new Theme();
            theme.setTitle("Test Theme");
            theme.setStartDate(new Date());
            themeEJB.addTheme(theme);
            //Persist theme to the database
            assertNotNull("Id can not be null", theme.getId());
            // Check all themes and sure there is an extra one
            assertEquals(themes.size()+1, themeEJB.getAllThemes().size());
            Theme theme1 = themeEJB.getThemeById(theme.getId());
            assertNotNull("Received theme not null", theme1);
            themeEJB.deleteTheme(theme);
            assertEquals(themes.size(), themeEJB.getAllThemes().size());
        }
    }
}
