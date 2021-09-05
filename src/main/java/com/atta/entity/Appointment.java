package com.atta.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

@Entity
@Table(name = "appointment")
public class Appointment implements Serializable
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(nullable = false)
	private Date date;
	@Column(nullable = false)
	private String reason;
	private boolean cancel;
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "patient_id", nullable = false)
	private Patient patient;

	public Appointment()
	{
	}

	public Appointment(String reason, Date date, boolean cancel, Patient patient)
	{
		this.reason = reason;
		this.date = date;
		this.cancel = cancel;
		this.patient = patient;
	}

	public Long getId()
	{
		return id;
	}

	public void setId(Long id)
	{
		this.id = id;
	}

	public Date getDate()
	{
		return date;
	}

	public void setDate(Date date)
	{
		this.date = date;
	}

	public String getReason()
	{
		return reason;
	}

	public void setReason(String reason)
	{
		this.reason = reason;
	}

	public boolean isCancel()
	{
		return cancel;
	}

	public void setCancel(boolean cancel)
	{
		this.cancel = cancel;
	}

	public Patient getPatient()
	{
		return patient;
	}

	public void setPatient(Patient patient)
	{
		this.patient = patient;
	}

	@Override
	public String toString()
	{
		return "Appointment{" + "id=" + id + ", date=" + date + ", reason='" + reason + '\'' + ", cancel=" + cancel + ", patient=" + patient + '}';
	}
}
