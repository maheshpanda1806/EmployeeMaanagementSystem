package com.ems.EmployeeManagementSystem.controllers;

import com.ems.EmployeeManagementSystem.models.Employee;
import org.springframework.web.bind.annotation.*;
import com.ems.EmployeeManagementSystem.services.EmployeeService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class EmployeeControllers {

    private final EmployeeService employeeService;

    public static class PhotoDTO {
        public String photoPath;
    }

    public EmployeeControllers(EmployeeService emp){
        this.employeeService = emp;
    }
    @GetMapping
    public List<Employee> getEmployees(){
        return employeeService.getAllEmployee();
    }
    @GetMapping("/{id}")
    public Optional<Employee> getByID(@PathVariable Long id){
        return employeeService.getEmployeeById(id);
    }
    @PostMapping
    public Employee addEmployee(@RequestBody Employee e){
        return employeeService.addEmployee(e);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id){
        employeeService.deleteById(id);
    }
    @PutMapping("/{id}")
    public Employee update(@PathVariable long id, @RequestBody Employee e){
        return employeeService.update(id,e);
    }
    @PutMapping("photo/{id}")
    public Employee updatePhoto(@PathVariable long id, @RequestBody PhotoDTO dto){
        return employeeService.updatePhoto(id,dto.photoPath);
    }
}
