package ru.kiasystems.logic.beans.impl;

import ru.kiasystems.logic.beans.interfaces.ProductEJBRemote;
import ru.kiasystems.model.entity.Product;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Stateless
@LocalBean
public class ProductEJB implements ProductEJBRemote {
    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public List<Product> getAllProducts() {
        List<Product> Products =null;
        if (entityManager!=null) {
            TypedQuery<Product> namedQuery = entityManager.createNamedQuery("Product.getAllProducts", Product.class);
            Products = namedQuery.getResultList();
        }
        return Products;
    }
    @Override
    public String getName() {
        return this.getClass().getName();
    }
    @Override
    public void addProduct(Product product) {
        entityManager.persist(product);
    }
    @Override
    public Product getProductById(Long id) {
        return entityManager.find(Product.class, id);
    }
    @Override
    public Product updateProduct(Product product) {
        product = entityManager.merge(product);
        return product;
    }
    @Override
    public void deleteProduct(Product product) {
        entityManager.remove(entityManager.contains(product)?product:entityManager.merge(product));
    }
}
