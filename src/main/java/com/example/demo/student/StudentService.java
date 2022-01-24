package com.example.demo.student;
import java.time.LocalDate;
import java.util.List;


import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;


@Service
public class StudentService {
    @GetMapping
	public List<Student> getStudents() {
		return List.of(new Student(0L, "", "", LocalDate.now(), 0), new Student(1L, "", "", LocalDate.now(), 0));
	}
}
