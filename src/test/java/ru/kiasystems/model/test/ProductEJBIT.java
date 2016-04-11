package ru.kiasystems.model.test;

import org.junit.Test;
import ru.kiasystems.logic.beans.impl.*;
import ru.kiasystems.model.entity.*;

import javax.ejb.embeddable.EJBContainer;
import javax.naming.Context;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import java.util.Date;
public class ProductEJBIT {
    ProductEJB productEJB;
    MetricNumberEJB mnEJB;
    EmployeeEJB employeeEJB;
    ThemeEJB themeEJB;
    @Test
    public void shouldCreate() throws Exception {
        try (EJBContainer ec = EJBContainer.createEJBContainer()) {
            Context ctx = ec.getContext();
            ProductEJB productEJB = (ProductEJB)ctx.lookup("java:global/ejb-app/classes/ProductEJB!ru.kiasystems.logic.beans.impl.ProductEJB");
            mnEJB = (MetricNumberEJB)ctx.lookup("java:global/ejb-app/classes/MetricNumberEJB!ru.kiasystems.logic.beans.impl.MetricNumberEJB");
            EmployeeEJB employeeEJB = (EmployeeEJB)ctx.lookup("java:global/ejb-app/classes/EmployeeEJB!ru.kiasystems.logic.beans.impl.EmployeeEJB");
            ThemeEJB themeEJB = (ThemeEJB)ctx.lookup("java:global/ejb-app/classes/ThemeEJB!ru.kiasystems.logic.beans.impl.ThemeEJB");
            List<Product> products = null;
            products = productEJB.getAllProducts();
            System.out.println("<----------------------------------- ProductEJBIT ------------------------------->");
            System.out.println(products);
            assertNotNull("Product list cannot be null for test DB", products);
            Product p = new Product();
            MetricNumber mn = mnEJB.getMetricNumberById(new Long(17));
            p.setMetricNumber(mn);
            p.setIndex(002);
            Employee emp = employeeEJB.getEmployeeById(new Long(6));
            p.setReturnEmployee(emp);
            p.setTakingEmployee(emp);
            p.setTakingDate(new Date());
            p.setReturnDate(new Date());
            Theme theme = themeEJB.getThemeById(new Long(3));
            p.setTheme(theme);
            p.setNote("Note for test product");
            p.setSpecialNotes("Special note for test product");
            productEJB.addProduct(p);
            //Persist product to the database
            assertNotNull("Id can not be null", p.getId());
//             Check all products and sure there is an extra one
            assertEquals(products.size()+1, productEJB.getAllProducts().size());
            productEJB.deleteProduct(p);
            assertEquals(products.size(), productEJB.getAllProducts().size());
        }
    }
}
