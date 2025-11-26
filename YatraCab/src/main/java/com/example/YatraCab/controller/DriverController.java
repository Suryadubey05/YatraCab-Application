package com.example.YatraCab.controller;
import com.example.YatraCab.dto.request.DriverRequest;
import com.example.YatraCab.dto.response.DriverResponse;
import com.example.YatraCab.service.BookingService;
import com.example.YatraCab.service.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/driver")
public class DriverController {

    @Autowired
    DriverService driverService;

    @Autowired
    BookingService bookingService;

    @PostMapping("/add")
    public DriverResponse addDriver(@RequestBody DriverRequest driverRequest){
        return driverService.addDriver(driverRequest);
    }

    @GetMapping("/get/{id}")
    public DriverResponse getDriver(@PathVariable("id") int driverId){
        return driverService.getDriver(driverId);
    }

    @GetMapping("/get/availableDriver")
    public List<DriverResponse> getAllAvailableDriver(){
        return driverService.getAllAvailableDriver();
    }

    @DeleteMapping("/delete/{id}")
    public DriverResponse deleteDriverById(@PathVariable("id") int id){
        DriverResponse deletedDriver = driverService.getDriver(id);
        driverService.deleteDriverById(id);
        return deletedDriver;
    }


}
