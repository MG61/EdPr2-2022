package com.example.edpr22022.controllers;

import com.example.edpr22022.Models.Customer;
import com.example.edpr22022.Models.Employee;
import com.example.edpr22022.Models.Student;
import com.example.edpr22022.Models.University;
import com.example.edpr22022.repo.CustomerRepo;
import com.example.edpr22022.repo.StudentRepository;
import com.example.edpr22022.repo.UniversityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import com.example.edpr22022.repo.EmployeeRepo;

import javax.validation.Valid;
import java.util.List;


@Controller
public class MainControl {


    @Autowired
    private EmployeeRepo employeeRepo;

    @Autowired
    private CustomerRepo customerRepo;

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private UniversityRepository universityRepository;


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
    public  String AddEmployee(@ModelAttribute("employee") @Valid Employee employee, BindingResult bindingResult
    ){
        if(bindingResult.hasErrors()) {
            return "Employee";
        }
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

    @GetMapping("/Searchemp")
    public String EmployeeSearch(Model model) {return "EmployeeSearch";}

    @PostMapping("/Employee/Search")
    public String EmployeeResult (@RequestParam String name, Model model)
    {
        List<Employee> search = employeeRepo.findByName(name);
        model.addAttribute("search", search);
        return "EmployeeSearch";
    }

    @PostMapping("/Employee/{id}/remove")
    public String EmployeeDelete(@PathVariable("id") long id, Model model){
        Employee employee = employeeRepo.findById(id);
        employeeRepo.delete(employee);
        return "/Employee";
    }
    @GetMapping("/Employee/{id}/edit")
    public String EmployeeEdit(@PathVariable("id")long id, Model model)
    {
        Employee employee = employeeRepo.findById(id);
        model.addAttribute("employee",employee);
        return "EmployeeEdit";
    }
    @PostMapping("/Employee/{id}/edit")
    public String StudentUpdate(@PathVariable("id")long id, @ModelAttribute("employee") @Valid Employee employee, BindingResult bindingResult)
    {
        employee.setId(id);
        if(bindingResult.hasErrors()) {
            return "Employee";
        }
        employeeRepo.save(employee);
        return "Employee";
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
    public  String AddCustomer(@ModelAttribute("customer") @Valid Customer customer, BindingResult bindingResult
    ){
        if(bindingResult.hasErrors()) {
            return "Customer";
        }
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

    @GetMapping("/Searchcus")
    public String CustomerSearch(Model model) {return "CustomerSearch";}

    @PostMapping("/Customer/Search")
    public String CustomerResult (@RequestParam String name, Model model)
    {
        List<Customer> search = customerRepo.findByNameContains(name);
        model.addAttribute("search", search);
        return "CustomerSearch";
    }

    @PostMapping("/Customer/{id}/remove")
    public String CustomerDelete(@PathVariable("id") long id, Model model){
        Customer customer = customerRepo.findById(id);
        customerRepo.delete(customer);
        return "/Customer";
    }

    @GetMapping("/Customer/{id}/edit")
    public String CustomerEdit(@PathVariable("id")long id, Model model)
    {
        Customer customer = customerRepo.findById(id);
        model.addAttribute("customer", customer);
        return "CustomerEdit";
    }
    @PostMapping("/Customer/{id}/edit")
    public String CustomerUpdate(@PathVariable("id")long id, @ModelAttribute("customer") @Valid Customer customer, BindingResult bindingResult)
    {
        if(bindingResult.hasErrors()) {
        return "Customer";
        }
        customer.setId(id);
        customerRepo.save(customer);
        return "Customer";
    }


    //Связи
    @GetMapping("/person")
    private String Main(Model model){
        Iterable<Student> students = studentRepository.findAll();
        model.addAttribute("students", students);
        Iterable<University> universities = universityRepository.findAll();
        model.addAttribute("universities", universities);
        return "person";
    }

    @PostMapping("/person/add")
    public String blogPostAdd(@RequestParam String student, @RequestParam String universiti, Model model)
    {
        Student student2 = studentRepository.findByName(student);
        University university2 = universityRepository.findByName(universiti);
        student2.getUniversities().add(university2);
        university2.getStudents().add(student2);
        studentRepository.save(student2);
        universityRepository.save(university2);
        return "person";
    }
}
