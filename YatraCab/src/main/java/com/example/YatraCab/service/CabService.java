package com.example.YatraCab.service;

import com.example.YatraCab.Exception.DriverNotFoundException;
import com.example.YatraCab.Trasformer.CabTransformer;
import com.example.YatraCab.dto.request.CabRequest;
import com.example.YatraCab.dto.response.CabResponse;
import com.example.YatraCab.model.Cab;
import com.example.YatraCab.model.Driver;
import com.example.YatraCab.repositiory.CabRepository;
import com.example.YatraCab.repositiory.DriverRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CabService {

    @Autowired
    DriverRepository driverRepository;

    public  CabResponse registerCab(CabRequest cabRequest, int driverId) {

        Optional<Driver> optionalDriver = driverRepository.findById(driverId);
        if(optionalDriver.isEmpty()){
            throw new DriverNotFoundException("Invalid driver Id!");
        }

        Driver driver = optionalDriver.get();

        Cab cab = CabTransformer.cabRequestToCab(cabRequest);
        driver.setCab(cab);

        Driver savedDriver = driverRepository.save(driver);  //save both cab and driver

        return CabTransformer.cabToCabResponse(savedDriver.getCab(), savedDriver);

    }
}
