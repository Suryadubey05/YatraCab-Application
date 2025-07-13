package com.example.YatraCab.service;

import com.example.YatraCab.model.Customer;
import com.example.YatraCab.repositiory.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    @Autowired
    CustomerRepository customerRepository;


    public Customer addCustomer(Customer customer) {
        Customer savedCustomer = customerRepository.save(customer);
        return savedCustomer;
    }
}
