package com.example.edpr22022.repo;

import com.example.edpr22022.Models.University;
import org.springframework.data.repository.CrudRepository;

public interface UniversityRepository extends CrudRepository<University, Long> {
    University findByName(String name);
}
