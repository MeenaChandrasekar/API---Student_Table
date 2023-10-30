package com.Student.Spring.Boot.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Student.Spring.Boot.Entity.Student;

public interface StudentRepo extends JpaRepository<Student,Integer>{
	
	

}
