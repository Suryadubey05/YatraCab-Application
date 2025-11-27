package com.example.YatraCab.dto.response;

import com.example.YatraCab.Enum.TripStatus;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;
import java.util.Date;

public class BookingResponse {
    String pickup;
    String destination;
    double tripDistKm;
    TripStatus tripStatus;
    double billAmount;
    @JsonFormat(pattern = "yyyy-MM-dd")
    Date bookedAt;
    @JsonFormat(pattern = "yyyy-MM-dd")
    Date lastUpdate;
    String cancelReason;
    @JsonFormat(pattern = "yyyy-MM-dd")
    LocalDateTime cancelledAt;


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

    public String getCancelReason() {
        return cancelReason;
    }

    public void setCancelReason(String cancelReason) {
        this.cancelReason = cancelReason;
    }

    public LocalDateTime getCancelledAt() {
        return cancelledAt;
    }

    public void setCancelledAt(LocalDateTime cancelledAt) {
        this.cancelledAt = cancelledAt;
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
