package com.Student.Spring.Boot.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Student.Spring.Boot.Entity.Student;
import com.Student.Spring.Boot.Repository.StudentRepo;

@Service
public class StudentService {
	@Autowired
	private StudentRepo studentRepo;
	
	public Student saveDetails(Student student) {
		return studentRepo.save(student);
	}
	
	public Student updateDetails(Student student) {
		Student updateStudent=studentRepo.findById(student.getId()).orElse(null);
		if(updateStudent!=null) {
			updateStudent.setMark(student.getMark());
			updateStudent.setName(student.getName());
			studentRepo.save(updateStudent);
			return updateStudent;
		}
		return null;
	}
	
	public Student getStudentById(int id) {
	    return studentRepo.findById(id).orElse(null);
	}

	
	public String deleteStudent(int id) {
        studentRepo.deleteById(id);
        return "Student with ID " + id + " deleted successfully";
    }

}
