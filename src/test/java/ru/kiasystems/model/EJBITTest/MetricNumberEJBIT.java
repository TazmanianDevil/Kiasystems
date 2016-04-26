package ru.kiasystems.model.EJBITTest;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import javax.ejb.embeddable.EJBContainer;
import javax.naming.Context;
import java.util.List;
import ru.kiasystems.logic.beans.impl.MetricNumberEJB;
import ru.kiasystems.model.entity.MetricNumber;

public class MetricNumberEJBIT {
/*    MetricNumberEJB mnEJB;
    @Test
    public void testMetricNumberEJB() throws Exception {
        try (EJBContainer ejbContainer = EJBContainer.createEJBContainer()) {
            Context ctx = ejbContainer.getContext();
            mnEJB = (MetricNumberEJB)ctx.lookup("java:global/ejb-app/classes/MetricNumberEJB!ru.kiasystems.logic.beans.impl.MetricNumberEJB");
            System.out.println("<------------------------------------- MetricNumberEJB ------------------------------->");
            List<MetricNumber> metricNumbers = mnEJB.getAllMetricNumbers();
            System.out.println(metricNumbers);
            for(MetricNumber mn: metricNumbers)
                System.out.println(mn.getImage());
            assertNotNull("List must be not null", metricNumbers);
            MetricNumber mn = new MetricNumber();
            mn.setName("KMNS.888888");
            mn.setDescription("Test record");
            mn.setTitle("Test record");
            mnEJB.addMetricNumber(mn);
            assertNotNull("Persisted id cannot be null", mn.getId());
            assertEquals(metricNumbers.size() + 1, mnEJB.getAllMetricNumbers().size());
            MetricNumber mn2 = mnEJB.getMetricNumberById(mn.getId());
            assertEquals(mn, mn2);
            mnEJB.deleteMetricNumber(mn2);
            assertEquals(metricNumbers.size(), mnEJB.getAllMetricNumbers().size());
        }
    }*/
}
