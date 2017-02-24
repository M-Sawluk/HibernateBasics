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
		Address address = new Address();
		
		address.setLocality("lublin");
		address.setStreet("glem");
		address.setZipcode("20020");
		address.setStreetNumber(11);
		
		
		employ.setFirstName("Jan");
		employ.setLastName("Kraw");
		employ.setSalary(3000);
		employ.setAdress(address);
		
		
		
		entityManager.getTransaction().begin();
		
		entityManager.persist(employ);
		entityManager.persist(address);
		
		entityManager.getTransaction().commit();
		
		entityManager.close();
		
		entityManagerFactory.close();

	}

}
