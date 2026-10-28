package com.vcube.StudentPortal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vcube.StudentPortal.model.Student;
import com.vcube.StudentPortal.repo.StudentRepository;

@Service
public class StudentServiceImp implements StudentService{

	@Autowired
	StudentRepository sr;
	
	@Override
	public Student createStudent(Student s) {
		return sr.save(s);
	}

	@Override
	public List<Student> getAllStudents() {		
		return sr.findAll();
	}

	@Override
	public Student findStudentById(Integer sid) {

		return sr.findById(sid).orElseThrow();
		//orElseThrow(): If a value is present, 
		//returns the value, otherwise throws NoSuchElementException.
	}

	@Override
	public Student findStudentByFname(String fname) {
		return sr.findByFname(fname);
	}

	@Override
	public Student updateStudentById(Student s, Integer sid) {
		Student studOldInfo= findStudentById(sid);
		
		//updating old values with new student values which is given by user using json object
		studOldInfo.setAge(s.getAge());
		studOldInfo.setFname(s.getFname());
		studOldInfo.setLname(s.getLname());
		studOldInfo.setTotal_marks(s.getTotal_marks());
		
		//inserting updated values into db
		return sr.save(studOldInfo);
	}

	@Override
	public void deleteStudentById(Integer id) {
		 sr.deleteById(id);
	}

	@Override
	public Student updateStudentMarks(Double marks, Integer sid) {

		Student studOldInfo= findStudentById(sid);
		
		studOldInfo.setTotal_marks(marks);
		
		return sr.save(studOldInfo);
	}

}
