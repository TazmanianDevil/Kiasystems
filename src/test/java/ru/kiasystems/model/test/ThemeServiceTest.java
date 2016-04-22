package ru.kiasystems.model.test;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.kiasystems.logic.spring.beans.dao.ThemeService;
import ru.kiasystems.model.entity.Theme;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class ThemeServiceTest {

    ClassPathXmlApplicationContext context;
    ThemeService themeService;
    @Before
   public  void setUp() {
        context = new ClassPathXmlApplicationContext("META-INF/Spring/app-context.xml");
        assertNotNull("Context cannot be null");
        themeService = context.getBean("jpaThemeService", ThemeService.class);
        assertNotNull("ThemeService cannot be null");
    }

    @Test
    public void testFindAll() {
        List<Theme> themes = themeService.findAll();
        assertNotNull("Theme's list cannot be null", themes);
        System.out.println(themes);
    }

    @Test
    public void testFindById() {
        Theme theme = themeService.findById(1L);
        assertNotNull("Theme cannot be null");
        System.out.println(theme);
    }

    @Test
    public void testSaveAndDelete() {
        Theme theme = new Theme("Test theme", new java.util.Date());
        themeService.save(theme);
        assertNotNull("Persisted id cannot be null", theme.getId());
        System.out.println(theme);
        theme.setTitle("Test theme 2");
        themeService.save(theme);
        Theme newTheme = themeService.findById(theme.getId());
        assertEquals("Titles must be equal for new and persisted themes", theme.getTitle(), newTheme.getTitle());
        System.out.println(newTheme);
        themeService.delete(newTheme);
        System.out.println(themeService.findAll());
    }

    @Test
    public void testFindByTitle() {
        Theme theme = themeService.findByTitle("Ступень");
        assertNotNull("Ступень theme annot be null", theme);
        System.out.println(theme);
    }
}
