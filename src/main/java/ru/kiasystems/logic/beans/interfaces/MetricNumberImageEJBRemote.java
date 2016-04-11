package ru.kiasystems.logic.beans.interfaces;

import ru.kiasystems.model.entity.MetricNumberImage;

import java.util.List;

public interface MetricNumberImageEJBRemote {
    String getName();
    List<MetricNumberImage> getAllMetricNumberImages();
    void addMetricNumberImage(MetricNumberImage metricNumberImage);
    MetricNumberImage getMetricNumberImageById(Long id);
    MetricNumberImage updateMetricNumberImage(MetricNumberImage metricNumberImage);
    void deleteMetricNumberImage(MetricNumberImage metricNumberImage);
}
