package com.ems.EmployeeManagementSystem.services;

import com.ems.EmployeeManagementSystem.models.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ems.EmployeeManagementSystem.repositories.EmployeeRepo;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
   private final EmployeeRepo employeeRepo;

   @Autowired
   public EmployeeService(EmployeeRepo employeeRepo){
      this.employeeRepo = employeeRepo;
   }

   public List<Employee> getAllEmployee(){
       return employeeRepo.findAll();
   }

   public Employee addEmployee(Employee e){
       return employeeRepo.save(e);
   }
    public Optional<Employee> getEmployeeById(Long id){
        return employeeRepo.findById(id);
    }

   public void deleteById(long id){
       employeeRepo.deleteById(id);
   }

    public Employee update(long id, Employee e) {
        return employeeRepo.findById(id) // Fetch the existing employee
                .map(employee -> {
                    // Update fields
                    employee.setName(e.getName());
                    employee.setUid(e.getUid());
                    employee.setSalaryPA(e.getSalaryPA());
                    // Save the updated employee
                    return employeeRepo.save(employee);
                })
                .orElseThrow(() -> new RuntimeException("Employee not found with id " + id));
    }

    public Employee updatePhoto(long id, String newPhotoPath) {
        return employeeRepo.findById(id) // Fetch the existing employee
                .map(employee -> {
                    // Update field
                    employee.setPhotoPath(newPhotoPath);
                    // Save the updated employee
                    return employeeRepo.save(employee);
                })
                .orElseThrow(() -> new RuntimeException("Employee not found with id " + id));
    }
}
