package com.example.YatraCab.model;

import com.example.YatraCab.Enum.Gender;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int customerId;
    private String name;
    private int age;
    private String emailId;
    private Gender gender;


    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="Customer_id")
    List<Booking> bookings = new ArrayList<>();
}
