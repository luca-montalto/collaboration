package com.badsnails.neosperience.test.service;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.badsnails.neosperience.test.model.Student;
import com.badsnails.neosperience.test.repository.StudentRepository;

@Service
public class OperationServiceImpl implements OperationService {
	
	@Autowired
	private StudentRepository studentRepository;
	
	@Autowired
	SequenceGeneratorService sequenceGenerator;
	

	public List<Student> getAllStudent() {
		return studentRepository.findAll();
	}

	public Double getAvgGrade() {
		Double result=0.0;
		List<Student> allStudent=studentRepository.findAll();
		Double sum=0.0;
		for (Student student : allStudent) {
			sum+=Double.parseDouble(student.getGrades());
		}
		result=sum/allStudent.size();
		return result;
	}

	public int getAge(String badge) {
		Student currentStudent=studentRepository.findByBadge(badge);
		LocalDate currentDate=LocalDate.now(); 
		LocalDate birthDate=LocalDate.parse(currentStudent.getBirthDate());
		return calculateAge(birthDate,currentDate);
	}

	private int calculateAge(LocalDate birthDate, LocalDate currentDate) {
        if ((birthDate != null) && (currentDate != null)) {
            return Period.between(birthDate, currentDate).getYears();
        } else {
            return 0;
        }
    }
	

	@Override
	public Student create(Student student) {
		
		student.setBadge(Integer.toString(sequenceGenerator.generateSequence(Student.SEQUENCE_NAME)));
		return studentRepository.insert(student);
	}
	
	
}
