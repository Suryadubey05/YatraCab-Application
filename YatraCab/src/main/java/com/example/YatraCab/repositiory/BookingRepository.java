package com.example.YatraCab.repositiory;

import com.example.YatraCab.model.Booking;
import com.example.YatraCab.model.Cab;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

public interface BookingRepository extends JpaRepository<Booking, Integer> {
    @Query(value = "select destination from booking where customer_id = :id order by last_update desc limit 1", nativeQuery = true)
    String getDestinationByCustomerId(@Param("id") int id);


    @Query(value = "select bill_amount from booking where customer_id = :id order by last_update desc limit 1", nativeQuery = true)
    double getAmountByCustomerId(@Param("id") int id);


    @Query(value = "SELECT * FROM booking WHERE driver_id = :id AND booked_at BETWEEN :start AND :end", nativeQuery = true)
    List<Booking> findByDriverIdAndBookedAtBetween(@Param("id") int driverId,
                                                   @Param("start") Date start,
                                                   @Param("end") Date end);

    @Query(value = "SELECT driver_id FROM booking WHERE booking_id = :id", nativeQuery = true)
    int findDriverByBookingId(@Param("id") int bookingId);

    @Query(value = "SELECT customer_id FROM booking WHERE booking_id = :id", nativeQuery = true)
    int findByCustomerId(@Param("id") int bookingId);
}
