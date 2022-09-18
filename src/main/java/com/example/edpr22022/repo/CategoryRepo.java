package com.example.edpr22022.repo;

import com.example.edpr22022.Models.Anime;
import com.example.edpr22022.Models.Category;
import org.springframework.data.repository.CrudRepository;

import java.util.Locale;

public interface CategoryRepo extends CrudRepository<Category, Long> {
    Category findByName(String name);
}
