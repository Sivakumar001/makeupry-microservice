package com.skproject.makeuprycustomers.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.skproject.makeuprycustomers.VO.RestTemplateVO;
import com.skproject.makeuprycustomers.entity.Customers;
import com.skproject.makeuprycustomers.service.CustomerService;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("/welcome")
    public @ResponseBody String welcome(){
        return "Hello world";
    }
    
    @PostMapping("/add")
    public @ResponseBody String saveNewCustomer(@RequestBody Customers customer){
        customerService.saveNewCustomer(customer);
        return "Saved customer successfully";
    }

    @GetMapping("/show")
    public @ResponseBody List<Customers> getAllCustomers(){
        return customerService.getAllCustomers();
    }

    @GetMapping(value = "/orders/{customerId}")
    public @ResponseBody RestTemplateVO getOrderItems(@PathVariable long customerId){
        return customerService.getOrderItems(customerId);
    }

    @PostMapping(value = "/orderplace")
    public @ResponseBody String placeOrder(@RequestBody RestTemplateVO oItems){
        // RestTemplateVO(orderItems=[OrderItems(customerId=1, productId=2, quantity=2),
        // OrderItems(customerId=1, productId=1, quantity=1)])
        return customerService.placeOrder(oItems);
    }
}
