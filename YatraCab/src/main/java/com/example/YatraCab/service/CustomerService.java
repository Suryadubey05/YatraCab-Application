package com.example.YatraCab.service;

import com.example.YatraCab.Exception.CustomerNotFoundException;
import com.example.YatraCab.dto.request.CustomerRequest;
import com.example.YatraCab.dto.response.CustomerResponse;
import com.example.YatraCab.model.Customer;
import com.example.YatraCab.repositiory.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerService {

    @Autowired
    CustomerRepository customerRepository;


    public CustomerResponse addCustomer(CustomerRequest customerRequest) {

        //RequestDTO ----> Entity

        Customer customer = new Customer();
        customer.setName(customerRequest.getName());
        customer.setAge(customerRequest.getAge());
        customer.setEmailId(customerRequest.getEmailId());
        customer.setGender(customerRequest.getGender());

        //save to DB
        Customer savedCustomer = customerRepository.save(customer);


        //saved entity to responseDTO
        CustomerResponse customerResponse = new CustomerResponse();
        customerResponse.setName(savedCustomer.getName());
        customerResponse.setAge(savedCustomer.getAge());
        customerResponse.setEmailId(savedCustomer.getEmailId());


        return customerResponse;
    }

    public CustomerResponse getCustomer(int customerId) {
       Optional<Customer> optionalCustomer = customerRepository.findById(customerId);
       if(optionalCustomer.isEmpty()){
           throw  new CustomerNotFoundException("Invalid Customer Id");
       }

       Customer savedCustomer = optionalCustomer.get();

        //saved entity to responseDTO
        CustomerResponse customerResponse = new CustomerResponse();
        customerResponse.setName(savedCustomer.getName());
        customerResponse.setAge(savedCustomer.getAge());
        customerResponse.setEmailId(savedCustomer.getEmailId());

        return customerResponse;
    }
}
