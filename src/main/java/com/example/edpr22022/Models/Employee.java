package com.example.edpr22022.Models;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.sql.Date;

@Entity
public class Employee {
    @Id
    @GeneratedValue
    private Long id;
    @NotEmpty(message = "Заполните это поле!")
    @Size(min = 2, max = 30, message = "От 2 до 30 символов")
    private String name;
    @NotEmpty(message = "Заполните это поле!")
    @Size(min = 2, max = 30, message = "От 2 до 30 символов")
    private String surname;
    private Date number;
    private String email;

    public Date getNumber() {
        return number;
    }

    public void setNumber(Date number) {
        this.number = number;
    }

    public Employee(String name, String surname, Date number, String email) {
        this.name = name;
        this.surname = surname;
        this.number = number;
        this.email = email;
    }

    public Employee() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public void setEmail(String email) {
        this.email = email;
    }


}
