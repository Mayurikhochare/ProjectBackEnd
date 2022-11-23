package com.Spring.JWT.controllers;


import com.Spring.JWT.models.Product;
import com.Spring.JWT.security.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/product")
public class ProductController {
    @Autowired
    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }
    @PostMapping
    public ResponseEntity<Product> saveProduct(@RequestBody Product product)
    {
        return new ResponseEntity<Product>(productService.saveProduct(product), HttpStatus.CREATED);
    }
    @GetMapping
    public List<Product> getAllProducts()
    {
        return productService.getAllProducts();
    }
    @GetMapping("{id}")
    public ResponseEntity<Product> getProductById(@PathVariable("id")int id)
    {
        return new ResponseEntity<Product>(productService.getProductById(id),HttpStatus.OK);
    }
    @PutMapping("{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable("id")int id, @RequestBody Product product)
    {
        return new ResponseEntity<Product>(productService.updateProduct(product,id), HttpStatus.OK);
    }
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable("id")int id)
    {
        productService.deleteProduct(id);
        return new ResponseEntity<String>("Student deleted successfully",HttpStatus.OK);
    }
}
