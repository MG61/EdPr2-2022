package com.example.edpr22022.Models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.sql.Date;

@Entity
public class Customer {
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

    public Customer() {
    }

    public Customer(String name, String surname, Date number, String email) {
        this.name = name;
        this.surname = surname;
        this.number = number;
        this.email = email;
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

    public Date getNumber() {
        return number;
    }

    public void setNumber(Date number) {
        this.number = number;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
