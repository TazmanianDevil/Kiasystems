package ru.kiasystems.logic.spring.beans.dao.impl;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.kiasystems.logic.spring.beans.dao.MetricNumberImageService;
import ru.kiasystems.model.entity.MetricNumber;
import ru.kiasystems.model.entity.MetricNumberImage;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by User on 25.04.2016.
 */
@Service("jpaMetricNumberImageService")
@Repository
@Transactional
public class MetricNumberImageServiceImpl implements MetricNumberImageService {
    @PersistenceContext
    private EntityManager em;

    @Override
    public List<MetricNumberImage> findAll() {
        return em.createNamedQuery("MetricNumberImage.findAll", MetricNumberImage.class).getResultList();
    }

    @Override
    public MetricNumberImage findById(Long id) {
        MetricNumberImage metricNumberImage = em.createNamedQuery("MetricNumberImage.findById", MetricNumberImage.class).setParameter("id", id).getSingleResult();
        metricNumberImage.getImage();
        return metricNumberImage;
    }

    @Override
    public MetricNumberImage save(MetricNumberImage metricNumberImage) {
        if (metricNumberImage.getId() == null) {
            em.persist(metricNumberImage);
        } else {
            em.merge(metricNumberImage);
        }
        return metricNumberImage;
    }

    @Override
    public void delete(MetricNumberImage metricNumberImage) {
        em.remove(em.contains(metricNumberImage)?metricNumberImage:em.merge(metricNumberImage));
    }

    @Override
    public void delete(Long id) {
        delete(findById(id));
    }
}
