package ru.kiasystems.logic.beans.interfaces;

import ru.kiasystems.model.entity.Product;
import java.util.List;

public interface ProductEJBRemote {
    String getName();
    List<Product> getAllProducts();
    void addProduct(Product user);
    Product getProductById(Long id);
    Product updateProduct(Product product);
    void deleteProduct(Product user);
}
