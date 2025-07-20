package com.example.YatraCab.dto.request;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class BookingRequest {
    private String pickup;
    private String destination;
    private double tripDistKm;



    public String getPickup() {
        return pickup;
    }

    public void setPickup(String pickup) {
        this.pickup = pickup;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public double getTripDistKm() {
        return tripDistKm;
    }

    public void setTripDistKm(double tripDistKm) {
        this.tripDistKm = tripDistKm;
    }
}
