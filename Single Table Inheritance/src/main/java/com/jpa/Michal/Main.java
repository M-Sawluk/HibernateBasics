package com.jpa.Michal;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.jpa.Michal.domain.Professor;
import com.jpa.Michal.domain.Student;


public class Main {

	public static void main(String[] args) {

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myDB");
		
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		Professor professor = new Professor();
		
		professor.setFirstName("Jan");
		professor.setLastName("Nowak");
		professor.setSalary(3000);
		
		Student student = new Student();
		
		student.setFirstName("Michal");
		student.setLastName("Sawluk");
		student.setAverageGrade(3.4);
		
		entityManager.getTransaction().begin();
		
		entityManager.persist(student);
		entityManager.persist(professor);
		
		entityManager.getTransaction().commit();
		
		entityManager.close();
		
		entityManagerFactory.close();

	}

}
