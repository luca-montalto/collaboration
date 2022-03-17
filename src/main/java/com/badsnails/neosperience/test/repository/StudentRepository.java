package com.badsnails.neosperience.test.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.badsnails.neosperience.test.model.Student;

public interface StudentRepository extends MongoRepository<Student, String> {

 public Student findByBadge(String badge);
 public Student findByGrades(String grade);
 public List<Student> findByName(String name);
}
