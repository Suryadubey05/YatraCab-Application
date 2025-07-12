package com.example.YatraCab;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

@Entity
public class Cab {
    @Id
    private int cabId;
    private String cabNo;
    private String cabModel;
    private double ratePerKm;
    private boolean available;
}
