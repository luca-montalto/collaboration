package com.badsnails.neosperience.test.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.badsnails.neosperience.test.controller.model.Student;

public interface StudentRepository extends MongoRepository<Student, String> {
  List<Student> findByPublished(boolean published);
  List<Student> findByTitleContaining(String title);
}
