package com.skproject.makeupryproduct.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.skproject.makeupryproduct.entity.Products;

@Repository
public interface ProductRepository extends JpaRepository<Products, Long>{
}
