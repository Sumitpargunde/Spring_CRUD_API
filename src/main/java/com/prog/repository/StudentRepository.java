package com.prog.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prog.model.Student;

public interface StudentRepository extends JpaRepository<Student, Long>{

}
