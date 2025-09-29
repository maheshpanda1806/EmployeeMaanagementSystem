package com.ems.EmployeeManagementSystem.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Employee {
    @Id
    private long uid;

    private String name;
    private double salaryPA;
    private String photoPath;
}
