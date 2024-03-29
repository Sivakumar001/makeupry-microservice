package com.skproject.makeupryorderItems.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderItems {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long orderId;
    private Long customerId;
    private Long productId;
    private int quantity;
}
