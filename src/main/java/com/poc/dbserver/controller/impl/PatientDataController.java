package com.poc.dbserver.controller.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.poc.dbserver.controller.IpatientDataController;
import com.poc.dbserver.model.Patient;
import com.poc.dbserver.service.IPatientService;

@RestController
@RequestMapping("/patient")
public class PatientDataController implements IpatientDataController {

	@Autowired
	IPatientService patientService;

	@Override
	public boolean savePatientData(@RequestBody Patient patientDetails) {
		boolean status = patientService.savePatientInformation(patientDetails);
		return status;
	}

	@Override
	public List<Patient> saveAllPatients(@RequestBody List<Patient> patientDetails) {
		return patientService.saveAll(patientDetails);
	}

	@Override
	public Patient getPatientDetails(@PathVariable("patientId") Long id) {
		return patientService.getByPatientId(id).orElse(null);
	}

	@Override
	public void removePatientDetails(@PathVariable("patientId") Long id) {
		try {
			patientService.deleteByID(id);
		} catch (EmptyResultDataAccessException ex) {
			ex.printStackTrace();
		}
	}

	@Override
	public boolean updateExistingPatient(@PathVariable("patientId") Long id, @RequestBody Patient patientDetails) {
		return patientService.updatePatient(id, patientDetails);
	}

	@Override
	public List<Patient> searchPatient(@RequestBody Patient patientDetails){
		return (patientDetails==null) ?  null :  patientService.searchPatientByIdAndNameAndAgeAndGenderAndAccessionNumberAndDOB(patientDetails);
	  }

	@Override
	public boolean checkPatientAvailability(@RequestBody List<Patient> patientDetails) {
		return patientService.isPatientAvailable(patientDetails);
	}
}
