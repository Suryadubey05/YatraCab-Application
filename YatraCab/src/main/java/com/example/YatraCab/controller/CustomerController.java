package com.example.YatraCab.controller;

import com.example.YatraCab.Enum.Gender;
import com.example.YatraCab.dto.request.CustomerRequest;
import com.example.YatraCab.dto.response.CustomerResponse;
import com.example.YatraCab.model.Customer;
import com.example.YatraCab.service.CustomerService;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/get/gender/{gender}")
    public List<CustomerResponse> getAllByGender(@PathVariable("gender") Gender gender){
        return customerService.getAllByGender(gender);
    }

    //get all the customers by same age and gender
    @GetMapping("/get")
    public List<CustomerResponse> getAllByGenderAndAge(@PathParam("gender") Gender gender, @PathParam("age") int age){
        return customerService.getAllByGenderAndAge(gender, age);
    }

    //get all the customers which have same gender and age greater than.
    @GetMapping("/get-by-age-greater-than")
    public List<CustomerResponse> getAllByGenderAndAgeGreaterThan(@PathParam("gender") Gender gender,
                                                                  @PathParam("age") int age){
        return customerService.getAllByGenderAndAgeGreaterThan(gender, age);
    }
}
