package com.example.YatraCab.repositiory;

import com.example.YatraCab.Trasformer.DriverTransformer;
import com.example.YatraCab.dto.request.DriverRequest;
import com.example.YatraCab.dto.response.DriverResponse;
import com.example.YatraCab.model.Driver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface DriverRepository extends JpaRepository<Driver, Integer>{
    @Query(value = "select * from Driver where cab_id = :cabId", nativeQuery = true)
    Driver getDriverByCabId(@Param("cabId") int cabId);

    @Query(value = "select d.* from driver d INNER JOIN cab c ON d.cab_id = c.cab_id where c.available = 1", nativeQuery = true)
    List<Driver> findByAvailableDriver();

    @Query(value = "select cab_id from Driver where driver_id = :id", nativeQuery = true)
    int getCabIdByDriverId(@Param("id") int driverId);
}
