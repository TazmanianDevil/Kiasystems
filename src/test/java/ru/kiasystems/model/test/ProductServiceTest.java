package ru.kiasystems.model.test;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.GenericXmlApplicationContext;
import ru.kiasystems.logic.spring.beans.dao.EmployeeService;
import ru.kiasystems.logic.spring.beans.dao.MetricNumberService;
import ru.kiasystems.logic.spring.beans.dao.ProductService;
import ru.kiasystems.logic.spring.beans.dao.ThemeService;
import ru.kiasystems.model.entity.Employee;
import ru.kiasystems.model.entity.MetricNumber;
import ru.kiasystems.model.entity.Product;
import ru.kiasystems.model.entity.Theme;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by User on 26.04.2016.
 */
public class ProductServiceTest {
    GenericXmlApplicationContext context;
    private ProductService productService;
    private ThemeService themeService;
    private EmployeeService employeeService;
    private MetricNumberService metricNumberService;
    @Before
    public void setUp() {
        context = new GenericXmlApplicationContext("META-INF/Spring/datasource-tx-jpa.xml");
        assertNotNull(context);
        themeService = context.getBean("jpaThemeService", ThemeService.class);
        assertNotNull(themeService);
        employeeService = context.getBean("jpaEmployeeService", EmployeeService.class);
        assertNotNull(employeeService);
        metricNumberService = context.getBean("jpaMetricNumberService", MetricNumberService.class);
        assertNotNull(metricNumberService);
        productService = context.getBean("jpaProductService", ProductService.class);
        assertNotNull(productService);
    }

    @Test
    public void testFindAllByMetricNumberId() {
        System.out.println("<-----------------FIND PRODUCTS WITH METRIC_NUMBER_ID = 8--------------->");
        List<Product> products = productService.findAllByMetricNumberId(8L);
        assertNotNull(products);
        System.out.println(products);
    }

    @Test
    public void testFindAllByMetricNumberIdWithDetail() {
        System.out.println("<------------- FIND PRODUCTS WITH DETAIL AND METRIC NUMBER ID = 8 ---------------->");
        List<Product> products = productService.findAllByMetricNumberIdWithDetail(8L);
        assertNotNull(products);
        for (Product product:
             products) {
            assertNotNull(product);
            System.out.println(product);
            assertNotNull(product.getMetricNumber());
            System.out.println(product.getMetricNumber());
            assertNotNull(product.getTakingEmployee());
            System.out.println(product.getTakingEmployee());
            System.out.println(product.getReturnEmployee());
            assertNotNull(product.getTheme());
            System.out.println(product.getTheme());
        }
    }

    @Test
    public void testFindById() {
        Product product = productService.findById(1L);
        assertNotNull(product);
        System.out.println(product);
        assertNotNull(product.getMetricNumber());
        System.out.println(product.getMetricNumber());
        assertNotNull(product.getTakingEmployee());
        System.out.println(product.getTakingEmployee());
        System.out.println(product.getReturnEmployee());
        assertNotNull(product.getTheme());
        System.out.println(product.getTheme());
    }

    @Test
    public void testSaveUpdateAndDelete() {
        System.out.println("<-------------------- SAVE, UPDATE AND DELETE NEW PRODUCT ---------------->");
        System.out.println(productService.findAllByMetricNumberId(3L));
        Product product = new Product(1, new Date(), new Date(), "Test notes", "Test special notes");
        MetricNumber metricNumber = metricNumberService.findById(3L);
        product.setMetricNumber(metricNumber);
        Employee takingEmployee = employeeService.findById(2L);
        product.setTakingEmployee(takingEmployee);
        Employee returnEmployee = employeeService.findById(2L);
        product.setReturnEmployee(returnEmployee);
        Theme theme = themeService.findById(1L);
        product.setTheme(theme);
        productService.save(product);
        assertNotNull(product.getId());
        System.out.println(productService.findAllByMetricNumberId(3L));
        Product newProduct = productService.findById(product.getId());
        System.out.println(product);
        System.out.println(newProduct);
//        assertEquals(product, newProduct);

        newProduct.setReturnEmployee(employeeService.findById(3L));
        newProduct.setTakingEmployee(employeeService.findById(3L));
        newProduct.setNotes("Test notes 2");
        newProduct.setSpecialNotes("Test special notes 2");
        productService.save(newProduct);
        System.out.println(productService.findAllByMetricNumberId(3L));
        product = productService.findById(newProduct.getId());
        assertEquals(product, newProduct);
        productService.delete(product);
        System.out.println(productService.findAllByMetricNumberId(3L));
    }
}
