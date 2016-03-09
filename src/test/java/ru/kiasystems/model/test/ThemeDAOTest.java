package ru.kiasystems.model.test;

import junit.framework.TestCase;
import ru.kiasystems.model.DAO.ThemeDAO;
import ru.kiasystems.model.DAO.Impl.Hibernate.ThemeDAOImpl;
import ru.kiasystems.model.entity.Theme;

import java.util.Collection;
import java.util.Date;

public class ThemeDAOTest extends TestCase {
    private ThemeDAO dao;
    @Override
    protected void setUp() throws Exception {
        dao = new ThemeDAOImpl();
    }

    @Override
    protected void tearDown() throws Exception {

    }

    public void testBasicUsage() {
        Theme t1 = new Theme();
        t1.setTitle("Theme 1");
        t1.setStartDate(new Date());
        dao.addTheme(t1);
        assertNotNull("id не может быть пустым", t1.getId());
        System.out.println(t1);
        Theme t2 = new Theme();
        t2.setTitle("Theme 2");
        t2.setStartDate(new Date());
        t2.setCloseDate(new Date());
        dao.addTheme(t2);
        assertNotNull("id не может быть пустым", t2.getId());
        Collection<Theme> themes = dao.getAllThemes();
        System.out.print(themes);
        assertEquals(2, themes.size());
    }
}
