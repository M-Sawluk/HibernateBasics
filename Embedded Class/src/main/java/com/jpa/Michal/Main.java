package com.jpa.Michal;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.jpa.Michal.domain.Employee;

public class Main {

	public static void main(String[] args) {

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myDB");
		
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		Employee employ = new Employee();
		
		employ.setFirstName("Jan");
		employ.setLastName("Kraw");
		employ.setSalary(3000);
		
		

			
		entityManager.getTransaction().begin();
		
		entityManager.persist(employ);
		entityManager.getTransaction().commit();
		
		entityManager.close();
		
		entityManagerFactory.close();

	}

}
