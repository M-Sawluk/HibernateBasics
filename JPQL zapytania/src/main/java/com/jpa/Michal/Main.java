package com.jpa.Michal;

import java.util.ArrayList;
import java.util.Iterator;

import javax.management.Query;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;


import com.jpa.Michal.domain.Employee;

public class Main {

	
	private static EntityManagerFactory entityManagerFactory;
	private static EntityManager entityManager;
	
	public static void main(String[] args) {

		entityManagerFactory = Persistence.createEntityManagerFactory("myDB");
		
		entityManager = entityManagerFactory.createEntityManager();
			
		//addEmployees();
		
		TypedQuery<Employee> createQuery = entityManager.createQuery("select e from Employee e where e.salary>3000 order by e.salary  ", Employee.class);
		
		ArrayList<Employee> emplo = (ArrayList<Employee>) createQuery.getResultList();
		
		System.out.println(emplo);
		
		javax.persistence.Query query2 = entityManager.createQuery("select concat(e.firstName ,' ', e.lastName), e.salary*0.2 from Employee e");
		
		Iterator<?> iterator = query2.getResultList().iterator();
		
		while(iterator.hasNext())
		{
			Object[] item =(Object[]) iterator.next();
			String name = (String ) item[0];
			double tax = Double.valueOf(item[1].toString());
			
			System.out.println(name +" "+tax);
		}
		
		entityManager.close();
	
		entityManagerFactory.close();

	}

	private static void addEmployees()
	{
		addEmployee("I1","N1",2633);
		addEmployee("I2","N2",2345);
	
	
	}
	
	private static void addEmployee(String firstName,String lastName,int salary)
	{
		Employee employ =  new Employee();
		
		employ.setFirstName(firstName);
		employ.setLastName(lastName);
		employ.setSalary(salary);
		
		entityManager.getTransaction().begin();

		entityManager.persist(employ);
		
		entityManager.getTransaction().commit();
		
	}
	
	
}
