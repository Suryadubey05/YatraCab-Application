package com.example.YatraCab.controller;

import com.example.YatraCab.dto.request.BookingRequest;
import com.example.YatraCab.dto.response.BookingResponse;
import com.example.YatraCab.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/booking")
public class BookingController {

    @Autowired
    BookingService bookingService;

    public BookingResponse bookCab(@RequestBody BookingRequest bookingRequest,
                                   @RequestParam("customerId") int customerId){
        return bookingService.bookCab(bookingRequest, customerId);
    }
}
