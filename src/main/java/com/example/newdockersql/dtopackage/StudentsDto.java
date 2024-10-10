package com.example.newdockersql.dtopackage;

import lombok.Data;
import org.springframework.stereotype.Component;
@Data
@Component
public class StudentsDto {

    private String name;    // Signup için gerekli
    private String surname; // Signup için gerekli
    private String email;
    private String password;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email){
        this.email = email;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
}
