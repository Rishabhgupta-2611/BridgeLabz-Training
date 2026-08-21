package com.employee.payroll.service;

import com.employee.payroll.dto.EmployeeDTO;
import com.employee.payroll.entity.Employee;
import com.employee.payroll.exception.EmployeeNotFoundException;
import com.employee.payroll.repository.EmployeeRepository;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	private final EmployeeRepository employeeRepository;

	public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}

	@Override
	public EmployeeDTO addEmployee(EmployeeDTO employeeDTO) {

		Employee employee = convertToEntity(employeeDTO);

		Employee savedEmployee = employeeRepository.save(employee);

		return convertToDTO(savedEmployee);
	}

	@Override
	public List<EmployeeDTO> getAllEmployees() {

		return employeeRepository.findAll().stream().map(this::convertToDTO).toList();
	}

	@Override
	public EmployeeDTO getEmployeeById(Long id) {

		Employee employee = employeeRepository.findById(id)
				.orElseThrow(() -> new EmployeeNotFoundException("Employee not found with id: " + id));

		return convertToDTO(employee);
	}

	@Override
	public EmployeeDTO updateEmployee(Long id, EmployeeDTO employeeDTO) {

		Employee existingEmployee = employeeRepository.findById(id)
				.orElseThrow(() -> new EmployeeNotFoundException("Employee not found with id: " + id));

		existingEmployee.setName(employeeDTO.getName());
		existingEmployee.setEmail(employeeDTO.getEmail());
		existingEmployee.setDepartment(employeeDTO.getDepartment());
		existingEmployee.setDesignation(employeeDTO.getDesignation());
		existingEmployee.setBasicSalary(employeeDTO.getBasicSalary());
		existingEmployee.setAllowance(employeeDTO.getAllowance());
		existingEmployee.setDeduction(employeeDTO.getDeduction());
		existingEmployee.setJoiningDate(employeeDTO.getJoiningDate());

		Employee updatedEmployee = employeeRepository.save(existingEmployee);

		return convertToDTO(updatedEmployee);
	}

	@Override
	public void deleteEmployee(Long id) {

		if (!employeeRepository.existsById(id)) {
			throw new EmployeeNotFoundException("Employee not found with id: " + id);
		}

		employeeRepository.deleteById(id);
	}

	@Override
	public List<EmployeeDTO> getEmployeesByDepartment(String department) {

		return employeeRepository.findByDepartmentIgnoreCase(department).stream().map(this::convertToDTO).toList();
	}

	@Override
	public List<EmployeeDTO> getEmployeesByDesignation(String designation) {

		return employeeRepository.findByDesignationIgnoreCase(designation).stream().map(this::convertToDTO).toList();
	}

	private Employee convertToEntity(EmployeeDTO dto) {

		Employee employee = new Employee();

		employee.setName(dto.getName());
		employee.setEmail(dto.getEmail());
		employee.setDepartment(dto.getDepartment());
		employee.setDesignation(dto.getDesignation());
		employee.setBasicSalary(dto.getBasicSalary());
		employee.setAllowance(dto.getAllowance());
		employee.setDeduction(dto.getDeduction());
		employee.setJoiningDate(dto.getJoiningDate());

		return employee;
	}

	private EmployeeDTO convertToDTO(Employee employee) {

		EmployeeDTO dto = new EmployeeDTO();

		dto.setId(employee.getId());
		dto.setName(employee.getName());
		dto.setEmail(employee.getEmail());
		dto.setDepartment(employee.getDepartment());
		dto.setDesignation(employee.getDesignation());
		dto.setBasicSalary(employee.getBasicSalary());
		dto.setAllowance(employee.getAllowance());
		dto.setDeduction(employee.getDeduction());
		dto.setGrossSalary(employee.getGrossSalary());
		dto.setNetSalary(employee.getNetSalary());
		dto.setJoiningDate(employee.getJoiningDate());

		return dto;
	}
}