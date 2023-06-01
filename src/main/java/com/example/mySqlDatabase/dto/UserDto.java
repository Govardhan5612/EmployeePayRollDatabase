package com.example.mySqlDatabase.dto;

import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class UserDto {
    @Pattern(regexp = "[A-Z]{1}[a-z]{2,}",message = "Invalid First name")
    @NotEmpty(message = "Not take empty values")
    private String firstName;
    @NotEmpty(message = "Not take empty values")
    @Pattern(regexp = "[A-Z]{1}[a-z]{2,}",message = "Invalid Last name")
    private String lastName;
    @NotBlank(message = "Not take blank values")
    @Pattern(regexp = "male|female|Male|Female",message = "Invalid gender details only take male/female")
    private String gender;
    @NotNull(message = "Not take null input")
    @Min(value = 15000,message = "Minimum salary is 15000")
    @Max(value = 50000,message = "Maximum salary is 50000")
    private long salary;
}
