package com.example.edpr22022.controllers;

import com.example.edpr22022.Models.*;
import com.example.edpr22022.repo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@Controller
public class MainControl {


    @Autowired
    private EmployeeRepo employeeRepo;

    @Autowired
    private CustomerRepo customerRepo;

    @Autowired
    private AnimeRepo animeRepo;

    @Autowired
    private CategoryRepo categoryRepo;


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
     @GetMapping("/Anime")
    public String Anime(Model model) {
        Iterable<Anime> anime = animeRepo.findAll();
        model.addAttribute("anime",anime);
        return "Anime";
    }

    @GetMapping("/Anime/add")
    public String AnimeAdd(Anime anime, Model model) {return "AnimeAdd";}

    @PostMapping("/Anime/add")
    public  String AddEmployee(@ModelAttribute("anime") @Valid Anime anime){
        animeRepo.save(anime);
        return "Anime";
    }

    @GetMapping("/Anime/add/category")
    private String AnimeAddCategory(Model model){
        Iterable<Anime> anime = animeRepo.findAll();
        model.addAttribute("anime", anime);
        Iterable<Category> categori = categoryRepo.findAll();
        model.addAttribute("category", categori);
        return "AnimeAddCategory";
    }

    @PostMapping("/Anime/add/category")
    public String Animeadd(@RequestParam String Anime, @RequestParam String category, Model model)
    {
        Anime anime2 = animeRepo.findByName(Anime);
        Category category2 = categoryRepo.findByName(category);
        anime2.getCategory().add(category2);
        category2.getAnime().add(anime2);
        animeRepo.save(anime2);
        categoryRepo.save(category2);
        return "Anime";
    }
}
