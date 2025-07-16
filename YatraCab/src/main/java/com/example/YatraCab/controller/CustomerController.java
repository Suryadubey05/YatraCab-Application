package com.example.YatraCab.controller;

import com.example.YatraCab.dto.request.CustomerRequest;
import com.example.YatraCab.dto.response.CustomerResponse;
import com.example.YatraCab.model.Customer;
import com.example.YatraCab.service.CustomerService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @PostMapping("/addCustomer")
    public CustomerResponse addCustomer(@RequestBody CustomerRequest customerRequest) {
       return customerService.addCustomer(customerRequest);
    }


    @GetMapping("/get/customer-id/{id}")
    public CustomerResponse getCustomer(@PathVariable("id") int customerId){
        return customerService.getCustomer(customerId);
    }
}
