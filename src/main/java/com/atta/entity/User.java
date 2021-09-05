package com.atta.entity;

import javax.persistence.*;

@Entity
@Table(name = "User")
public class User
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(nullable = false)
	private String name;
	@Column(nullable = false)
	private boolean isAdmin;

	public User()
	{
	}

	public User(String name, boolean isAdmin)
	{
		this.name = name;
		this.isAdmin = isAdmin;
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

	public boolean isIsAdmin()
	{
		return isAdmin;
	}

	public void setIsAdmin(boolean admin)
	{
		this.isAdmin = admin;
	}

	@Override
	public String toString()
	{
		return "User{" + "id=" + id + ", name='" + name + '\'' + ", isAdmin=" + isAdmin + '}';
	}
}
