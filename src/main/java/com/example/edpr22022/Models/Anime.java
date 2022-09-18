package com.example.edpr22022.Models;

public class Anime {
    public Anime(String name, String quanitity, String category) {
        this.name = name;
        this.quanitity = quanitity;
        this.category = category;
    }

    public Anime() {
    }

    Long id;
    String name, quanitity, category;

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

    public String getQuanitity() {
        return quanitity;
    }

    public void setQuanitity(String quanitity) {
        this.quanitity = quanitity;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
