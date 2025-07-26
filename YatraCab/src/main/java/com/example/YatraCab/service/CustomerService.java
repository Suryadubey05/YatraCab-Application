package com.example.YatraCab.service;

import com.example.YatraCab.Enum.Gender;
import com.example.YatraCab.Exception.CustomerNotFoundException;
import com.example.YatraCab.Trasformer.CustomerTransformer;
import com.example.YatraCab.dto.request.CustomerRequest;
import com.example.YatraCab.dto.response.CustomerResponse;
import com.example.YatraCab.model.Customer;
import com.example.YatraCab.repositiory.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    @Autowired
    CustomerRepository customerRepository;


    public CustomerResponse addCustomer(CustomerRequest customerRequest) {

        //RequestDTO ----> Entity
       Customer customer = CustomerTransformer.customerRequestToCustomer(customerRequest);

        //save to DB
        Customer savedCustomer = customerRepository.save(customer);


        //saved entity to responseDTO
        return  CustomerTransformer.customerToCustomerResponse(savedCustomer);

    }

    public CustomerResponse getCustomer(int customerId) {
       Optional<Customer> optionalCustomer = customerRepository.findById(customerId);
       if(optionalCustomer.isEmpty()){
           throw  new CustomerNotFoundException("Invalid Customer Id");
       }

       Customer savedCustomer = optionalCustomer.get();

        //saved entity to responseDTO
        return CustomerTransformer.customerToCustomerResponse(savedCustomer);
    }

    public List<CustomerResponse> getAllByGender(Gender gender) {
        List<Customer> customerGender = customerRepository.findByGender(gender);
        List<CustomerResponse> customerResponses = new ArrayList<>();

        for(Customer customer : customerGender){
            customerResponses.add(CustomerTransformer.customerToCustomerResponse(customer));
        }

        return customerResponses;
    }

    public List<CustomerResponse> getAllByGenderAndAge(Gender gender, int age) {
        List<Customer> customers = customerRepository.findByGenderAndAge(gender, age);
        List<CustomerResponse> customerResponses = new ArrayList<>();

        for(Customer customer : customers){
            customerResponses.add(CustomerTransformer.customerToCustomerResponse(customer));
        }

        return customerResponses;
    }

    public List<CustomerResponse> getAllByGenderAndAgeGreaterThan(Gender gender, int age) {
        List<Customer> customers = customerRepository.getAllByGenderAndAgeGreaterThan(gender, age);
        List<CustomerResponse> customerResponses = new ArrayList<>();

        for(Customer customer : customers){
            customerResponses.add(CustomerTransformer.customerToCustomerResponse(customer));
        }

        return customerResponses;
    }

    public CustomerResponse updateCustomerById(CustomerRequest customerRequest, int id) {
        //fetch customer details
        Optional<Customer> optionalCustomer = customerRepository.findById(id);
        if (optionalCustomer.isEmpty()){
            throw new CustomerNotFoundException("Invalid CustomerId!");
        }
        Customer oldCustomer = optionalCustomer.get();

        Customer newCustomer = CustomerTransformer.customerRequestToCustomer(customerRequest);

        //update the details
        oldCustomer.setName(newCustomer.getName());
        oldCustomer.setAge(newCustomer.getAge());
        oldCustomer.setGender(newCustomer.getGender());
        oldCustomer.setEmailId(newCustomer.getEmailId());

        //save new details into DB
        Customer savedNewCustomer = customerRepository.save(oldCustomer);

        return CustomerTransformer.customerToCustomerResponse(savedNewCustomer);
    }

    public void deleteCustomerById(int id) {
        customerRepository.deleteById(id);
    }
}
