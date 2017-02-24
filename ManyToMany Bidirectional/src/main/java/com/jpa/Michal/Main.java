package com.jpa.Michal;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.jpa.Michal.domain.Employee;
import com.jpa.Michal.domain.Project;



public class Main {

	public static void main(String[] args) {

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myDB");
		
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		Employee employ = new Employee("Adam","Nowak",2121);
		Employee employ2 = new Employee("Michal","Kowalksi",24775);
		Employee employ3 = new Employee("marlej","pies",898989);
		
		
		Project proj1 = new Project();
		Project proj2 = new Project();
		
		proj1.setName("jeden");
		proj2.setName("dwa");
		
		List<Project> projekt1 = new ArrayList<Project>();
		List<Project> projekt2= new ArrayList<Project>();
		List<Project> projekt3= new ArrayList<Project>();
		
		
	
		List<Employee> staff1 = new ArrayList<Employee>();
		staff1.add(employ);
		staff1.add(employ2);
		staff1.add(employ3);
		
		List<Employee> staff2= new ArrayList<Employee>();
		staff2.add(employ2);
		staff2.add(employ3);
		
		proj1.setEmployees(staff1);
		proj2.setEmployees(staff2);
		
		projekt1.add(proj1);
		employ.setProject(projekt1);
		
		projekt2.add(proj2);
		projekt2.add(proj1);
		
		employ2.setProject(projekt2);
		
		projekt3.add(proj2);
		
		employ3.setProject(projekt3);
			
		entityManager.getTransaction().begin();
		
		
		entityManager.persist(employ);
		entityManager.persist(employ2);
		entityManager.persist(employ3);
		entityManager.persist(proj1);
		entityManager.persist(proj2);
		
		entityManager.getTransaction().commit();
		
		entityManager.close();
		
		entityManagerFactory.close();

	}

}
