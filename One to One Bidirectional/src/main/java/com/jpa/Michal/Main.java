package com.jpa.Michal;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.jpa.Michal.domain.Cat;
import com.jpa.Michal.domain.Owner;




public class Main {

	public static void main(String[] args) {

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myDB");
		
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		Owner owner = new Owner();
		
		Cat cat = new Cat();
		Cat cat1 = new Cat();
		
		
		owner.setFirstName("Michal");
		owner.setLastName("Hah");
		owner.setCat(cat1);
		cat1.setName("bonifacy");
		cat1.setOwner(owner);
		
		
			
		entityManager.getTransaction().begin();
		
		entityManager.persist(owner);

		entityManager.persist(cat);

		entityManager.persist(cat1);
		
		entityManager.getTransaction().commit();
		
		entityManager.refresh(cat);
		
		
		entityManager.close();
		
		entityManagerFactory.close();

	}

}
