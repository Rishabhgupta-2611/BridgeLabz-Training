package com.gla.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class StudentDTO {

    private Integer studentId;

    @NotBlank(message = "Roll number is required")
    private String rollNumber;

    @NotBlank(message = "First name is required")
    private String firstName;

    private String lastName;

    private String gender;

    @Email(message = "Invalid email format")
    private String email;

    private String address;

    private String city;

    private String state;

    private String course;

    private String department;

    private Integer admissionYear;
}