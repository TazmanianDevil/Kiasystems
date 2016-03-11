package ru.kiasystems.model.test;

import junit.framework.TestCase;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.testng.annotations.Test;
import ru.kiasystems.logic.beans.ThemeBean;
import ru.kiasystems.model.DAO.ThemeDAO;
import ru.kiasystems.model.DAO.Impl.Hibernate.ThemeDAOImpl;
import ru.kiasystems.model.entity.Theme;

import javax.ejb.embeddable.EJBContainer;
import javax.naming.Context;
import javax.naming.InitialContext;
import java.util.Collection;
import java.util.Date;
import java.util.Hashtable;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertNotNull;
import static org.testng.AssertJUnit.assertTrue;
public class ThemeBeanTest extends TestCase{
    private static EJBContainer ejbContainer;
    private static Context context;
    private static ThemeBean themeBean;
    @Override
    protected void setUp() throws Exception {
        ejbContainer = EJBContainer.createEJBContainer();
        context = ejbContainer.getContext();
        themeBean = (ThemeBean)context.lookup("java:global/classes/ThemeBean");
    }

    @Override
    protected void tearDown() throws Exception {
        ejbContainer.close();
    }


    public void testBasicUsage() {
        assertNotNull(themeBean);
        String expected = "ThemeBean";
        String theme = themeBean.getName();
        assertNotNull(theme);
        assertEquals(expected, theme);
    }
}
