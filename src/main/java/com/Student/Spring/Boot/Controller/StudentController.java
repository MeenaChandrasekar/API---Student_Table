package com.Student.Spring.Boot.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.Student.Spring.Boot.Entity.Student;
import com.Student.Spring.Boot.Service.StudentService;

@RestController
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	
	@PostMapping("/addStudent")
	public Student postDetails(@RequestBody Student student) {
		
		return studentService.saveDetails(student);		
	}
	@PutMapping("/updateStudent")
	public Student updateStudentDetails(@RequestBody Student student) {
		
		return studentService.updateDetails(student);		
	}
	
	@GetMapping("/getStudent/{id}")
	public ResponseEntity<Student> getStudentById(@PathVariable int id) {
	    Student student = studentService.getStudentById(id);
	    if (student != null) {
	        return new ResponseEntity<>(student, HttpStatus.OK);
	    } else {
	        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	}

	@DeleteMapping("/deleteStudent/{id}")
	public String deletefunction(@PathVariable int id)
	{
	return studentService.deleteStudent(id);
	}
}