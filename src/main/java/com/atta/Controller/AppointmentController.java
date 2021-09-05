package com.atta.Controller;

import com.atta.entity.Appointment;
import com.atta.exception.ResourceNotFoundException;
import com.atta.repository.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import static org.hibernate.type.descriptor.java.DateTypeDescriptor.DATE_FORMAT;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/v1")
public class AppointmentController
{
	@Autowired
	private AppointmentRepository appointmentRepository;

	@GetMapping("/appointments")
	public List<Appointment> getAllAppointments()
	{
		return appointmentRepository.findAll();
	}

	@GetMapping("/appointments/{id}")
	public ResponseEntity<Appointment> getAppointmentById(@PathVariable(value = "id") Long appointmentId) throws ResourceNotFoundException
	{
		Appointment appointment = appointmentRepository.findById(appointmentId)
				.orElseThrow(() -> new ResourceNotFoundException("Appointment not found for this id :: " + appointmentId));
		return ResponseEntity.ok().body(appointment);
	}

	@GetMapping("/appointments/date/{date}")
	public List<Appointment> getAppointmentsByDate(@PathVariable(value = "date") String date) throws ResourceNotFoundException, ParseException
	{
		SimpleDateFormat formatter = new SimpleDateFormat("EE MMM dd HH:mm:ss z yyyy", Locale.ENGLISH);
		Date dateConverted = formatter.parse(date);
		return appointmentRepository.getAppointmentsByDate(dateConverted);
	}

	@GetMapping("/appointments/patient/{patientName}")
	public List<Appointment> getAppointmentsByPatientName(@PathVariable(value = "patientName") String patientName) throws ResourceNotFoundException, ParseException
	{
		return appointmentRepository.getAppointmentsByPatientName(patientName);
	}

	@PostMapping("/appointments")
	public Appointment createAppointment(@Valid @RequestBody Appointment appointment)
	{
		return appointmentRepository.save(appointment);
	}

	@PutMapping("/appointments/{id}")
	public ResponseEntity<Appointment> updateAppointment(@PathVariable(value = "id") Long appointmentId,
			@Valid @RequestBody Appointment appointmentDetails) throws ResourceNotFoundException
	{
		Appointment appointment = appointmentRepository.findById(appointmentId)
				.orElseThrow(() -> new ResourceNotFoundException("Appointment not found for this id :: " + appointmentId));
		appointment.setDate(appointmentDetails.getDate());
		appointment.setReason(appointmentDetails.getReason());
		appointment.setCancel(appointmentDetails.isCancel());
		appointment.setPatient(appointmentDetails.getPatient());
		final Appointment updatedAppointment = appointmentRepository.save(appointment);
		return ResponseEntity.ok(updatedAppointment);
	}

	@DeleteMapping("/appointments/{id}")
	public Map<String, Boolean> deleteAppointment(@PathVariable(value = "id") Long appointmentId) throws ResourceNotFoundException
	{
		Appointment appointment = appointmentRepository.findById(appointmentId)
				.orElseThrow(() -> new ResourceNotFoundException("Appointment not found for this id :: " + appointmentId));
		appointmentRepository.delete(appointment);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}

	@DeleteMapping("/appointments/cancel/{id}")
	public Map<String, Boolean> cancelAppointment(@PathVariable(value = "id") Long appointmentId) throws ResourceNotFoundException
	{
		Appointment appointment = appointmentRepository.findById(appointmentId)
				.orElseThrow(() -> new ResourceNotFoundException("Appointment not found for this id :: " + appointmentId));
		appointment.setCancel(true);
		Map<String, Boolean> response = new HashMap<>();
		response.put("canceled", Boolean.TRUE);
		return response;
	}
}
