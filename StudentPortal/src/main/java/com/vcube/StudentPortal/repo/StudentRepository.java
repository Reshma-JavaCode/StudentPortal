package com.vcube.StudentPortal.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vcube.StudentPortal.model.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

	public Student findByFname(String fname);
}
