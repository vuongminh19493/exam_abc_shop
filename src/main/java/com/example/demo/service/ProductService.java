package com.example.demo.service;

import com.example.demo.entity.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    List<Product> getAllProduct();

    void saveProduct(Product product);

    Optional<Product> findProductById(int id);
}
