package com.atta.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "patient")
public class Patient  implements Serializable
{
	@Id
	@GeneratedValue
	private Long id;
	private String name;
	@OneToMany(mappedBy = "patient", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	List<Appointment> history;

	public Patient()
	{
	}

	public Patient(String name, List<Appointment> history)
	{
		this.name = name;
		this.history = history;
	}

	public Long getId()
	{
		return id;
	}

	public void setId(Long id)
	{
		this.id = id;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public List<Appointment> getHistory()
	{
		return history;
	}

	public void setHistory(List<Appointment> history)
	{
		this.history = history;
	}

	@Override
	public String toString()
	{
		return "Patient{" + "id=" + id + ", name='" + name + '\'' + ", history=" + history + '}';
	}
}
