package com.example.YatraCab.repositiory;

import com.example.YatraCab.model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<Booking, Integer> {
}
