package com.poc.dbserver.service.patient.repo;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.poc.dbserver.model.Patient;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {

	List<Patient> findByNameAndGender(String name, String gender);

	List<Patient> findPatientByName(String name);

	List<Patient> findPatientByAge(int age);

	List<Patient> findPatientByGender(String gender);

	List<Patient> findPatientByAccessionNumber(Long accessionNumber);

	List<Patient> findPatientByNameAndAgeAndGenderAndAccessionNumberAndDob(String name, int age, String gender,
			Long accessionNumber, LocalDate dob);

	List<Patient> findPatientByDob(LocalDate dob);

	List<Patient> findPatientByNameAndAgeAndGenderAndAccessionNumber(String name, int age, String gender,
			Long accessionNumber);

	List<Patient> findPatientByNameAndGenderAndAccessionNumber(String name, String gender, Long accessionNumber);

	List<Patient> findPatientByNameAndAccessionNumber(String name, Long accessionNumber);

	List<Patient> findPatientByNameAndGender(String name, String gender);

	List<Patient> findPatientByGenderAndAccessionNumber(String gender, Long accessionNumber);

	

}
