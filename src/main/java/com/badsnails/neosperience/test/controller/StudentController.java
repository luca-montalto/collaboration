package com.badsnails.neosperience.test.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.badsnails.neosperience.test.model.Student;
import com.badsnails.neosperience.test.service.OperationService;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
public class StudentController {
	
	@Autowired
	private OperationService operationService;
	
	@GetMapping("/students")
	  public ResponseEntity<List<Student>> getAllStudents() {
	    try {
	      List<Student> students = new ArrayList<Student>();
	      students=operationService.getAllStudent();

	      if (students.isEmpty()) {
	        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	      }

	      return new ResponseEntity<>(students, HttpStatus.OK);
	    } catch (Exception e) {
	      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	  }
	
	@GetMapping("/get_age_student")
	  public ResponseEntity<Integer> getAgeStudent(@RequestParam(required = true) String badge) {
	    try {
	      int age = operationService.getAge(badge);
	      return new ResponseEntity<>(age, HttpStatus.OK);
	    } catch (Exception e) {
	      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	  }
	
	@GetMapping("/avg_grade_students")
	  public ResponseEntity<Double> getAvgGradeStudents() {
	    try {
	      double result=operationService.getAvgGrade();

	      return new ResponseEntity<>(result, HttpStatus.OK);
	    } catch (Exception e) {
	      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	  }
	
	@PostMapping("/create_student")
	  public ResponseEntity<Student > createStudent(@RequestParam(required = true) String name,@RequestParam(required = true) String surname,@RequestParam(required = true) String grades,@RequestParam(required = true) String birthdate) {
	    try {
	    	
	      Student student=new Student();
	      student.setName(name);
	      student.setSurname(surname);
	      student.setGrades(grades);
	      student.setBirthDate(birthdate);
	    	
	      Student result=operationService.create(student);

	      return new ResponseEntity<>(result, HttpStatus.OK);
	    } catch (Exception e) {
	      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	  }

}
