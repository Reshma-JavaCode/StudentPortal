package com.vcube.StudentPortal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vcube.StudentPortal.model.Student;
import com.vcube.StudentPortal.service.StudentService;

@CrossOrigin("*")
@RestController
@RequestMapping("/student")
public class StudentController {

	@Autowired
	StudentService ss;
	
	@GetMapping("/welcome")
	public String Hello()
	{
		return "Welcome to Spring boot student portal";
	}
	
	@PostMapping("/createStudent")
	public Student createStudent(@RequestBody Student s)
	{
		 System.out.println("First Name: " + s.getFname());
		    System.out.println("Last Name: " + s.getLname());
		    System.out.println("Age: " + s.getAge());
		    System.out.println("Marks: " + s.getTotal_marks());
		return ss.createStudent(s);
	}
	
	//end point: http://localhost:9988/student/getAllStudents
	@GetMapping("/getAllStudents")
	public List<Student> getAllStudents() {		
		return ss.getAllStudents();
	}
	
	//end point: http://localhost:9988/student/getStudent/3
	@GetMapping("/getStudent/{sid}")
	public Student findStudentById(@PathVariable Integer sid) {
		return ss.findStudentById(sid);
	}
	
	/* note */
	//if end points are same with different parameters then exception occurs because of ambiguity
	//ex:http://localhost:9988/student/getStudent/3
	//http://localhost:9988/student/getStudent/Pariha
	//here,parameters different but till getStudent is same so,
	//java.lang.IllegalStateException: Ambiguous
	
	//end point: http://localhost:9988/student/getStudent/fname/Pariha
	@GetMapping("/getStudent/fname/{fname}")
	public Student findStudentByFname(@PathVariable String fname)
	{
		return ss.findStudentByFname(fname);
	}
	
	//Update
	//end point: http://localhost:9988/student/updateStudentById/1
	@PutMapping("/updateStudentById/{sid}")
	Student updateStudentById(@RequestBody Student s,@PathVariable Integer sid)
	{
		return ss.updateStudentById(s, sid);
	}
	
	//Delete
	//end point: http://localhost:9988/student/deleteStudentById/2
	@DeleteMapping("/deleteStudentById/{sid}")
	String deleteStudentById(@PathVariable("sid") Integer id)
	{
		ss.deleteStudentById(id);
		return "Deleted student Id: "+id+" Successfully";
	}
	
	
	//Update only marks column
	//end point: http://localhost:9988/student/updatestudByMarks/1
	//in output give only marks value like :  900.8 , not in{}
	@PatchMapping("/updatestudByMarks/{sid}")
	public Student updateStudentMarks(@RequestBody Double marks,@PathVariable Integer sid) {
		return ss.updateStudentMarks(marks, sid);
	}
}
