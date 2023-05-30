package com.example.mySqlDatabase.model;

import com.example.mySqlDatabase.dto.UserDto;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "EmployeeDetails")
public class User {
    @Id
    @GeneratedValue()
    private int id;

    private String name;
    private int salary;

    public User() {

    }

    public User(UserDto userDto) {
        name = userDto.name;
        salary = userDto.salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }
}
