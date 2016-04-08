package ru.kiasystems.logic.beans.interfaces;

import java.util.List;
import ru.kiasystems.model.entity.MetricNumber;

public interface MetricNumberEJBRemote {
    String getName();
    List<MetricNumber> getAllMetricNumbers();
    void addMetricNumber(MetricNumber MetricNumber);
    MetricNumber getMetricNumberById(Long id);
    MetricNumber updateMetricNumber(MetricNumber MetricNumber);
    void deleteMetricNumber(MetricNumber MetricNumber);
}
