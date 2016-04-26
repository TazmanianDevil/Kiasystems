package ru.kiasystems.logic.spring.beans.dao;

import ru.kiasystems.model.entity.MetricNumber;

import java.util.List;

/**
 * Created by User on 25.04.2016.
 */
public interface MetricNumberService {
    List<MetricNumber> findAll();
    List<MetricNumber> findAllWithDetail();
    MetricNumber findByName(String name);
    MetricNumber findByTitle(String title);
    List<MetricNumber> findByTitleSimilarTo(String title);
    MetricNumber findById(Long id);
    MetricNumber save(MetricNumber metricNumber);
    void delete(MetricNumber metricNumber);
    void delete(Long id);
}
