package ru.kiasystems.logic.spring.beans.dao;

import ru.kiasystems.model.entity.MetricNumber;
import ru.kiasystems.model.entity.MetricNumberImage;

import java.util.List;

/**
 * Created by User on 25.04.2016.
 */
public interface MetricNumberImageService {
    List<MetricNumberImage> findAll();
    MetricNumberImage findById(Long id);
    MetricNumberImage save(MetricNumberImage metricNumberImage);
    void delete(MetricNumberImage metricNumberImage);
    void delete(Long id);
}
