package com.skproject.makeupryorderItems.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.skproject.makeupryorderItems.entity.OrderItems;

@Repository
public interface OrderItemsRepository extends JpaRepository<OrderItems, Long>{
    List<OrderItems> findAllByCustomerId(long customerId);
}
