package com.example.YatraCab.dto.request;

import com.example.YatraCab.Trasformer.DriverTransformer;
import com.example.YatraCab.dto.response.DriverResponse;
import com.example.YatraCab.model.Driver;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class DriverRequest {
    private String name;
    private int age;
    private String emailId;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }
}
