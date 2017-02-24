package com.jpa.Michal;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.jpa.Michal.domain.Address;
import com.jpa.Michal.domain.Employee;

public class Main {

	public static void main(String[] args) {

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myDB");
		
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		Employee employ = new Employee();
		
		entityManager.getTransaction().begin();
		
		employ = entityManager.find(Employee.class, 1L);
		
		System.out.println(employ);

		employ.setSalary(50000);
		
		entityManager.getTransaction().commit();
		
		entityManager.close();
		
		entityManagerFactory.close();

	}

}
