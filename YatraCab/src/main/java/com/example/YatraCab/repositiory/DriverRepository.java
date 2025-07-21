package com.example.YatraCab.repositiory;

import com.example.YatraCab.Trasformer.DriverTransformer;
import com.example.YatraCab.dto.request.DriverRequest;
import com.example.YatraCab.dto.response.DriverResponse;
import com.example.YatraCab.model.Driver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface DriverRepository extends JpaRepository<Driver, Integer>{
    @Query(value = "select * from Driver where cab_id = :cabId", nativeQuery = true)
    Driver getDriverByCabId(@Param("cabId") int cabId);
}
