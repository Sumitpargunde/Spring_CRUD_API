package com.prog.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prog.model.Student;
import com.prog.repository.StudentRepository;

@RestController
@RequestMapping("/api")
public class StudentController {
     
	@Autowired
	StudentRepository studentRepository;
	
	@PostMapping("/students")
	public String createNewStudent(@RequestBody Student student) {
		studentRepository.save(student);
		return "Student Profile created in database";
	}
	
	@GetMapping("/students")
	public ResponseEntity<List<Student>> getAllStudents(){
		List<Student> stuList = new ArrayList<>();
		studentRepository.findAll().forEach(stuList::add);
		return new ResponseEntity<List<Student>>(stuList, HttpStatus.OK);
	}
	
	@GetMapping("/students/{stu_id}")
	public ResponseEntity<Student> getStudentById(@PathVariable long stu_id){
		Optional<Student> stu = studentRepository.findById(stu_id);
		if(stu.isPresent()) {
			return new ResponseEntity<Student>(stu.get(), HttpStatus.FOUND);
		}else {
			return new ResponseEntity<Student>(HttpStatus.NOT_FOUND);
		}
		
	}
	
	@PutMapping("/students/{stu_id}")
	public String updateStudentById(@PathVariable long stu_id, @RequestBody Student student) {
	   Optional<Student> stu = studentRepository.findById(stu_id);
	   if(stu.isPresent()) {
		   Student existStu = stu.get();
		   existStu.setStu_name(student.getStu_name());
		   existStu.setStu_age(student.getStu_age());
		   existStu.setStu_address(student.getStu_address());
		   studentRepository.save(existStu);
		   return "Student details against Id " + stu_id +" updated";
	   }else {
		   return "Student details does not exist for student Id " + stu_id;
	   }
	}
	
	@DeleteMapping("/students/{stu_id}")
	public String deleteStudentByStuId(@PathVariable Long stu_id) {
		studentRepository.deleteById(stu_id);
		return "Student deleted successfully";
	}
	
	@DeleteMapping("/students")
	public String deleteAllStudents() {
		studentRepository.deleteAll();
		return "All Students deleted successfully";
	}
	
}
