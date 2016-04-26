package ru.kiasystems.logic.spring.beans.dao;

import ru.kiasystems.model.entity.MetricNumber;
import ru.kiasystems.model.entity.Product;

import java.util.List;

/**
 * Created by User on 25.04.2016.
 */
public interface ProductService {
//    List<Product> findAll();
//    List<Product> findAllWithDetail();
    List<Product> findAllByMetricNumberId(Long metricNumberId);
    List<Product> findAllByMetricNumberIdWithDetail(Long metricNumberId);
    Product findById(Long id);
    Product save(Product product);
    void delete(Product product);
    void delete(Long id);
}
