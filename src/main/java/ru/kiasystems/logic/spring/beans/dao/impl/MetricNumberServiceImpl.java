package ru.kiasystems.logic.spring.beans.dao.impl;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.kiasystems.logic.spring.beans.dao.MetricNumberService;
import ru.kiasystems.model.entity.MetricNumber;
import ru.kiasystems.model.entity.MetricNumber_;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.*;
import java.util.List;

/**
 * Created by User on 25.04.2016.
 */
@Service("jpaMetricNumberService")
@Repository
@Transactional
public class MetricNumberServiceImpl implements MetricNumberService {
    @PersistenceContext
    private EntityManager em;
    @Override
    public List<MetricNumber> findAll() {
        return em.createNamedQuery("MetricNumber.findAll", MetricNumber.class).getResultList();
    }

    @Override
    public List<MetricNumber> findAllWithDetail() {
        return em.createNamedQuery("MetricNumber.findAllWithDetail", MetricNumber.class).getResultList();
    }

    @Override
    public MetricNumber findByName(String name) {
        return em.createNamedQuery("MetricNumber.findByName", MetricNumber.class).setParameter("name", name).getSingleResult();
    }

    @Override
    public MetricNumber findByTitle(String title) {
        return em.createNamedQuery("MetricNumber.findByTitle", MetricNumber.class).setParameter("title", title).getSingleResult();
    }

    @Override
    public List<MetricNumber> findByTitleSimilarTo(String title) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<MetricNumber> criteriaQuery = cb.createQuery(MetricNumber.class);
        Root<MetricNumber> mnRoot = criteriaQuery.from(MetricNumber.class);
        criteriaQuery.select(mnRoot);
        Predicate criteria = cb.conjunction();
        Expression<String> literal = cb.upper(cb.literal((String) title));
        Predicate p = cb.like(cb.upper(mnRoot.get(MetricNumber_.title)), literal);
        criteria = cb.and(criteria, p);
        criteriaQuery.where(criteria);
        return em.createQuery(criteriaQuery).getResultList();
    }

    @Override
    public MetricNumber findById(Long id) {
        return em.createNamedQuery("MetricNumber.findById", MetricNumber.class).setParameter("id", id).getSingleResult();
    }

    @Override
    public MetricNumber save(MetricNumber metricNumber) {
        if (metricNumber.getId() == null) {
            em.persist(metricNumber);
        } else {
            em.merge(metricNumber);
        }
        return metricNumber;
    }

    @Override
    public void delete(MetricNumber metricNumber) {
        em.remove(em.contains(metricNumber)?metricNumber:em.merge(metricNumber));
    }

    @Override
    public void delete(Long id) {
        delete(findById(id));
    }
}
