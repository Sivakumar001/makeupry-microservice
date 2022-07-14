package com.skproject.makeupryorderItems.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skproject.makeupryorderItems.VO.RestTemplateVO;
import com.skproject.makeupryorderItems.entity.OrderItems;
import com.skproject.makeupryorderItems.repository.OrderItemsRepository;

@Service
public class OrderItemsService {
    @Autowired
    private OrderItemsRepository orderItemsRepository;

    public void saveOrder(List<OrderItems> order) {
        orderItemsRepository.saveAll(order);
    }

    public List<OrderItems> getAllProducts() {
        return orderItemsRepository.findAll();
    }

    public RestTemplateVO getCustomerProducts(long customerId) {
        RestTemplateVO vo = new RestTemplateVO();
        vo.setOrders(orderItemsRepository.findAllByCustomerId(customerId));
        return vo;
    }
}
