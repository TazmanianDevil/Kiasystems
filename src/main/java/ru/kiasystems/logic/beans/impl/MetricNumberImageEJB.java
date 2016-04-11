package ru.kiasystems.logic.beans.impl;

import ru.kiasystems.logic.beans.interfaces.MetricNumberImageEJBRemote;
import ru.kiasystems.model.entity.MetricNumberImage;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Stateless
@LocalBean
public class MetricNumberImageEJB implements MetricNumberImageEJBRemote {
    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public String getName() {
        return getClass().getName();
    }

    @Override
    public List<MetricNumberImage> getAllMetricNumberImages() {
        TypedQuery<MetricNumberImage> query = entityManager.createNamedQuery("MetricNumberImage.getAllMetricNumberImages", MetricNumberImage.class);
        return query.getResultList();
    }

    @Override
    public void addMetricNumberImage(MetricNumberImage metricNumberImage) {
        entityManager.persist(metricNumberImage);
    }

    @Override
    public MetricNumberImage getMetricNumberImageById(Long id) {
        return entityManager.find(MetricNumberImage.class, id);
    }

    @Override
    public MetricNumberImage updateMetricNumberImage(MetricNumberImage metricNumberImage) {
        return entityManager.merge(metricNumberImage);
    }

    @Override
    public void deleteMetricNumberImage(MetricNumberImage metricNumberImage) {
        entityManager.remove(entityManager.contains(metricNumberImage)?metricNumberImage: entityManager.merge(metricNumberImage));
    }
}
