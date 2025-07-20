package com.example.YatraCab.controller;

import com.example.YatraCab.dto.request.CabRequest;
import com.example.YatraCab.dto.response.CabResponse;
import com.example.YatraCab.service.CabService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cab")
public class CabController {

    @Autowired
    CabService cabService;

    @PostMapping("/register/driver/{driverId}")
    public CabResponse registerCab(@RequestBody CabRequest cabRequest,
                                   @PathVariable("driverId") int driverId){

        return cabService.registerCab(cabRequest, driverId);
    }

}
