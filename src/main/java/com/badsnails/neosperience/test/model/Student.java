package com.badsnails.neosperience.test.model;

import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "students")
public class Student {
	
	 public static final String ID_FIELD_NAME_ON_DATABASE = "_id";
	 
	 @Transient
	    public static final String SEQUENCE_NAME = "student_badge_sequence";
	
	  private String badge;
	  private String name;
	  private String surname;
	  private String grades;
	  private String birthDate;
	  
	  public Student() {
		   
	  }
	  
	  

	public Student(String badge, String name, String surname, String grades, String birthDate) {
		super();
		this.badge = badge;
		this.name = name;
		this.surname = surname;
		this.grades = grades;
		this.birthDate = birthDate;
	}



	public String getBadge() {
		return badge;
	}

	public void setBadge(String badge) {
		this.badge = badge;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getGrades() {
		return grades;
	}

	public void setGrades(String grades) {
		this.grades = grades;
	}

	public String getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}
	  
	

}
