package com.poc.dbserver.service.impl;

import java.time.LocalDate;
import java.time.Month;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.poc.dbserver.model.Patient;
import com.poc.dbserver.service.IPatientService;
import com.poc.dbserver.service.patient.repo.PatientRepository;

@Service
public class PatientService implements IPatientService{
	
	@Autowired
	private PatientRepository ipatientRepository;
	
	@PostConstruct
	public void testDataInset() {
		List<Patient> lstPatient = Arrays.asList(
				new Patient("Satish",29,"M", new Long("123"), LocalDate.of(1991, Month.MAY, 9)),
				new Patient("Abhishek",27,"M", new Long("1234"), LocalDate.of(1993, Month.JUNE, 10)),
				new Patient("Ritesh",28,"M", new Long("12345"), LocalDate.of(1992, Month.JULY, 5)),
				new Patient("Yudi",28,"M", new Long("123456"), LocalDate.of(1992, Month.AUGUST, 15)),
				new Patient("Amey",25,"M", new Long("1234567"), LocalDate.of(1996, Month.JANUARY, 19)),
				new Patient("Komal",30,"F", new Long("12345678"), LocalDate.of(1989, Month.FEBRUARY, 25)),
				new Patient("Varsha",26,"F", new Long("123456789"), LocalDate.of(1994, Month.DECEMBER, 21)),
				new Patient("Deep",30,"M", new Long("1234567890"), LocalDate.of(1989, Month.OCTOBER, 28))
				);
		saveAll(lstPatient);
	}
	
	@Override
	public boolean savePatientInformation(Patient patientDetails) {
		return ipatientRepository.save(patientDetails).getId().equals(patientDetails.getId());
	}
	
	public List<Patient> saveAll(List<Patient> patients) {
		return ipatientRepository.saveAll(patients);
	}
	
	public void deleteByID(Long id) throws EmptyResultDataAccessException{
		ipatientRepository.deleteById(id);
	}
	
	public Optional<Patient> getByPatientId(Long id) {
		return ipatientRepository.findById(id);
	}

	public boolean updatePatient(Long id, Patient patientDetails) {
		if(getByPatientId(id).isPresent()) {
			patientDetails.setId(id);
			return savePatientInformation(patientDetails);
		}
		return false;
	}
	
	public List<Patient> getByNameAndGender(Optional<String> name, Optional<String> gender){
		return ipatientRepository.findByNameAndGender(name.get(), gender.get());
	}
	
	public List<Patient> getPatientByName(String name){
		return ipatientRepository.findPatientByName(name);
	}
	
	public List<Patient> getPatientByAge(int age){
		return ipatientRepository.findPatientByAge(age);
	}
	public List<Patient> getPatientByGender(String gender){
		return ipatientRepository.findPatientByGender(gender);
	}
	public List<Patient> getPatientByAccessionNumber(Long accessionNumber){
		return ipatientRepository.findPatientByAccessionNumber(accessionNumber);
	}

	@Override
	public List<Patient> searchPatientByIdAndNameAndAgeAndGenderAndAccessionNumberAndDOB(Patient patientDetails) {
		Patient p = new Patient(patientDetails);
		if(p.getName()!=null && p.getAge()!=0 && p.getDob()!=null && p.getGender()!=null && p.getAccessionNumber()!=null) {
			return ipatientRepository.findPatientByNameAndAgeAndGenderAndAccessionNumberAndDob(p.getName(), p.getAge(), p.getGender(), p.getAccessionNumber(), p.getDob());	
		}else if(p.getName()!=null && p.getAge()!=0 && p.getGender()!=null && p.getAccessionNumber()!=null) {
			return ipatientRepository.findPatientByNameAndAgeAndGenderAndAccessionNumber(p.getName(), p.getAge(), p.getGender(), p.getAccessionNumber());	
		}else if(p.getName()!=null && p.getGender()!=null && p.getAccessionNumber()!=null) {
			return ipatientRepository.findPatientByNameAndGenderAndAccessionNumber(p.getName(), p.getGender(), p.getAccessionNumber());	
		}else if(p.getName()!=null && p.getAccessionNumber()!=null) {
			return ipatientRepository.findPatientByNameAndAccessionNumber(p.getName(), p.getAccessionNumber());	
		}else if(p.getName()!=null && p.getGender()!=null ) {
			return ipatientRepository.findPatientByNameAndGender(p.getName(), p.getGender());	
		}else if(p.getGender()!=null && p.getAccessionNumber()!=null) {
			return ipatientRepository.findPatientByGenderAndAccessionNumber(p.getGender(), p.getAccessionNumber());	
		}else if(p.getName()!=null ) {
			return ipatientRepository.findPatientByName(p.getName());	
		}else if(p.getAge()!=0) {
			return ipatientRepository.findPatientByAge(p.getAge());	
		}else if(p.getDob()!=null) {
			return ipatientRepository.findPatientByDob(p.getDob());	
		}else if(p.getGender()!=null) {
			return ipatientRepository.findPatientByGender(p.getGender());	
		}else if(p.getAccessionNumber()!=null) {
			return ipatientRepository.findPatientByAccessionNumber(p.getAccessionNumber());	
		}
		return null;
	}

}
