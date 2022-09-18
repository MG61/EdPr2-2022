package com.example.edpr22022.Models;

import javax.persistence.*;
import java.util.List;

@Entity
public class Anime {

    @Id
    @GeneratedValue
    Long id;

    @Column
    String name, quantity;

    public Anime(String name, String quantity) {
        this.name = name;
        this.quantity = quantity;
    }

    public Anime() {
    }

    @ManyToMany
    @JoinTable(name="anime_category",
            joinColumns=@JoinColumn(name="anime_id"),
            inverseJoinColumns=@JoinColumn(name="category_id"))
    private List<Category> category;

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

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public List<Category> getCategory() {
        return category;
    }

    public void setCategory(List<Category> category) {
        this.category = category;
    }
}
