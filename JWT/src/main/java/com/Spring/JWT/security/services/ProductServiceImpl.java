package com.Spring.JWT.security.services;

import com.Spring.JWT.models.Product;
import com.Spring.JWT.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepo productRepo;

    public ProductServiceImpl(ProductRepo productRepo) {
        this.productRepo = productRepo;
    }
    @Override
    public Product saveProduct(Product product)
    {
        return productRepo.save(product);
    }
    @Override
    public List<Product> getAllProducts()
    {
        return productRepo.findAll();
    }
    @Override
    public Product getProductById(int id)
    {
        return productRepo.findById(id).orElseThrow();
    }
    @Override
    public Product updateProduct(Product product, int id)
    {
        Product existingProduct = productRepo.findById(id).orElseThrow();
        existingProduct.setProductName(product.getProductName());
        existingProduct.setCost(product.getCost());
        existingProduct.setImage(product.getImage());
        productRepo.save(existingProduct);
        return existingProduct;
    }
    @Override
    public void deleteProduct(int id)
    {
        productRepo.findById(id).orElseThrow();
        productRepo.deleteById(id);
    }
}
