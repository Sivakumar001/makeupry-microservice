package com.skproject.makeupryorderItems.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.RequestEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.skproject.makeupryorderItems.VO.RestTemplateVO;
import com.skproject.makeupryorderItems.entity.OrderItems;
import com.skproject.makeupryorderItems.service.OrderItemsService;

@RestController
@RequestMapping("/orders")
public class OrderItemsController {
    @Autowired
    private OrderItemsService orderItemsService;

    @GetMapping("/welcome")
    public @ResponseBody String welcomeOrder(){
        return "welcome to order page";
    }

    @PostMapping(value="/add")
    public @ResponseBody String saveOrder(RequestEntity<String> requestEntity){
        System.out.println("sus"+requestEntity.getBody());
        return "Saved order successfully";
    }

    @GetMapping("/show")
    public @ResponseBody List<OrderItems> getAllProducts(){
        return orderItemsService.getAllProducts();
    }

    @GetMapping("/show/{customerId}")
    public @ResponseBody RestTemplateVO getCustomerProducts(@PathVariable long customerId){
        return orderItemsService.getCustomerProducts(customerId);
    }
}
