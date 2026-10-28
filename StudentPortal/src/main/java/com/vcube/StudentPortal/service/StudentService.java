package com.vcube.StudentPortal.service;

import java.util.List;

import com.vcube.StudentPortal.model.Student;

//What to do
public interface StudentService  {

	//Inserting data
	Student createStudent(Student s);
	
	//Retrieving data
	List<Student> getAllStudents();
	Student findStudentById(Integer sid);
	Student findStudentByFname(String fname);
	
	//update
	Student updateStudentById(Student s,Integer sid);
	//Delete
	void deleteStudentById(Integer id);
	
	Student updateStudentMarks(Double marks,Integer sid);
	
}
