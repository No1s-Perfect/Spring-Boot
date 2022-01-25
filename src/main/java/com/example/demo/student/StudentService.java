package com.example.demo.student;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.UnaryOperator;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;


@Service
public class StudentService {

	private final StudentRepository studentRepository;

	@Autowired
	public StudentService(StudentRepository studentRepository) {
		this.studentRepository = studentRepository;
	}
    @GetMapping
	public List<Student> getStudents() {
	
		return studentRepository.findAll();
	}


	public void deleteStudent(Long id) {
		if(!studentRepository.existsById(id)){
			throw new IllegalStateException("Student with id: "+id+" not found");
		}
		studentRepository.deleteById(id);
	}
	public void createStudent(Student stud){
		if(studentRepository.findByEmail(stud.getEmail()).isPresent()) throw new IllegalStateException("Student already exists");
		studentRepository.save(stud);
		
 
	}

	@Transactional
	public void updateStudent(Long id, String name, String email){
		var student = studentRepository.findById(id).orElseThrow(()->new IllegalStateException("Student with id: "+id+" not found"));
		student.setName(name);
		student.setEmail(email);
	}
}
