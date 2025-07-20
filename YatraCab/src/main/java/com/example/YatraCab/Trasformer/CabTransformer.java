package com.example.YatraCab.Trasformer;

import com.example.YatraCab.dto.request.CabRequest;
import com.example.YatraCab.dto.response.CabResponse;
import com.example.YatraCab.model.Cab;
import com.example.YatraCab.model.Driver;

public class CabTransformer {
    public static Cab cabRequestToCab(CabRequest cabRequest) {
        Cab cab = new Cab();

        cab.setCabNo(cabRequest.getCabNo());
        cab.setCabModel(cabRequest.getCabModel());
        cab.setRatePerKm(cabRequest.getRatePerKm());
        cab.setAvailable(true);
        return cab;
    }

    public static CabResponse cabToCabResponse(Cab cab, Driver driver) {
        CabResponse cabResponse = new CabResponse();

        cabResponse.setCabNo(cab.getCabNo());
        cabResponse.setCabModel(cab.getCabModel());
        cabResponse.setRatePerKm(cab.getRatePerKm());
        cabResponse.setAvailable(cab.isAvailable());
        cabResponse.setDriverResponse(DriverTransformer.driverToDriverResponse(driver));
        return cabResponse;
    }
}
