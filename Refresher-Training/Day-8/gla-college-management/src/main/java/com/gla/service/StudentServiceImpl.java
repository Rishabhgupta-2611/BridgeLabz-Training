package com.gla.service;

import com.gla.dto.StudentDTO;
import com.gla.entity.Student;
import com.gla.exception.ResourceNotFoundException;
import com.gla.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

	private final StudentRepository studentRepository;

	public StudentServiceImpl(StudentRepository studentRepository) {
		this.studentRepository = studentRepository;
	}

	@Override
	public StudentDTO createStudent(StudentDTO dto) {

		Student student = new Student();

		student.setRollNumber(dto.getRollNumber());
		student.setFirstName(dto.getFirstName());
		student.setLastName(dto.getLastName());
		student.setGender(dto.getGender());
		student.setEmail(dto.getEmail());
		student.setAddress(dto.getAddress());
		student.setCity(dto.getCity());
		student.setState(dto.getState());
		student.setCourse(dto.getCourse());
		student.setDepartment(dto.getDepartment());
		student.setAdmissionYear(dto.getAdmissionYear());

		Student savedStudent = studentRepository.save(student);

		return convertToDTO(savedStudent);
	}

	private StudentDTO convertToDTO(Student student) {
		// TODO Auto-generated method stub

		StudentDTO dto = new StudentDTO();

		dto.setStudentId(student.getStudentId());
		dto.setRollNumber(student.getRollNumber());
		dto.setFirstName(student.getFirstName());
		dto.setLastName(student.getLastName());
		dto.setGender(student.getGender());
		dto.setEmail(student.getEmail());
		dto.setAddress(student.getAddress());
		dto.setCity(student.getCity());
		dto.setState(student.getState());
		dto.setCourse(student.getCourse());
		dto.setDepartment(student.getDepartment());
		dto.setAdmissionYear(student.getAdmissionYear());

		return dto;
	}

	@Override
	public StudentDTO getStudentById(Integer id) {
		// TODO Auto-generated method stub
		Student student = studentRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Student not found with id: " + id));

		return convertToDTO(student);
	}

	@Override
	public List<StudentDTO> getAllStudents() {
		// TODO Auto-generated method stub
		return studentRepository.findAll().stream().map(this::convertToDTO).toList();
	}

	@Override
	public StudentDTO updateStudent(Integer id, StudentDTO dto) {
		// TODO Auto-generated method stub

		Student student = studentRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Student not found with id: " + id));

		student.setRollNumber(dto.getRollNumber());
		student.setFirstName(dto.getFirstName());
		student.setLastName(dto.getLastName());
		student.setGender(dto.getGender());
		student.setEmail(dto.getEmail());
		student.setAddress(dto.getAddress());
		student.setCity(dto.getCity());
		student.setState(dto.getState());
		student.setCourse(dto.getCourse());
		student.setDepartment(dto.getDepartment());
		student.setAdmissionYear(dto.getAdmissionYear());

		Student updatedStudent = studentRepository.save(student);

		return convertToDTO(updatedStudent);
	}

	@Override
	public void deleteStudent(Integer id) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<StudentDTO> getStudentsByDepartment(String department) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<StudentDTO> getStudentsByCity(String city) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<StudentDTO> getStudentsByCourse(String course) {
		// TODO Auto-generated method stub
		return null;
	}
}