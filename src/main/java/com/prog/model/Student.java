package com.prog.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Students")

public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long stu_id;
	
	
	@Column(name="stu_name")
    private String stu_name;
	
	
	@Column(name="stu_age")
    private int stu_age;
	
	@Column(name="stu_address")
    private String stu_address;
	

	public Long getStu_id() {
		return stu_id;
	}


	public void setStu_id(Long stu_id) {
		this.stu_id = stu_id;
	}


	public String getStu_name() {
		return stu_name;
	}


	public void setStu_name(String stu_name) {
		this.stu_name = stu_name;
	}


	public int getStu_age() {
		return stu_age;
	}


	public void setStu_age(int stu_age) {
		this.stu_age = stu_age;
	}


	public String getStu_address() {
		return stu_address;
	}


	public void setStu_address(String stu_address) {
		this.stu_address = stu_address;
	}
	
	public Student(Long stu_id, String stu_name, int stu_age, String stu_address) {
		super();
		this.stu_id = stu_id;
		this.stu_name = stu_name;
		this.stu_age = stu_age;
		this.stu_address = stu_address;
	}
    
	public Student() {
		
	}


	@Override
	public String toString() {
		return "Student [stu_id=" + stu_id + ", stu_name=" + stu_name + ", stu_age=" + stu_age + ", stu_address="
				+ stu_address + "]";
	}
	
	
	
}

