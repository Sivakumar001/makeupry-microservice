package com.skproject.makeuprycustomers.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.skproject.makeuprycustomers.entity.Customers;

@Repository
public interface CustomerRepository extends JpaRepository<Customers, Long>{

    Customers findByCustomerId(long parseLong);
}
