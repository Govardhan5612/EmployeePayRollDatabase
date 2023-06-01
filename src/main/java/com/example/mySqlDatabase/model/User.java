package com.example.mySqlDatabase.model;

import com.example.mySqlDatabase.dto.UserDto;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "EmployeeDetails")
@Data
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue()
    private int id;

    private String firstName;
    private String lastName;
    private String gender;
    private long salary;

    public User(UserDto userDto) {
        firstName=userDto.getFirstName();
        lastName= userDto.getLastName();
        gender=userDto.getGender();
        salary= userDto.getSalary();
    }


}
