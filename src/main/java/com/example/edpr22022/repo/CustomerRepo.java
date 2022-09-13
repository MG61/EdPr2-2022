package com.example.edpr22022.repo;

import com.example.edpr22022.Models.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepo extends CrudRepository<Customer,Long> {
}
