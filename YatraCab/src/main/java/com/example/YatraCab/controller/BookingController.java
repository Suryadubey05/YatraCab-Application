package com.example.YatraCab.controller;

import com.example.YatraCab.dto.request.BookingRequest;
import com.example.YatraCab.dto.request.CancelTripRequest;
import com.example.YatraCab.dto.request.DateRangeRequest;
import com.example.YatraCab.dto.response.BookingResponse;
import com.example.YatraCab.dto.response.DateRangeResponse;
import com.example.YatraCab.model.Booking;
import com.example.YatraCab.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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


    @PostMapping("/bookings/by-date")
    public DateRangeResponse getBookingsByDate(@RequestBody DateRangeRequest req) {
        return bookingService.getBookingsByDate(
                req.getDriverId(),
                req.getStart(),
                req.getEnd()
        );
    }

    @PatchMapping("/{id}/complete")
    public ResponseEntity<BookingResponse> completeTrip(@PathVariable int id) {
        BookingResponse res = bookingService.completeTrip(id);
        return ResponseEntity.ok(res);
    }

    @PostMapping("/cancelBooking/{id}")
    public ResponseEntity<BookingResponse> cancelTrip(@PathVariable("id") int id,
                                                      @RequestBody CancelTripRequest cancelTripRequest){
        BookingResponse bookingResponse = bookingService.cancelTrip(id, cancelTripRequest);
        return ResponseEntity.ok(bookingResponse);
    }

}
