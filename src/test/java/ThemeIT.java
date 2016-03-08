import org.hibernate.annotations.SelectBeforeUpdate;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import ru.kiasystems.model.entity.Theme;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class ThemeIT {
    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("HibernateJPATest");

    private EntityManager em;
    private EntityTransaction et;

    @Before
    public void initEntityManager() throws Exception {
        em = emf.createEntityManager();
        et = em.getTransaction();
    }
    @After
    public void closeEntityManager() throws Exception {
        if (em!= null)
            em.close();
    }

    @Test
    public void  shouldFindTheme1() throws Exception {
        Theme theme = em.find(Theme.class, 1000);
        assertEquals("Theme 1", theme.getTitle());
    }

    @Test
    public void shouldCreateTheme4() throws Exception {
        Theme theme = new Theme();
        theme.setTitle("Theme 4");
        et.begin();
        em.persist(theme);
        et.commit();
        assertNotNull("theme_id не может быть пустым", theme.getId());

    }


}
