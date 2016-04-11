package ru.kiasystems.logic.beans.impl;

import ru.kiasystems.logic.beans.interfaces.MetricNumberEJBRemote;
import ru.kiasystems.model.entity.MetricNumber;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.PersistenceContext;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

@Stateless
@LocalBean
public class MetricNumberEJB implements MetricNumberEJBRemote {
    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public String getName() {
        return getClass().getName();
    }

    @Override
    public List<MetricNumber> getAllMetricNumbers() {
        TypedQuery<MetricNumber> query = entityManager.createNamedQuery("MetricNumber.getAllMetricNumbers", MetricNumber.class);
        return query.getResultList();
    }

    @Override
    public void addMetricNumber(MetricNumber metricNumber) {
        entityManager.persist(metricNumber);
    }

    @Override
    public MetricNumber getMetricNumberById(Long id) {
        return entityManager.find(MetricNumber.class, id);
    }

    @Override
    public MetricNumber updateMetricNumber(MetricNumber metricNumber) {
        return entityManager.merge(metricNumber);
    }

    @Override
    public void deleteMetricNumber(MetricNumber metricNumber) {
        entityManager.remove(entityManager.contains(metricNumber)?metricNumber: entityManager.merge(metricNumber));
    }
}
