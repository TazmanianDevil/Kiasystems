package ru.kiasystems.model.test;

import org.junit.Before;
import org.junit.Test;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.ui.ExtendedModelMap;
import ru.kiasystems.controller.spring.restful.ThemeController;
import ru.kiasystems.logic.spring.beans.dao.ThemeService;
import ru.kiasystems.model.entity.Theme;
import ru.kiasystems.model.restful.entities.Themes;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ThemeControllerTest {
    private final List<Theme> themes = new ArrayList<>();
    @Before
    public void initThemes() {
        Theme theme = new Theme("Test theme 1", new Date(), new Date());
        themes.add(theme);
        theme = new Theme("Test theme 2", new Date(), new Date());
        themes.add(theme);
    }

    @Test
    public void testListData() throws Exception{
        ThemeService themeService = mock(ThemeService.class);
        when(themeService.findAll()).thenReturn(themes);
        ThemeController themeController = new ThemeController();
        ReflectionTestUtils.setField(themeController, "themeService", themeService);
        ExtendedModelMap uiModel = new ExtendedModelMap();
        uiModel.addAttribute("themes", themeController.listData());
        Themes modelThemes = (Themes)uiModel.get("themes");
        assertEquals(2, modelThemes.getThemes().size());
    }

    @Test
    public void testCreate() {
        final Theme newTheme = new Theme("Test theme 1", new Date(), new Date());
        ThemeService themeService = mock(ThemeService.class);
        when(themeService.save(newTheme)).thenAnswer(new Answer<Theme>() {
            @Override
            public Theme answer(InvocationOnMock invocationOnMock) throws Throwable {
                themes.add(newTheme);
                return newTheme;
            }
        });
        ThemeController themeController = new ThemeController();
        ReflectionTestUtils.setField(themeController, "themeService", themeService);
        Theme theme = themeController.create(newTheme);
        assertEquals(3, themes.size());
    }
}
