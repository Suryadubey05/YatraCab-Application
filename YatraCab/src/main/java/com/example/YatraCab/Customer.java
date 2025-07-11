package com.example.YatraCab;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
}
