package ru.kiasystems.model.test;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.GenericXmlApplicationContext;
import ru.kiasystems.logic.spring.beans.dao.MetricNumberService;
import ru.kiasystems.model.entity.MetricNumber;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by User on 25.04.2016.
 */
public class MetricNumberServiceTest {
    private GenericXmlApplicationContext context;
    private MetricNumberService metricNumberService;

    @Before
    public void setUp() {
        context = new GenericXmlApplicationContext("META-INF/Spring/datasource-tx-jpa.xml");
        assertNotNull(context);
        metricNumberService = context.getBean("jpaMetricNumberService", MetricNumberService.class);
        assertNotNull(metricNumberService);
    }

    @Test
    public void testFindAll() {
        System.out.println("<----------------- TEST FIND ALL METRIC NUMBERS ----------------->");
        List<MetricNumber> numbers = metricNumberService.findAll();
        assertNotNull(numbers);
        System.out.println("numbers = " + numbers);
    }

    @Test
    public void testFindAllWithDetail() {
        System.out.println("<------------- TEST FIND ALL WITH DETAIL ------------>");
        List<MetricNumber> numbers = metricNumberService.findAllWithDetail();
        assertNotNull(numbers);
        for (MetricNumber number :
                numbers) {
            System.out.println(number);
            assertNotNull(number.getProducts());
            System.out.println(number.getProducts());
            System.out.println(number.getImage());
        }
    }

    @Test
    public void testFindById(){
        System.out.println("<------------FIND MetricNumber with id 1 ----------->");
        MetricNumber number = metricNumberService.findById(1L);
        assertNotNull(number);
        assertEquals(new Long(1L), number.getId());
        System.out.println(number);
        assertNotNull(number.getProducts());
        System.out.println(number.getProducts());
    }

    @Test
    public void testFindByName() {
        System.out.println("<-----------FIND METRIC NUMBER WITH NAME КМНШ.203349");
        MetricNumber number = metricNumberService.findByName("КМНШ.203349");
        assertNotNull(number);
        assertEquals(number.getTitle(), "Устройства контроля, стабилизации, управления, регулирования, настройки совмещения, фиксирования, слежения и т.п.");
        System.out.println(number);
    }

    @Test
    public void testFindByTitle() {
        System.out.println("<----------- FIND METRIC NUMBER WITH TITLE Устройства контроля, стабилизации, управления, регулирования, настройки совмещения, фиксирования, слежения и т.п.");
        MetricNumber number = metricNumberService.findByTitle("Устройства контроля, стабилизации, управления, регулирования, настройки совмещения, фиксирования, слежения и т.п.");
        assertNotNull(number);
        assertEquals("КМНШ.203349", number.getName());
        System.out.println(number);
    }

    @Test
    public void testFindByTitleSimilarTo() {
        System.out.println("<--------- FIND METRIC NUMBERS WITH TITLES SIMILAR TO УСТРОЙСТВА");
        List<MetricNumber> numbers = metricNumberService.findByTitleSimilarTo("%Устройства%");
        assertNotNull(numbers);
        System.out.println(numbers);
    }

    @Test
    public void testSaveUpdateAndDelete() {
        System.out.println("<----------- SAVE, UPDATE AND DELETE TEST NUMBER");
        System.out.println(metricNumberService.findAll());
        MetricNumber number = new MetricNumber("Test.999999", "Test name", "Test description");
        metricNumberService.save(number);
        assertNotNull(number.getId());
        System.out.println(metricNumberService.findAll());
        MetricNumber newNumber = metricNumberService.findById(number.getId());
        assertEquals(number, newNumber);
        newNumber.setTitle("Test name 2");
        newNumber.setDescription("Test description 2");
        metricNumberService.save(newNumber);
        number = metricNumberService.findById(newNumber.getId());
        assertEquals(number, newNumber);
        System.out.println(metricNumberService.findAll());
        metricNumberService.delete(number);
        System.out.println(metricNumberService.findAll());


    }

}
