//package com.atta.Controller;
//
//import com.atta.entity.Patient;
//import com.atta.exception.ResourceNotFoundException;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//import com.atta.repository.PatientRepository;
//
//import javax.validation.Valid;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//@RestController
//@CrossOrigin(origins = "http://localhost:4200")
//@RequestMapping("/api/v1")
//public class PatientController
//{
//
//	@Autowired
//	private PatientRepository patientRepository;
//
//	@GetMapping("/patients")
//	public List<Patient> getAllPatients()
//	{
//		return patientRepository.findAll();
//	}
//
//	@GetMapping("/patients/{id}")
//	public ResponseEntity<Patient> getPatientById(@PathVariable(value = "id") Long patientId) throws ResourceNotFoundException
//	{
//		Patient patient = patientRepository.findById(patientId)
//				.orElseThrow(() -> new ResourceNotFoundException("Patient not found for this id :: " + patientId));
//		return ResponseEntity.ok().body(patient);
//	}
//
//	@PostMapping("/patients")
//	public Patient createPatient(@Valid @RequestBody Patient patient)
//	{
//		return patientRepository.save(patient);
//	}
//
//	@PutMapping("/patients/{id}")
//	public ResponseEntity<Patient> updatePatient(@PathVariable(value = "id") Long patientId, @Valid @RequestBody Patient patientDetails)
//			throws ResourceNotFoundException
//	{
//		Patient patient = patientRepository.findById(patientId)
//				.orElseThrow(() -> new ResourceNotFoundException("Patient not found for this id :: " + patientId));
//		patient.setFullName(patientDetails.getFullName());
//		patient.setPhoneNumber(patientDetails.getPhoneNumber());
//		final Patient updatedPatient = patientRepository.save(patient);
//		return ResponseEntity.ok(updatedPatient);
//	}
//
//	@DeleteMapping("/patients/{id}")
//	public Map<String, Boolean> deletePatient(@PathVariable(value = "id") Long patientId) throws ResourceNotFoundException
//	{
//		Patient patient = patientRepository.findById(patientId)
//				.orElseThrow(() -> new ResourceNotFoundException("Patient not found for this id :: " + patientId));
//		patientRepository.delete(patient);
//		Map<String, Boolean> response = new HashMap<>();
//		response.put("deleted", Boolean.TRUE);
//		return response;
//	}
//
//
//
//}
