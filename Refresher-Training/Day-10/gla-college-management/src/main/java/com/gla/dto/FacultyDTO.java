package com.gla.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class FacultyDTO {

    private Integer facultyId;

    @NotBlank(message = "First name is required")
    private String firstName;

    @NotBlank(message = "Last name is required")
    private String lastName;

    @NotBlank(message = "Gender is required")
    private String gender;

    @Email(message = "Invalid email format")
    private String email;

    private String address;

    private String city;

    private String state;

    private String department;

    private String designation;

    private Integer joiningYear;

    private BigDecimal salary;
}