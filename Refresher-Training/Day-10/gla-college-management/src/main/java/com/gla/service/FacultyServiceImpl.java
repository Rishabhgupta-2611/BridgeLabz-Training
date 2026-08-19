package com.gla.service;

import com.gla.dto.FacultyDTO;
import com.gla.entity.Faculty;
import com.gla.exception.ResourceNotFoundException;
import com.gla.repository.FacultyRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FacultyServiceImpl implements FacultyService {

	private final FacultyRepository facultyRepository;

	public FacultyServiceImpl(FacultyRepository facultyRepository) {
		this.facultyRepository = facultyRepository;
	}

	@Override
	public FacultyDTO createFaculty(FacultyDTO dto) {
		// TODO Auto-generated method stub

		Faculty faculty = new Faculty();

		faculty.setFirstName(dto.getFirstName());
		faculty.setLastName(dto.getLastName());
		faculty.setGender(dto.getGender());
		faculty.setEmail(dto.getEmail());
		faculty.setAddress(dto.getAddress());
		faculty.setCity(dto.getCity());
		faculty.setState(dto.getState());
		faculty.setDepartment(dto.getDepartment());
		faculty.setDesignation(dto.getDesignation());
		faculty.setJoiningYear(dto.getJoiningYear());
		faculty.setSalary(dto.getSalary());

		Faculty savedFaculty = facultyRepository.save(faculty);

		return convertToDTO(savedFaculty);
	}

	@Override
	public FacultyDTO getFacultyById(Integer id) {
		// TODO Auto-generated method stub
		Faculty faculty = facultyRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Faculty not found with id: " + id));

        return convertToDTO(faculty);
	}

	@Override
	public List<FacultyDTO> getAllFaculty() {
		// TODO Auto-generated method stub
		return facultyRepository.findAll()
        .stream()
        .map(this::convertToDTO)
        .toList();
	}

	@Override
	public FacultyDTO updateFaculty(
            Integer id,
            FacultyDTO dto) {
		// TODO Auto-generated method stub

        Faculty faculty = facultyRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Faculty not found with id: " + id));

        faculty.setFirstName(dto.getFirstName());
        faculty.setLastName(dto.getLastName());
        faculty.setGender(dto.getGender());
        faculty.setEmail(dto.getEmail());
        faculty.setAddress(dto.getAddress());
        faculty.setCity(dto.getCity());
        faculty.setState(dto.getState());
        faculty.setDepartment(dto.getDepartment());
        faculty.setDesignation(dto.getDesignation());
        faculty.setJoiningYear(dto.getJoiningYear());
        faculty.setSalary(dto.getSalary());

        Faculty updatedFaculty =
                facultyRepository.save(faculty);

        return convertToDTO(updatedFaculty);
    }


	@Override
	public void deleteFaculty(Integer id) {
		// TODO Auto-generated method stub
		Faculty faculty = facultyRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Faculty not found with id: " + id));

        facultyRepository.delete(faculty);

	}

	@Override
	public List<FacultyDTO> getFacultyByDepartment(String department) {
		// TODO Auto-generated method stub
		return facultyRepository
                .findByDepartment(department)
                .stream()
                .map(this::convertToDTO)
                .toList();
	}

	@Override
	public List<Object[]> getMaximumSalaryByDepartment() {
		// TODO Auto-generated method stub
		return facultyRepository
                .findMaximumSalaryByDepartment();
	}

	@Override
	public List<FacultyDTO> getFacultyAboveDepartmentAverageSalary() {
		// TODO Auto-generated method stub
		return facultyRepository
                .findFacultyAboveDepartmentAverageSalary()
                .stream()
                .map(this::convertToDTO)
                .toList();
	}

	private FacultyDTO convertToDTO(Faculty faculty) {

		FacultyDTO dto = new FacultyDTO();

		dto.setFacultyId(faculty.getFacultyId());
		dto.setFirstName(faculty.getFirstName());
		dto.setLastName(faculty.getLastName());
		dto.setGender(faculty.getGender());
		dto.setEmail(faculty.getEmail());
		dto.setAddress(faculty.getAddress());
		dto.setCity(faculty.getCity());
		dto.setState(faculty.getState());
		dto.setDepartment(faculty.getDepartment());
		dto.setDesignation(faculty.getDesignation());
		dto.setJoiningYear(faculty.getJoiningYear());
		dto.setSalary(faculty.getSalary());

		return dto;
	}

}