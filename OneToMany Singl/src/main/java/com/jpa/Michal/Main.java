package com.jpa.Michal;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.jpa.Michal.domain.Employee;
import com.jpa.Michal.domain.Phone;


public class Main {

	public static void main(String[] args) {

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myDB");
		
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		Employee employ = new Employee();
		
		Phone phone1 = new Phone();
		Phone phone2 = new Phone();
		
		employ.setFirstName("Adam");
		employ.setLastName("Nowak");
		employ.setSalary(2000.3);
		
		phone1.setType("mobile");
		phone2.setType("mobile");
		phone1.setNumer("2352352");
		phone2.setNumer("353555235");
		
		List<Phone> phones = new ArrayList<Phone>();
		
		phones.add(phone1);
		phones.add(phone2);
		
		employ.setPhones(phones);
		
		
			
		entityManager.getTransaction().begin();
		
		
		entityManager.persist(employ);
		entityManager.persist(phone1);
		entityManager.persist(phone2);
		
		
		entityManager.getTransaction().commit();
		
		entityManager.close();
		
		entityManagerFactory.close();

	}

}
