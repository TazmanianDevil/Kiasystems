package ru.kiasystems.model.rest_test;

import org.apache.commons.codec.binary.Base64;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestTemplate;
import ru.kiasystems.model.entity.Theme;
import ru.kiasystems.model.restful.entities.Themes;

import java.util.Date;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

public class ThemeRestServiceTest {
    private static final String URL_GET_ALL_THEMES =
            "http://localhost:8080/Kiasystems/restful/theme/listdata";
    private static final String URL_GET_THEME_BY_ID =
            "http://localhost:8080/Kiasystems/restful/theme/{id}";
    private static final String URL_CREATE_THEME =
            "http://localhost:8080/Kiasystems/restful/theme/";
    private static final String URL_UPDATE_THEME =
            "http://localhost:8080/Kiasystems/restful/theme/{id}";
    private static final String URL_DELETE_THEME =
            "http://localhost:8080/Kiasystems/restful/theme/{id}";
    private GenericXmlApplicationContext context;
    private RestTemplate restTemplate;
    private HttpEntity<String> request;
    private String url="http://localhost:8080/Kiasystems/restful/theme/listdata";
  /*  @Before
    public void setUp() {
        context = new GenericXmlApplicationContext("classpath:META-INF/rest-client-app-context.xml");
        restTemplate = context.getBean("restTemplate", RestTemplate.class);

        String plainCreds = "user:user";
        byte[] plainCredsBytes = plainCreds.getBytes();
        byte[] base64CredsBytes = Base64.encodeBase64(plainCredsBytes);
        String base64Creds = new String(base64CredsBytes);

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Authorization", "Basic " + base64Creds);
        request = new HttpEntity<String>(httpHeaders);
    }

    @Test
    public void testThemeListData() {
        System.out.println("<----------GET ALL THEMES ------------>");
        Themes themes = restTemplate.getForObject(URL_GET_ALL_THEMES, Themes.class);
//        Themes themes = restTemplate.exchange(URL_GET_ALL_THEMES, HttpMethod.GET, request, Themes.class).getBody();
        assertNotNull(themes);
        System.out.println(themes);
    }

    @Test
    public void testThemeFindById() {
        System.out.println("<-------------- GET THEME WITH ID 1 ------------>");
        Theme theme = restTemplate.getForObject(URL_GET_THEME_BY_ID, Theme.class, 1L);
        assertNotNull(theme);
        System.out.println(theme);
    }

    @Test
    public void testSaveUpdateAndDelete() {
        System.out.println("<---------------INSERT, UPDATE AND DELETE NEW THEME --------->");
        Theme theme = new Theme("Test theme", new Date(), new Date());
        theme = restTemplate.postForObject(URL_CREATE_THEME, theme, Theme.class);
        assertNotNull(theme.getId());
        System.out.println("Theme was successfully posted: " + theme);
        Theme newTheme = restTemplate.getForObject(URL_GET_THEME_BY_ID, Theme.class, theme.getId());
        assertEquals(newTheme.getId(), theme.getId());
        assertEquals(newTheme.getTitle(), theme.getTitle());
        newTheme.setTitle("New test theme");
        restTemplate.put(URL_UPDATE_THEME, newTheme, newTheme.getId());
        Themes themes = restTemplate.getForObject(URL_GET_ALL_THEMES, Themes.class);
        System.out.println(themes);
        restTemplate.delete(URL_DELETE_THEME, theme.getId());
        System.out.println(themes = restTemplate.getForObject(URL_GET_ALL_THEMES, Themes.class));
    }

    @Test(expected = org.springframework.web.client.HttpServerErrorException.class)
    public void testFindNonexistentTheme() {
        System.out.println("<-------------FIND THEME WITH ID 99999-------------------->");
        Theme theme = restTemplate.getForObject(URL_GET_THEME_BY_ID, Theme.class, 99999);
    }*/
}
