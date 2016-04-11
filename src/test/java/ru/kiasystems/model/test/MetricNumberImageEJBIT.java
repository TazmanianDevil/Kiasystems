package ru.kiasystems.model.test;

import org.junit.Test;
import javax.ejb.embeddable.EJBContainer;
import javax.naming.Context;
import java.util.Arrays;
import java.util.List;
import ru.kiasystems.logic.beans.impl.MetricNumberImageEJB;
import ru.kiasystems.model.entity.MetricNumberImage;

public class MetricNumberImageEJBIT {
    MetricNumberImageEJB mniEJB;
    @Test
    public void testMetricNumberImageEJB() throws Exception {
        try (EJBContainer ejbContainer = EJBContainer.createEJBContainer()) {
            Context ctx = ejbContainer.getContext();
            mniEJB = (MetricNumberImageEJB)ctx.lookup("java:global/ejb-app/classes/MetricNumberImageEJB!ru.kiasystems.logic.beans.impl.MetricNumberImageEJB");
            List<MetricNumberImage> mniList = null;
            mniList = mniEJB.getAllMetricNumberImages();
            System.out.println("<------------------------------------------- MetricNumberImageEJB -------------------------------------->");
            for (MetricNumberImage mni: mniList) {
                System.out.println(Arrays.toString(mni.getImage()));
            }
        }
    }
}
