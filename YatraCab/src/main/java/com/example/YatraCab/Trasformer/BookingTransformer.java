package com.example.YatraCab.Trasformer;

import com.example.YatraCab.Enum.TripStatus;
import com.example.YatraCab.dto.request.BookingRequest;
import com.example.YatraCab.dto.response.BookingResponse;
import com.example.YatraCab.model.Booking;
import com.example.YatraCab.model.Cab;
import com.example.YatraCab.model.Customer;
import com.example.YatraCab.model.Driver;

public class BookingTransformer {
    public static Booking bookingRequestToBooking(BookingRequest bookingRequest, double perKmRate){
        Booking booking = new Booking();
        booking.setPickup(bookingRequest.getPickup());
        booking.setDestination(bookingRequest.getDestination());
        booking.setTripDistKm(bookingRequest.getTripDistKm());
        booking.setTripStatus(TripStatus.IN_PROGRESS);
        booking.setBillAmount(bookingRequest.getTripDistKm() * perKmRate);

        return booking;
    }

    public static BookingResponse bookingToBookingResponse(Booking booking, Customer customer, Cab cab, Driver driver){
        BookingResponse bookingResponse = new BookingResponse();
        bookingResponse.setPickup(booking.getPickup());
        bookingResponse.setDestination(booking.getDestination());
        bookingResponse.setTripDistKm(booking.getTripDistKm());
        bookingResponse.setTripStatus(booking.getTripStatus());
        bookingResponse.setBillAmount(booking.getBillAmount());
        bookingResponse.setBookedAt(booking.getBookedAt());
        bookingResponse.setLastUpdate(booking.getLastUpdate());

        bookingResponse.setCustomer(CustomerTransformer.customerToCustomerResponse(customer));
        bookingResponse.setCab(CabTransformer.cabToCabResponse(cab,driver));

        return bookingResponse;
    }
}
