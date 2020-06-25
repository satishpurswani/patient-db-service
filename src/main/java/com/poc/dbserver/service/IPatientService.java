package com.poc.dbserver.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.dao.EmptyResultDataAccessException;

import com.poc.dbserver.model.Patient;

public interface IPatientService {

	boolean savePatientInformation(Patient patientDetails);

	public Optional<Patient> getByPatientId(Long id);

	List<Patient> saveAll(List<Patient> patientDetails);

	void deleteByID(Long id) throws EmptyResultDataAccessException;

	boolean updatePatient(Long id, Patient patientDetails);

	List<Patient> getByNameAndGender(Optional<String> name, Optional<String> gender);

	List<Patient> searchPatientByIdAndNameAndAgeAndGenderAndAccessionNumberAndDOB(Patient patientDetails);

	boolean isPatientAvailable(List<Patient> patients);
}
