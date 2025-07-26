package com.example.YatraCab.repositiory;

import com.example.YatraCab.model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface BookingRepository extends JpaRepository<Booking, Integer> {
    @Query(value = "select destination from booking where customer_id = :id order by last_update desc limit 1", nativeQuery = true)
    String getDestinationByCustomerId(@Param("id") int id);


    @Query(value = "select bill_amount from booking where customer_id = :id order by last_update desc limit 1", nativeQuery = true)
    double getAmountByCustomerId(@Param("id") int id);
}
