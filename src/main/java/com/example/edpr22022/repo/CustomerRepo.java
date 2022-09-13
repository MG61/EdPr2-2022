package com.example.edpr22022.repo;

import com.example.edpr22022.Models.Customer;
import com.example.edpr22022.Models.Employee;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CustomerRepo extends CrudRepository<Customer,Long> {
//    List<Customer> findByNameContains1(String name);// поиск по символам и содержимому

    Customer findById(long id);
    Customer deleteById(long id);
}
