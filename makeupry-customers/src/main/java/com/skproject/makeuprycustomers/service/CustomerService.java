package com.skproject.makeuprycustomers.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.skproject.makeuprycustomers.VO.RestTemplateVO;
import com.skproject.makeuprycustomers.entity.Customers;
import com.skproject.makeuprycustomers.repository.CustomerRepository;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private RestTemplate restTemplate;

    public void saveNewCustomer(Customers customer) {
        customerRepository.save(customer);
    }

    public List<Customers> getAllCustomers() {
        return customerRepository.findAll();
    }

    public RestTemplateVO getOrderItems(long customerId) {
        RestTemplateVO response = restTemplate.getForObject("http://ORDERITEM-SERVICE/orders/show/"+customerId,
        RestTemplateVO.class);
        return response;
    }

    public String placeOrder(RestTemplateVO oItems) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        ObjectMapper mapper = new ObjectMapper();
        ResponseEntity<String> response = new ResponseEntity<String>(HttpStatus.OK);
        try {
            String jsonRequest = mapper.writeValueAsString(oItems);
            HttpEntity<String> entity = new HttpEntity<String>(jsonRequest, headers);

            response = restTemplate.exchange("http://localhost:9002/orders/add",
             HttpMethod.POST, entity, String.class);
        } catch (JsonProcessingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return response.getBody();
    }
}
