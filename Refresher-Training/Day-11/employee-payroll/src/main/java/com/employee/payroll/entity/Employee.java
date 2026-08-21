package com.employee.payroll.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;

import java.time.LocalDate;

@Entity
@Table(name = "employees")
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank(message = "Employee name is required")
	@Column(nullable = false)
	private String name;

	@NotBlank(message = "Email is required")
	@Email(message = "Enter a valid email")
	@Column(nullable = false, unique = true)
	private String email;

	@NotBlank(message = "Department is required")
	private String department;

	@NotBlank(message = "Designation is required")
	private String designation;

	@NotNull(message = "Basic salary is required")
	@PositiveOrZero(message = "Basic salary cannot be negative")
	private Double basicSalary;

	@NotNull(message = "Allowance is required")
	@PositiveOrZero(message = "Allowance cannot be negative")
	private Double allowance;

	@NotNull(message = "Deduction is required")
	@PositiveOrZero(message = "Deduction cannot be negative")
	private Double deduction;

	private Double grossSalary;

	private Double netSalary;

	private LocalDate joiningDate;

	public Employee() {
	}

	public Employee(Long id, String name, String email, String department, String designation, Double basicSalary,
			Double allowance, Double deduction, Double grossSalary, Double netSalary, LocalDate joiningDate) {

		this.id = id;
		this.name = name;
		this.email = email;
		this.department = department;
		this.designation = designation;
		this.basicSalary = basicSalary;
		this.allowance = allowance;
		this.deduction = deduction;
		this.grossSalary = grossSalary;
		this.netSalary = netSalary;
		this.joiningDate = joiningDate;
	}

	@PrePersist
	@PreUpdate
	public void calculateSalary() {

		if (basicSalary == null) {
			basicSalary = 0.0;
		}

		if (allowance == null) {
			allowance = 0.0;
		}

		if (deduction == null) {
			deduction = 0.0;
		}

		grossSalary = basicSalary + allowance;
		netSalary = grossSalary - deduction;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public Double getBasicSalary() {
		return basicSalary;
	}

	public void setBasicSalary(Double basicSalary) {
		this.basicSalary = basicSalary;
	}

	public Double getAllowance() {
		return allowance;
	}

	public void setAllowance(Double allowance) {
		this.allowance = allowance;
	}

	public Double getDeduction() {
		return deduction;
	}

	public void setDeduction(Double deduction) {
		this.deduction = deduction;
	}

	public Double getGrossSalary() {
		return grossSalary;
	}

	public void setGrossSalary(Double grossSalary) {
		this.grossSalary = grossSalary;
	}

	public Double getNetSalary() {
		return netSalary;
	}

	public void setNetSalary(Double netSalary) {
		this.netSalary = netSalary;
	}

	public LocalDate getJoiningDate() {
		return joiningDate;
	}

	public void setJoiningDate(LocalDate joiningDate) {
		this.joiningDate = joiningDate;
	}
}