package com.example.YatraCab.service;

import com.example.YatraCab.Exception.DriverNotFoundException;
import com.example.YatraCab.Trasformer.DriverTransformer;
import com.example.YatraCab.dto.request.DriverRequest;
import com.example.YatraCab.dto.response.DriverResponse;
import com.example.YatraCab.model.Driver;
import com.example.YatraCab.repositiory.DriverRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DriverService {

    @Autowired
    DriverRepository driverRepository;

    public DriverResponse addDriver(DriverRequest driverRequest) {
        Driver driver = DriverTransformer.driverResquestToDriver(driverRequest);
        Driver savedDriver = driverRepository.save(driver);
        return DriverTransformer.driverToDriverResponse(savedDriver);
    }

    public DriverResponse getDriver(int driverId) {
        Optional<Driver> optionalDriver = driverRepository.findById(driverId);
        if (optionalDriver.isEmpty()) {
            throw new DriverNotFoundException("Invalid Driver Id");
        }

        Driver savedDriver = optionalDriver.get();

        return DriverTransformer.driverToDriverResponse(savedDriver);
    }

    public List<DriverResponse> getAllAvailableDriver() {
        List<Driver> availableDriver = driverRepository.findByAvailableDriver();
        List<DriverResponse> driverResponses = new ArrayList<>();
        for (Driver d : availableDriver) {
            driverResponses.add(DriverTransformer.driverToDriverResponse(d));
        }
        return driverResponses;
    }

    public void deleteDriverById(int id) {
        driverRepository.deleteById(id);
    }
}
