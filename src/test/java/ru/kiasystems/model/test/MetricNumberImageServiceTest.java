package ru.kiasystems.model.test;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.data.geo.Metric;
import ru.kiasystems.logic.spring.beans.dao.MetricNumberImageService;
import ru.kiasystems.model.entity.MetricNumber;
import ru.kiasystems.model.entity.MetricNumberImage;

import java.util.List;

import static org.junit.Assert.assertNotNull;

/**
 * Created by User on 25.04.2016.
 */
public class MetricNumberImageServiceTest {
    private GenericXmlApplicationContext context;
    private MetricNumberImageService metricNumberImageService;

    @Before
    public void setUp() {
        context = new GenericXmlApplicationContext("META-INF/Spring/app-context.xml");
        metricNumberImageService = context.getBean("jpaMetricNumberImageService", MetricNumberImageService.class);
        MetricNumberImage mni = new MetricNumberImage(1L, new byte[] {1,2,3,4});
        metricNumberImageService.save(mni);
        MetricNumberImage mni2 = new MetricNumberImage(3L, new byte[] {5,6,7,8});
        metricNumberImageService.save(mni2);
    }

    @Test
    public void testFindAll() {
        System.out.println("<------------- FIND ALL IMAGES ------------->");
        List<MetricNumberImage>  images = metricNumberImageService.findAll();
        assertNotNull(images);
        System.out.println(images);
    }

    @Test
    public void testfindById() {
        MetricNumberImage metricNumberImage = metricNumberImageService.findById(1L);
        assertNotNull(metricNumberImage);
        System.out.println(metricNumberImage);
        System.out.println(metricNumberImage.getImage());
    }

    @Test
    public void testSaveUpdateAndDelete() {
        System.out.println("<----------------UPDATE AND DELETE IMAGE WITH ID 1----------------> ");
        System.out.println(metricNumberImageService.findAll());
        MetricNumberImage image = metricNumberImageService.findById(1L);
        assertNotNull(image);
        image.setImage(new byte[]{10,11,12,13,14});
        metricNumberImageService.save(image);
        System.out.println(metricNumberImageService.findAll());

        metricNumberImageService.delete(image);
        System.out.println(metricNumberImageService.findAll());
    }
}
