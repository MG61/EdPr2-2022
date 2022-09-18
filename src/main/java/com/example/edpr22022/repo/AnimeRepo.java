package com.example.edpr22022.repo;

import com.example.edpr22022.Models.Anime;
import com.example.edpr22022.Models.University;
import org.springframework.data.repository.CrudRepository;

public interface AnimeRepo extends CrudRepository<Anime, Long> {
    Anime findByName(String name);
}
