package ru.kiasystems.logic.spring.beans.dao.impl;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.kiasystems.logic.spring.beans.dao.ProductService;
import ru.kiasystems.model.entity.Product;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by User on 26.04.2016.
 */
@Service("jpaProductService")
@Repository
@Transactional
public class ProductServiceImpl implements ProductService {
    @PersistenceContext
    private EntityManager em;
    @Override
    public List<Product> findAllByMetricNumberId(Long metricNumberId) {
        return em.createNamedQuery("Product.findAllByMetricNumberId", Product.class).setParameter("metricNumberId", metricNumberId).getResultList();
    }

    @Override
    public List<Product> findAllByMetricNumberIdWithDetail(Long metricNumberId) {
        return em.createNamedQuery("Product.findAllWithDetailByMetricNumberId", Product.class).setParameter("metricNumberId", metricNumberId).getResultList();
    }

    @Override
    public Product findById(Long id) {
        return em.createNamedQuery("Product.findById", Product.class).setParameter("id", id).getSingleResult();
    }

    @Override
    public Product save(Product product) {
        if (product.getId() == null) {
            em.persist(product);
        } else {
            em.merge(product);
        }
        return product;
    }

    @Override
    public void delete(Product product) {
        em.remove(em.contains(product)?product:em.merge(product));
    }

    @Override
    public void delete(Long id) {
        delete(findById(id));
    }
}
