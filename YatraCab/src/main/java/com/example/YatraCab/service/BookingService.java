package com.example.YatraCab.service;

import com.example.YatraCab.Enum.TripStatus;
import com.example.YatraCab.Exception.CabNotFound;
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
import com.example.YatraCab.repositiory.BookingRepository;
import com.example.YatraCab.repositiory.CabRepository;
import com.example.YatraCab.repositiory.CustomerRepository;
import com.example.YatraCab.repositiory.DriverRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
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

    @Autowired
    BookingRepository bookingRepository;

    @Autowired
    JavaMailSender javaMailSender;


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


        //convert bookingRequest -> booking
        Booking booking = BookingTransformer.bookingRequestToBooking(bookingRequest, availableCab.getRatePerKm());
        Booking savedBooking = bookingRepository.save(booking); //bcoz we want primary key to update data
                                                                // of driver and customers bookings

        availableCab.setAvailable(false);
        customer.getBookings().add(savedBooking);  //overRide in database which have same primary key in bookings

        Driver driver = driverRepository.getDriverByCabId(availableCab.getCabId());
        driver.getBookings().add(savedBooking);    //overRide in database which have same primary key in bookings

        Customer savedCustomer = customerRepository.save(customer);
        Driver savedDriver = driverRepository.save(driver);

        //call sendMail method
        sendEmail(savedCustomer);

        return BookingTransformer.bookingToBookingResponse(booking, savedCustomer, availableCab, savedDriver);
    }

    private void sendEmail(Customer customer){
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();

        String text = "Congrats!! "+customer.getName()+". Your cab has been booked.";

        simpleMailMessage.setFrom("skd.dev05@gmail.com");
        simpleMailMessage.setTo(customer.getEmailId());
        simpleMailMessage.setSubject("Cab Booked!");
        simpleMailMessage.setText(text);


        javaMailSender.send(simpleMailMessage);
    }

    public double completedBooking(int id, String destination) {
        String reachedDestination = bookingRepository.getDestinationByCustomerId(id);
        double amount = (double)bookingRepository.getAmountByCustomerId(id);
        if(destination.equals(reachedDestination)){
            return amount;
        }
        return -1;
    }
}
