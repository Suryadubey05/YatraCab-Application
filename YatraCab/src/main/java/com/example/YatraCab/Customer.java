package com.example.YatraCab;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter

@Entity
public class Customer {

    @Id
    private int customerId;
    private String name;
    private int age;
    private String emailId;
    private Gender gender;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="Customer_id")
    ArrayList<Booking> bookings = new ArrayList<>();
}
