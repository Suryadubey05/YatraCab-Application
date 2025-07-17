package com.example.YatraCab.repositiory;

import com.example.YatraCab.Enum.Gender;
import com.example.YatraCab.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    List<Customer> findByGender(Gender gender);
    List<Customer> findByGenderAndAge(Gender gender, int age);
}
