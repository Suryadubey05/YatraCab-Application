package com.example.YatraCab.service;

import com.example.YatraCab.Trasformer.DriverTransformer;
import com.example.YatraCab.dto.request.DriverRequest;
import com.example.YatraCab.dto.response.DriverResponse;
import com.example.YatraCab.model.Driver;
import com.example.YatraCab.repositiory.DriverRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DriverService {

    @Autowired
    DriverRepository driverRepository;

    public DriverResponse addDriver(DriverRequest driverRequest) {
        Driver driver = DriverTransformer.driverResquestToDriver(driverRequest);
        Driver savedDriver = driverRepository.save(driver);
        return DriverTransformer.driverToDriverResponse(savedDriver);
    }
}
