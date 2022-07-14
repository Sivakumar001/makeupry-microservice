package com.skproject.makeupryproduct.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.skproject.makeupryproduct.entity.Products;
import com.skproject.makeupryproduct.service.ProductService;

@RestController
@RequestMapping("/products")
public class ProductController {
    
    @Autowired
    private ProductService productService;

    @GetMapping("/welcome")
    public @ResponseBody String welcome(){
        return "Welcome you are in products";
    }

    @PostMapping(value = "/add")
    public @ResponseBody String saveProducts(@RequestBody Products product){
        productService.saveProducts(product);
        return "saved product successfully";
    }

    @GetMapping(value = "/show")
    public @ResponseBody List<Products> getAllProducts(){
        return productService.getAllProducts();
    }
}
