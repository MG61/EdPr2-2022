package com.example.edpr22022.controllers;

import com.example.edpr22022.Models.Customer;
import com.example.edpr22022.Models.Employee;
import com.example.edpr22022.repo.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.example.edpr22022.repo.EmployeeRepo;

import java.util.List;


@Controller
public class MainControl {


    @Autowired
    private EmployeeRepo employeeRepo;

    @Autowired
    private CustomerRepo customerRepo;


    @GetMapping("/")
    public String Home()
    {
        return "Home";
    }

    @GetMapping("/Employee")
    public String Employee(Model model) {
        Iterable<Employee> employee = employeeRepo.findAll();
        model.addAttribute("employee",employee);
        return "Employee";
    }
    @GetMapping("/Employee/add")
    public String EmployeeAdd(Employee employee, Model model) {return "EmployeeAdd";}

    @PostMapping("/Employee/add")
    public  String AddEmployee(@ModelAttribute("employee") Employee employee
    ){
        employeeRepo.save(employee);
        return "Employee";
    }
    @GetMapping("/Employee/{id}")
    public String EmployeeDetails(@PathVariable(value="id") long id, Model model)
    {
        Employee emp = employeeRepo.findById(id);
        model.addAttribute("employee", emp);
        return "EmployeeShow";
    }

    @GetMapping("/Search")
    public String EmployeeSearch(Model model) {return "EmployeeSearch";}

    @PostMapping("/Employee/Search")
    public String EmployeeResult (@RequestParam String name, Model model)
    {
        List<Employee> search = employeeRepo.findByNameContains(name);
        model.addAttribute("search", search);
        return "EmployeeSearch";
    }

    @GetMapping("/Customer")
    public String Customer(Model model) {
        Iterable<Customer> customer = customerRepo.findAll();
        model.addAttribute("customer",customer);
        return "Customer";
    }

    @GetMapping("/Customer/add")
    public String CustomerAdd(Customer customer, Model model) {return "CustomerAdd";}

    @PostMapping("/Customer/add")
    public  String AddCustomer(@ModelAttribute("customer") Customer customer
    ){
        customerRepo.save(customer);
        return "Customer";
    }

    @GetMapping("/Customer/{id}")
    public String CustomerDetails(@PathVariable(value="id") long id, Model model)
    {
        Customer customer = customerRepo.findById(id);
        model.addAttribute("customer", customer);
        return "CustomerShow";
    }
}
