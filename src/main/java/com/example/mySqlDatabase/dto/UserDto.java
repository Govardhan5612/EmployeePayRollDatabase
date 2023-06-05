package com.example.mySqlDatabase.dto;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.JoinColumn;
import jakarta.validation.constraints.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class UserDto {
    @Pattern(regexp = "[A-Z]{1}[a-z]{2,}",message = "Invalid First name")
    @NotEmpty(message = "Not take empty values")
    private String firstName;
    @NotEmpty(message = "Not give empty values")
    @Pattern(regexp = "[A-Z]{1}[a-z]{2,}",message = "Invalid Last name")
    private String lastName;
    @NotBlank(message = "Not take blank values")
    @Pattern(regexp = "male|female|Male|Female",message = "Invalid gender details only take male/female")
    private String gender;
    @NotNull(message = "Not take null input")
    @Min(value = 15000,message = "Minimum salary is 15000")
    @Max(value = 100000,message = "Maximum salary is 100000")
    private long salary;
    private LocalDate startDate;
    private String notes;
    private List<String> departments;

}
