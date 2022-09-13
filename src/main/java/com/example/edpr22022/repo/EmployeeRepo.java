package com.example.edpr22022.repo;

import com.example.edpr22022.Models.Employee;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EmployeeRepo extends CrudRepository<Employee,Long> {
    List<Employee> findByNameContains(String name);// поиск по символам и содержимому

    Employee findById(long id);
    Employee deleteById(long id);
}