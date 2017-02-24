package com.jpa.Michal.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.SecondaryTable;
import javax.persistence.Table;

@Entity


public class Employee {

	@Id
	@GeneratedValue
	private long id;

	private String firstName;
	
	private String lastName;
	
	public Employee() {
		
	}

	public Employee(String firstName, String lastName, double salary) {
		
		this.firstName = firstName;
		this.lastName = lastName;
		this.salary = salary;
	}

	private double salary;

	@ManyToMany(mappedBy="employees")
	List<Project> project = new ArrayList<Project>();

	public List<Project> getProject() {
		return project;
	}

	public void setProject(List<Project> project) {
		this.project = project;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

}
