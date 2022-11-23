package com.Spring.JWT.security.services;

import com.Spring.JWT.models.Product;

import java.util.List;

public interface ProductService {
    Product saveProduct(Product product);
    List<Product> getAllProducts();
    Product getProductById(int id);
    Product updateProduct(Product product, int id);
    void deleteProduct(int id);
}
