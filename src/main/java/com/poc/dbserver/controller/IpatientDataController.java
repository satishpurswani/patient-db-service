package com.poc.dbserver.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.poc.dbserver.model.Patient;

public interface IpatientDataController {

	@PostMapping("/add")
	public boolean savePatientData(@RequestBody Patient patientDetails);
	
	@PostMapping("/addPatients")
	public List<Patient> saveAllPatients(@RequestBody List<Patient> patientDetails);
	
	@GetMapping("/{patientId}")
	public Patient getPatientDetails(@PathVariable("patientId") Long id);
	
	@DeleteMapping("/remove/{patientId}")
	public void removePatientDetails(@PathVariable("patientId") Long id);
	
	@PutMapping("/update/{patientId}")
	public boolean updateExistingPatient(@PathVariable("patientId") Long id, @RequestBody Patient patientDetails);
	
	@GetMapping("/search") 
	public List<Patient> searchPatient(@RequestBody Patient patientDetails);
	
	@PostMapping("/checkPatientAvailability")
	public boolean checkPatientAvailability(@RequestBody List<Patient> patientDetails);
}
