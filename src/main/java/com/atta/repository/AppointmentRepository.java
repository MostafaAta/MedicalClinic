package com.atta.repository;

import com.atta.entity.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Long>
{
	@Query("FROM Appointment a where a.date = date ORDER BY a.date DESC")
	List<Appointment> getAppointmentsByDate(Date date);

	@Query("FROM Appointment a left join Patient p on p.id = a.id where p.name like :searchName")
	List<Appointment> getAppointmentsByPatientName(String searchName);


}
