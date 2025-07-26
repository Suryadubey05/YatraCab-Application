package com.example.YatraCab.controller;

import com.example.YatraCab.dto.request.BookingRequest;
import com.example.YatraCab.dto.response.BookingResponse;
import com.example.YatraCab.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/booking")
public class BookingController {

    @Autowired
    BookingService bookingService;

    @PostMapping("/book/cab/{customerId}")
    public BookingResponse bookCab(@RequestBody BookingRequest bookingRequest,
                                   @PathVariable("customerId") int customerId){
        return bookingService.bookCab(bookingRequest, customerId);
    }

    //cancel booking

    //completed booking
    @PutMapping("/completed/booking/{id}/{destination}")
    public ResponseEntity<String> completedBooking(@PathVariable("id") int id,
                                                   @PathVariable("destination") String destination){
        double amount = bookingService.completedBooking(id, destination);

        return new ResponseEntity<>("Completed your ride." + " This is Your final amount " + amount, HttpStatus.OK);
    }
}
