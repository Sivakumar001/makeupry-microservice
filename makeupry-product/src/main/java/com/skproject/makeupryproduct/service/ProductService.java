package com.skproject.makeupryproduct.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.skproject.makeupryproduct.entity.Products;
import com.skproject.makeupryproduct.repository.ProductRepository;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public void saveProducts(Products product) {
        productRepository.save(product);
    }

    public List<Products> getAllProducts() {
        return productRepository.findAll();
    }
}
