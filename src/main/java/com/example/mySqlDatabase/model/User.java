package com.example.mySqlDatabase.model;

import com.example.mySqlDatabase.dto.UserDto;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

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
    private LocalDate startDate;
    private String notes;
    private String profilePic;
    @ElementCollection
    @CollectionTable(name = "Department")
    @JoinColumn(name = "id")
    private List<String> departments;


    public User(UserDto userDto) {
        firstName = userDto.getFirstName();
        lastName = userDto.getLastName();
        gender = userDto.getGender();
        salary = userDto.getSalary();
        startDate=userDto.getStartDate();
        notes=userDto.getNotes();
        profilePic=userDto.getProfilePic();
        departments=userDto.getDepartments();
    }


}
