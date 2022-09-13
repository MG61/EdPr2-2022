package com.example.edpr22022.controllers;

import com.example.edpr22022.Models.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import com.example.edpr22022.repo.EmployeeRepo;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class MainControl {


    @Autowired
    private EmployeeRepo employeeRepo;


    @GetMapping("/")
    public String Home(Model model)
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
    public String EmployeeDetails(

            @PathVariable(value="id") long id, Model model)
    {
        Employee pcs = employeeRepo.findById(id);
        model.addAttribute("employee", pcs);
        return "EmployeeShow";
    }
}
