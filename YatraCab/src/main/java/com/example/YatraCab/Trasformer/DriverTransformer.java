package com.example.YatraCab.Trasformer;

import com.example.YatraCab.dto.request.DriverRequest;
import com.example.YatraCab.dto.response.DriverResponse;
import com.example.YatraCab.model.Driver;

public class DriverTransformer {


    public static Driver driverResquestToDriver(DriverRequest driverRequest){
//        return Driver.builder()
//                .name(driverRequest.getName())
//                .age(driverRequest.getAge())
//                .emailId(driverRequest.getEmailId())
//                .build();
        Driver driver = new Driver();
        driver.setName(driverRequest.getName());
        driver.setAge(driverRequest.getAge());
        driver.setEmailId(driverRequest.getEmailId());
        return driver;
    }

    public static DriverResponse driverToDriverResponse(Driver driver){
//        return DriverResponse.builder()
//                .driverId(driver.getDriverId())
//                .name(driver.getName())
//                .age(driver.getAge())
//                .emailId(driver.getEmailId())
//                .build();

        DriverResponse driverResponse = new DriverResponse();

        driverResponse.setDriverId(driver.getDriverId());
        driverResponse.setName(driver.getName());
        driverResponse.setAge(driver.getAge());
        driverResponse.setEmailId(driver.getEmailId());

        return driverResponse;
    }
}
