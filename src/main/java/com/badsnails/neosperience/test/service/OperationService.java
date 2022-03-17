package com.badsnails.neosperience.test.service;

import java.util.List;

import com.badsnails.neosperience.test.model.Student;

public interface OperationService {
	
	public List<Student> getAllStudent();
	public Double getAvgGrade();
	public int getAge(String regNumber);
	public Student create(Student student);

}
