package com.example.YatraCab.service;

import com.example.YatraCab.Exception.CabUnavailableException;
import com.example.YatraCab.Exception.CustomerNotFoundException;
import com.example.YatraCab.Exception.DriverNotFoundException;
import com.example.YatraCab.Trasformer.BookingTransformer;
import com.example.YatraCab.dto.request.BookingRequest;
import com.example.YatraCab.dto.response.BookingResponse;
import com.example.YatraCab.model.Booking;
import com.example.YatraCab.model.Cab;
import com.example.YatraCab.model.Customer;
import com.example.YatraCab.model.Driver;
import com.example.YatraCab.repositiory.CabRepository;
import com.example.YatraCab.repositiory.CustomerRepository;
import com.example.YatraCab.repositiory.DriverRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BookingService {

    @Autowired
    DriverRepository driverRepository;
    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    CabRepository cabRepository;



    public BookingResponse bookCab(BookingRequest bookingRequest, int customerId) {
        Optional<Customer> optionalCustomer = customerRepository.findById(customerId);
        if(optionalCustomer.isEmpty()){
            throw new CustomerNotFoundException("Invalid customer");
        }
        Customer customer = optionalCustomer.get();

        Cab availableCab = cabRepository.getAvailableCabRandomly();
        if(availableCab == null){
            throw  new CabUnavailableException("Sorry! No cabs available!");
        }

        Booking booking = BookingTransformer.bookingRequestToBooking(bookingRequest, availableCab.getRatePerKm());
        availableCab.setAvailable(false);
        customer.getBookings().add(booking);
        Driver driver = driverRepository.getDriverByCabId(availableCab.getCabId());
        driver.getBookings().add(booking);

        return null;
    }
}
