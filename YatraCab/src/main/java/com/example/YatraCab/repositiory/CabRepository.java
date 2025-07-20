package com.example.YatraCab.repositiory;

import com.example.YatraCab.model.Cab;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CabRepository extends JpaRepository<Cab, Integer> {
    @Query("select c from Cab c where c.available = true order by rand() limit 1")
    Cab getAvailableCabRandomly();
}
