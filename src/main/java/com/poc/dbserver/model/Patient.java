package com.poc.dbserver.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "Patient")
public class Patient {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name="name")
	private String name;
	
	public Patient() {
		super();
	}

	public Patient(String name, int age, String gender, Long accessionNumber, LocalDate dob) {
		super();
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.accessionNumber = accessionNumber;
		this.dob = dob;
	}

	public Patient(Patient patientDetails) {
		this.name = patientDetails.getName();
		this.age = patientDetails.getAge();
		this.gender = patientDetails.getGender();
		this.accessionNumber = patientDetails.getAccessionNumber();
		this.dob = patientDetails.getDob();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Long getAccessionNumber() {
		return accessionNumber;
	}

	public void setAccessionNumber(Long accessionNumber) {
		this.accessionNumber = accessionNumber;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	@Column(name="age")
	private int age;
	
	@Column(name="gender", length = 1)
	private String gender;
	
	@Column(name="accessionNumber")
	private Long accessionNumber;
	
	@Column(name="dob")
	private LocalDate dob;
}
