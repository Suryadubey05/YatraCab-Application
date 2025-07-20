package com.example.YatraCab.dto.response;

import com.example.YatraCab.Enum.TripStatus;

import java.util.Date;

public class BookingResponse {
    String pickup;
    String destination;
    double tripDistKm;
    TripStatus tripStatus;
    double billAmount;
    Date bookedAt;
    Date lastUpdate;

    CustomerResponse customer;

    CabResponse cab;   //both driver and cab response



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

    public TripStatus getTripStatus() {
        return tripStatus;
    }

    public void setTripStatus(TripStatus tripStatus) {
        this.tripStatus = tripStatus;
    }

    public double getBillAmount() {
        return billAmount;
    }

    public void setBillAmount(double billAmount) {
        this.billAmount = billAmount;
    }

    public Date getBookedAt() {
        return bookedAt;
    }

    public void setBookedAt(Date bookedAt) {
        this.bookedAt = bookedAt;
    }

    public Date getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public CustomerResponse getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerResponse customer) {
        this.customer = customer;
    }

    public CabResponse getCab() {
        return cab;
    }

    public void setCab(CabResponse cab) {
        this.cab = cab;
    }
}
